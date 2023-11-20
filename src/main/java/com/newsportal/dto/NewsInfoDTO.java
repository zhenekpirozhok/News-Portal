package com.newsportal.dto;

import java.time.LocalDateTime;

public class NewsInfoDTO {

    private Long authorUserId;
    private String title;
    private String imageUrl;
    private Integer views;
    private LocalDateTime publicAt;



    public NewsInfoDTO(Long authorUserId, String title, String imageUrl, Integer views, LocalDateTime publicAt) {
        this.authorUserId = authorUserId;
        this.title = title;
        this.imageUrl = imageUrl;
        this.views = views;
        this.publicAt = publicAt;

    }


    public Long getUserId() {
        return authorUserId;
    }

    public void setUserId(Long authorUserId) {
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
        this.views = this.views;
    }

    public LocalDateTime getPublicAt() {
        return publicAt;
    }

    public void setPublicAt(LocalDateTime publicAt) {
        this.publicAt = publicAt;
    }


}
