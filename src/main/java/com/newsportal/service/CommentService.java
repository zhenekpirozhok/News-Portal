package com.newsportal.service;

import com.newsportal.dto.CommentDTO;
import com.newsportal.dto.CommentUpdateDTO;
import com.newsportal.model.Comment;
import com.newsportal.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
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


    public List<Comment> getAllComments() {
        // Sorting by 'createdAt' in descending order so the newest news comes first
        return commentRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public List<Comment> getCommentsByDate(Instant date) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        return commentRepository.findByCreatedAt(date, sort);
    }

    public void updateComment(CommentUpdateDTO commentUpdateDTO) {
        commentRepository.findById(commentUpdateDTO.getId()).ifPresent(news -> {
            if(commentUpdateDTO.getNewsId() != null) news.setNewsId(commentUpdateDTO.getNewsId());
            if(commentUpdateDTO.getUserId() != null) news.setUserId(commentUpdateDTO.getUserId());
            if(commentUpdateDTO.getContent() != null) news.setContent(commentUpdateDTO.getContent());
            if(commentUpdateDTO.getUpdatedBy() != null) news.setUpdatedBy(commentUpdateDTO.getUpdatedBy());
            if(commentUpdateDTO.getCreatedAt() != null) news.setCreatedAt(commentUpdateDTO.getCreatedAt());
            if(commentUpdateDTO.getUpdatedAt() != null) news.setUpdatedAt(commentUpdateDTO.getUpdatedAt());
            if(commentUpdateDTO.getStatusId() != null) news.setStatusID(commentUpdateDTO.getStatusId());


            commentRepository.save(news);
        });
    }
}