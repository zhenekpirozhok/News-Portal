package com.newsportal.dto;

import java.time.Instant;

public class NewsInfoDTO {

    private Long authorUserId;
    private String title;
    private String imageUrl;
    private Integer views;
    private Instant publicAt;

    public NewsInfoDTO(Long authorUserId, String title, String imageUrl, Integer views, Instant publicAt) {
        this.authorUserId = authorUserId;
        this.title = title;
        this.imageUrl = imageUrl;
        this.views = views;
        this.publicAt = publicAt;
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

    public Instant getPublicAt() {
        return publicAt;
    }

    public void setPublicAt(Instant publicAt) {
        this.publicAt = publicAt;
    }
}
