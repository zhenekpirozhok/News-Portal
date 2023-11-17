package com.newsportal.controller;

import com.newsportal.dto.NewsTitleDto;
import com.newsportal.model.News;
import com.newsportal.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<List<News>> getAllNews() {
        List<News> news = newsService.getAllNews();
        return ResponseEntity.ok(news);
    }

    @GetMapping("/titles")
    public ResponseEntity<List<NewsTitleDto>> getAllNewsTitles() {
        List<NewsTitleDto> titles = newsService.getAllNewsTitles();
        return ResponseEntity.ok(titles);
    }

    // Другие методы

}
