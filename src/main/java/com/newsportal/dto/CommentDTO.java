package com.newsportal.dto;

import java.time.Instant;

public class CommentDTO {
    private Long userId;
    private Long newsId;
    private String content;
    private Instant createdAt;




    public CommentDTO(Long userId, Long newsId, String content, Instant createdAt) {
        this.userId = userId;
        this.newsId = newsId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}