package com.newsportal.controller;

import com.newsportal.dto.NewsCreateDTO;
import com.newsportal.dto.NewsDTO;
import com.newsportal.dto.NewsInfoDTO;
import com.newsportal.dto.NewsUpdateDTO;
import com.newsportal.service.NewsService;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }
    @Autowired
    private UserService userService;

      @GetMapping("/top25")
    public ResponseEntity<List<NewsInfoDTO>> getTop25News() {
        return ResponseEntity.ok(newsService.getTop25News());
    }

    @GetMapping("/top-today")
    public ResponseEntity<List<NewsInfoDTO>> getTop4TodayNewsByViews() {
        return ResponseEntity.ok(newsService.getTop4TodayNewsByViews(LocalDate.now()));
    }

    @GetMapping("/author/{authorUserId}/top-today")
    public ResponseEntity<List<NewsInfoDTO>> getTopNewsByAuthorToday(@PathVariable Long authorUserId) {
        List<NewsInfoDTO> newsList = newsService.getTopNewsByAuthorToday(authorUserId);
        return ResponseEntity.ok(newsList);
    }


    @GetMapping("/main")
    public ResponseEntity<List<NewsInfoDTO>> getMainNews() {
        return ResponseEntity.ok(newsService.getMainNews());

    }



    @GetMapping("/date/{date}")
    public ResponseEntity<List<NewsInfoDTO>> getNewsByDate(@PathVariable String date) {
        Page<NewsInfoDTO> newsPage = newsService.getNewsByDate(LocalDate.parse(date));
        List<NewsInfoDTO> newsList = newsPage.getContent(); // Extracts the list from the page
        return ResponseEntity.ok(newsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsDTO> getNewsById(@PathVariable Long id) {
        NewsDTO newsDTO = newsService.getNewsById(id);
        return ResponseEntity.ok(newsDTO);
    }

    @GetMapping("/button-more")
    public ResponseEntity<List<NewsInfoDTO>> getTop25News(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "25") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "publicAt", "priority"));
        Page<NewsInfoDTO> newsPage = newsService.getNewsPage(pageable);
        List<NewsInfoDTO> newsList = newsPage.getContent();
        return ResponseEntity.ok(newsList);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNews(@RequestBody NewsCreateDTO newsDTO) {
        if (!userService.isCurrentUserAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        newsService.createNews( newsDTO.getTitle(), newsDTO.getContent(), newsDTO.getImageUrl());
        return ResponseEntity.ok("News created successfully");
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<NewsInfoDTO>> searchNews(@PathVariable String keyword) {
        List<NewsInfoDTO> searchResults = newsService.searchNews(keyword);
        return ResponseEntity.ok(searchResults);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable Long id) {
        if (!userService.isCurrentUserAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        newsService.deleteNews(id);
        return ResponseEntity.ok("News item deleted successfully");
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateNews(@RequestBody NewsUpdateDTO newsUpdateDTO) {
        if (!userService.isCurrentUserAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        newsService.updateNews(newsUpdateDTO);
        return ResponseEntity.ok("News updated successfully");
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllNews() {
        if (!userService.isCurrentUserAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
          return ResponseEntity.ok(newsService.getAllNews());
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<?> getAdminNewsById(@PathVariable Long id) {
        if (!userService.isCurrentUserAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        return ResponseEntity.ok(newsService.getAdminNewsByID(id));
    }

    @GetMapping("/admin_date/{date}")
    public ResponseEntity<?> getNewsByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant date) {
        if (!userService.isCurrentUserAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        return ResponseEntity.ok(newsService.getNewsByDate(date));
    }

    @GetMapping("/admin_author/{authorId}")
    public ResponseEntity<?> getNewsByAuthor(@PathVariable Long authorId) {
        if (!userService.isCurrentUserAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        return ResponseEntity.ok(newsService.getNewsByAuthor(authorId));
    }
}
