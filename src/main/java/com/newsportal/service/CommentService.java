package com.newsportal.service;

import com.newsportal.dto.CommentDTO;
import com.newsportal.dto.NewsDTO;
import com.newsportal.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    public CommentDTO getCommentById(Long commentId) {
        return commentRepository.findCommentById(commentId);
    }
}
