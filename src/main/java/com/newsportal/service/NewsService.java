package com.newsportal.service;

import com.newsportal.dto.NewsDTO;
import com.newsportal.dto.NewsInfoDTO;
import com.newsportal.dto.NewsUpdateDTO;
import com.newsportal.model.Likes;
import com.newsportal.model.News;
import com.newsportal.model.Tag;
import com.newsportal.model.User;
import com.newsportal.repository.LikesRepository;
import com.newsportal.repository.NewsRepository;
import com.newsportal.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private HttpSession session;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LikesRepository likesRepository;

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

    @Transactional
    public NewsDTO getNewsById(Long newsId) {
        return newsRepository.findById(newsId).map(news -> {
            // Check if the news meets the criteria
            if (news.getStatusId() != 1 || news.getPublicAt().isAfter(Instant.now()) ||
                    (news.getUnpublicAt() != null && news.getUnpublicAt().isBefore(Instant.now()))) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "News not available");
            }

            news.setViews(news.getViews() + 1); // Increment the views
            newsRepository.save(news); // Save the news item back to the database

            // Fetch the username of the author
            User author = userRepository.findById(news.getAuthorUserId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));

            Set<String> tagNames = new HashSet<>();
            for (Tag tag : news.getTags()) {
                tagNames.add(tag.getTagName());
            }

            // Convert to DTO
            return new NewsDTO(
                    news.getId(),
                    author.getUsername(), // Use the username instead of authorUserId
                    news.getTitle(),
                    news.getContent(),
                    news.getImageUrl(),
                    news.getViews(),
                    news.getLikes(),
                    news.getPublicAt(),
                    tagNames
            );
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "News not found"));
    }

    public List<NewsInfoDTO> searchNewsByKeyword(String keyword) {
        return newsRepository.search(keyword);
    }

    public List<NewsInfoDTO> searchNewsByTag(String tag) {
        return newsRepository.searchNewsByTag(tag);
    }

    public List<NewsInfoDTO> findPageOfNewsByTags(String tags) {
        return newsRepository.findPageOfNewsByTags(tags);
    }

    public Page<NewsInfoDTO> getNewsPage(Pageable pageable) {
        return newsRepository.findNewsWithPagination(pageable);
    }

    @Transactional
    public void createNews(String title, String content, String imageUrl) {
        User currentUser = (User) session.getAttribute("user");
        News news = new News();
        news.setAuthorUserId(currentUser.getId());
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
            if (newsUpdateDTO.getAuthorUserId() != null) news.setAuthorUserId(newsUpdateDTO.getAuthorUserId());
            if (newsUpdateDTO.getTitle() != null) news.setTitle(newsUpdateDTO.getTitle());
            if (newsUpdateDTO.getContent() != null) news.setContent(newsUpdateDTO.getContent());
            if (newsUpdateDTO.getImageUrl() != null) news.setImageUrl(newsUpdateDTO.getImageUrl());
            if (newsUpdateDTO.getIsMainNews() != null) news.setIsMainNews(newsUpdateDTO.getIsMainNews());
            if (newsUpdateDTO.getPriority() != null) news.setPriority(newsUpdateDTO.getPriority());
            if (newsUpdateDTO.getViews() != null) news.setViews(newsUpdateDTO.getViews());
            if (newsUpdateDTO.getLikes() != null) news.setLikes(newsUpdateDTO.getLikes());
            if (newsUpdateDTO.getStatusId() != null) news.setStatusId(newsUpdateDTO.getStatusId());
            if (newsUpdateDTO.getPublicAt() != null) news.setPublicAt(newsUpdateDTO.getPublicAt());
            if (newsUpdateDTO.getUnpublicAt() != null) news.setUnpublicAt(newsUpdateDTO.getUnpublicAt());
            if (newsUpdateDTO.getUpdatedBy() != null) news.setUpdatedBy(newsUpdateDTO.getUpdatedBy());

            newsRepository.save(news);
        });
    }

    public List<News> getAllNews() {
        return newsRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public Optional<News> getAdminNewsByID(Long id) {
        return newsRepository.findById(id);
    }

    public List<News> getNewsByDate(Instant date) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        return newsRepository.findByPublicAt(date, sort);
    }

    public List<News> getNewsByAuthor(Long authorUserId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        return newsRepository.findByAuthorUserId(authorUserId, sort);
    }

    @Transactional
    public String toggleLike(Long newsId) {
        User currentUser = (User) session.getAttribute("user");
        News news = new News();
        Optional<Likes> existingLike = likesRepository.findByUserIdAndNewsId(currentUser.getId(), newsId);
        if (existingLike.isPresent()) {
            likesRepository.delete(existingLike.get());
            news.setLikes(news.getLikes() - 1);
            return "Like removed";
        } else {
            Likes newLike = new Likes();
            newLike.setUserId(currentUser.getId());
            newLike.setNewsId(newsId);
            likesRepository.save(newLike);
            news.setLikes(news.getLikes() + 1);
            return "Like added";
        }
    }
}