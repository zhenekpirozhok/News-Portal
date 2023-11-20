package com.newsportal.dto;

import java.time.LocalDateTime;

public class CommentDTO {
    private Long authorUserId;
    private String content;
    private LocalDateTime createdAt;

    public CommentDTO(Long authorUserId, String content, LocalDateTime createdAt) {
        this.authorUserId = authorUserId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getAuthorUserId() {
        return authorUserId;
    }

    public void setAuthorUserId(Long authorUserId) {
        this.authorUserId = authorUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
