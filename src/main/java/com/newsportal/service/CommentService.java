package com.newsportal.service;

import com.newsportal.dto.CommentDTO;
import com.newsportal.model.Comment;
import com.newsportal.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<CommentDTO> getCommentsByNewsId(Long newsId) {
        return commentRepository.findByNewsId(newsId).stream()
                .map(comment -> new CommentDTO(comment.getUserId(), newsId ,comment.getContent(), comment.getCreatedAt()))
                .collect(Collectors.toList());
    }
    @Transactional
    public void createComment(Long userId, Long newsId, String content) {
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setNewsId(newsId);
        comment.setContent(content);
        // createdAt and updatedAt are handled automatically
        commentRepository.save(comment);
    }


    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}