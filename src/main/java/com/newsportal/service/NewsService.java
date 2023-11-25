package com.newsportal.service;

import com.newsportal.dto.NewsDTO;
import com.newsportal.dto.NewsInfoDTO;
import com.newsportal.dto.NewsUpdateDTO;
import com.newsportal.model.News;
import com.newsportal.repository.NewsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
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

    public List<News> searchNews(String keyword) {
        return newsRepository.search(keyword);
    }

    public Page<NewsInfoDTO> getNewsPage(Pageable pageable) {
        return newsRepository.findNewsWithPagination(pageable);
    }


    @Transactional
    public void createNews(Long authorUserId, String title, String content, String imageUrl) {
        News news = new News();
        news.setAuthorUserId(authorUserId);
        news.setTitle(title);
        news.setContent(content);
        news.setImageUrl(imageUrl);
        news.setStatusId(1L);
        // createdAt and updatedAt are handled automatically
        newsRepository.save(news);
    }


    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    public void updateNews(NewsUpdateDTO newsUpdateDTO) {
        newsRepository.findById(newsUpdateDTO.getId()).ifPresent(news -> {
            if(newsUpdateDTO.getAuthorUserId() != null) news.setAuthorUserId(newsUpdateDTO.getAuthorUserId());
            if(newsUpdateDTO.getTitle() != null) news.setTitle(newsUpdateDTO.getTitle());
            if(newsUpdateDTO.getContent() != null) news.setContent(newsUpdateDTO.getContent());
            if(newsUpdateDTO.getImageUrl() != null) news.setImageUrl(newsUpdateDTO.getImageUrl());
            if(newsUpdateDTO.getIsMainNews() != null) news.setIsMainNews(newsUpdateDTO.getIsMainNews());
            if(newsUpdateDTO.getPriority() != null) news.setPriority(newsUpdateDTO.getPriority());
            if(newsUpdateDTO.getViews() != null) news.setViews(newsUpdateDTO.getViews());
            if(newsUpdateDTO.getLikes() != null) news.setLikes(newsUpdateDTO.getLikes());
            if(newsUpdateDTO.getStatusId() != null) news.setStatusId(newsUpdateDTO.getStatusId());
            if(newsUpdateDTO.getPublicAt() != null) news.setPublicAt(newsUpdateDTO.getPublicAt());
            if(newsUpdateDTO.getUnpublicAt() != null) news.setUnpublicAt(newsUpdateDTO.getUnpublicAt());
            if(newsUpdateDTO.getUpdatedBy() != null) news.setUpdatedBy(newsUpdateDTO.getUpdatedBy());

            newsRepository.save(news);
        });
    }

    public List<News> getAllNews() {
        // Sorting by 'createdAt' in descending order so the newest news comes first
        return newsRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public List<News> getNewsByDate(Instant date) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        return newsRepository.findByPublicAt(date, sort);
    }

    public List<News> getNewsByAuthor(Long authorUserId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        return newsRepository.findByAuthorUserId(authorUserId, sort);
    }
}
