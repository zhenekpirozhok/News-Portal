package com.newsportal.dto;

import java.time.LocalDateTime;

public class NewsDTO {
    private Long authorUserId;
    private String title;
    private String content;
    private String imageUrl;
    private Integer views;
    private Integer likes;
    private LocalDateTime publicAt;


    public NewsDTO(Long userId, String title, String content, String imageUrl, Integer views, Integer likes, LocalDateTime publicAt) {
        this.authorUserId = userId;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.views = views;
        this.likes = likes;
        this.publicAt = publicAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAuthorUserId() {
        return authorUserId;
    }

    public void setAuthorUserId(Long authorUserId) {
        this.authorUserId = authorUserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public LocalDateTime getPublicAt() {
        return publicAt;
    }

    public void setPublicAt(LocalDateTime publicAt) {
        this.publicAt = publicAt;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
