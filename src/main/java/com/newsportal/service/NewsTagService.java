package com.newsportal.service;

import com.newsportal.repository.NewsTagRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsTagService {
    @Autowired
    private NewsTagRepository newsTagRepository;
    @Autowired
    private HttpSession session;
}