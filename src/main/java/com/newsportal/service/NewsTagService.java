package com.newsportal.service;

import com.newsportal.model.News;
import com.newsportal.model.NewsTag;
import com.newsportal.model.Tag;
import com.newsportal.repository.NewsRepository;
import com.newsportal.repository.NewsTagRepository;
import com.newsportal.repository.TagRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsTagService {
    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsTagRepository newsTagRepository;

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private HttpSession session;

    public void addTags(Long newsId, Long tagId) {
        Tag tag = tagRepository.findById(tagId).orElse(null);
        News news = newsRepository.findById(newsId).orElse(null);

        if (tag != null && news != null) {
            NewsTag newsTag = new NewsTag();

            newsTag.setMainTag(tag.getId());
            newsTag.setTag(tag);
            newsTag.setNews(news);
            newsTagRepository.save(newsTag);
        } else {
            throw new EntityNotFoundException("Tag or News not found");
        }
    }
}