package com.newsportal.service;

import com.newsportal.repository.TagRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private HttpSession session;
}