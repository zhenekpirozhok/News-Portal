package com.newsportal.service;

import com.newsportal.model.News;
import com.newsportal.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<String> getAllNewsTitles() {
        return newsRepository.findAllTitles();
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    // Другие методы
}