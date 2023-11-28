package com.newsportal.service;

import com.newsportal.repository.LikesRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LikesService {
    @Autowired
    private LikesRepository likesRepository;
    @Autowired
    private HttpSession session;
}