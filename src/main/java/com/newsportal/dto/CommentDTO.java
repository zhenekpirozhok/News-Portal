package com.newsportal.dto;

import java.time.Instant;

public class CommentDTO {
    private String username;
    private Long newsId;
    private String content;
    private Instant createdAt;

    public CommentDTO() {

    }

    public CommentDTO(String username, Long newsId, String content, Instant createdAt) {
        this.username = username;
        this.newsId = newsId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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