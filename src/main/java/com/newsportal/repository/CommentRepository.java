package com.newsportal.repository;

import com.newsportal.dto.CommentDTO;
import com.newsportal.dto.NewsDTO;
import com.newsportal.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    //Вывод комментариев по news_id
    @Query("SELECT new com.newsportal.dto.CommentDTO(c.authorUserId, c.content, c.createdAt) " +
            "FROM comment c WHERE c.id = :commentId")
    CommentDTO findCommentById(@Param("commentId") Long commentId);
}
