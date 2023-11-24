package com.newsportal.controller;

import com.newsportal.dto.NewsDTO;
import com.newsportal.dto.NewsInfoDTO;
import com.newsportal.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> createNews(@RequestBody NewsDTO newsDTO) {
        newsService.createNews(newsDTO.getAuthorUserId(), newsDTO.getTitle(), newsDTO.getContent(), newsDTO.getImageUrl());
        return ResponseEntity.ok("Comment created successfully");
    }

}
