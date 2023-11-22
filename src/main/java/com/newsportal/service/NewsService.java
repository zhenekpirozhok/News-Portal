package com.newsportal.service;

import com.newsportal.dto.NewsDTO;
import com.newsportal.dto.NewsInfoDTO;
import com.newsportal.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<NewsInfoDTO> getTop25News() {
        return newsRepository.findTop25News(PageRequest.of(0, 25));
    }

    public List<NewsInfoDTO> getTop4TodayNewsByViews(LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.plusDays(1).atStartOfDay();
        PageRequest pageRequest = PageRequest.of(0, 4);
        return newsRepository.findTop4TodayNewsByViews(startOfDay, endOfDay, pageRequest).getContent();
    }

    public List<NewsInfoDTO> getTopNewsByAuthorToday(Long authorUserId) {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDay = LocalDate.now().plusDays(1).atStartOfDay();
        Pageable pageable = PageRequest.of(0, 4); // Top 4 news

        return newsRepository.findTopNewsByAuthorToday(authorUserId, startOfDay, endOfDay, pageable);
    }


    public List<NewsInfoDTO> getMainNews() {
        return newsRepository.findMainNews(PageRequest.of(0, 1));
    }


    public Page<NewsInfoDTO> getNewsByDate(LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.plusDays(1).atStartOfDay();
        Page<NewsInfoDTO> newsPage = newsRepository.findNewsByDate(startOfDay, endOfDay, PageRequest.of(0, 25));
        return newsPage;
    }


    public NewsDTO getNewsById(Long newsId) {
        return newsRepository.findNewsById(newsId);
    }

    public Page<NewsInfoDTO> getNewsPage(Pageable pageable) {
        return newsRepository.findNewsWithPagination(pageable);
    }
}
