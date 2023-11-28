package com.newsportal.service;

import com.newsportal.dto.CommentDTO;
import com.newsportal.dto.CommentUpdateDTO;
import com.newsportal.model.Comment;
import com.newsportal.model.User;
import com.newsportal.repository.CommentRepository;
import com.newsportal.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession session;

    public List<CommentDTO> getCommentsByNewsId(Long newsId) {
        return commentRepository.findByNewsId(newsId).stream()
                .filter(comment -> comment.getStatusId() == 1) // Filter comments with statusId 1
                .map(comment -> {
                    // Use Optional to handle the case where user might not be found
                    String username = userRepository.findById(comment.getUserId())
                            .map(User::getUsername) // If user is found, get the username
                            .orElse("[Deleted User]"); // If not found, set a placeholder or empty string

                    // Create new CommentDTO with username instead of userId
                    return new CommentDTO(username, newsId, comment.getContent(), comment.getCreatedAt());
                })
                .collect(Collectors.toList());
    }


    @Transactional
    public void createComment(Long newsId, String content) {
        User currentUser = (User) session.getAttribute("user");
        Comment comment = new Comment();
        comment.setUserId(currentUser.getId());
        comment.setNewsId(newsId);
        comment.setContent(content);
        comment.setStatusId(1L);
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
            if (commentUpdateDTO.getNewsId() != null) news.setNewsId(commentUpdateDTO.getNewsId());
            if (commentUpdateDTO.getUserId() != null) news.setUserId(commentUpdateDTO.getUserId());
            if (commentUpdateDTO.getContent() != null) news.setContent(commentUpdateDTO.getContent());
            if (commentUpdateDTO.getUpdatedBy() != null) news.setUpdatedBy(commentUpdateDTO.getUpdatedBy());
            if (commentUpdateDTO.getCreatedAt() != null) news.setCreatedAt(commentUpdateDTO.getCreatedAt());
            if (commentUpdateDTO.getUpdatedAt() != null) news.setUpdatedAt(commentUpdateDTO.getUpdatedAt());
            if (commentUpdateDTO.getStatusId() != null) news.setStatusId(commentUpdateDTO.getStatusId());


            commentRepository.save(news);
        });
    }
}