package com.newsportal.dto;

import java.time.Instant;

public class NewsInfoDTO {

    private String user;
    private String title;
    private String imageUrl;
    private Integer views;
    private Instant publicAt;
    private String mainTag;

    public NewsInfoDTO(){

    }

    public NewsInfoDTO(String user, String title, String imageUrl, Integer views, Instant publicAt, String mainTag) {
        this.user = user;
        this.title = title;
        this.imageUrl = imageUrl;
        this.views = views;
        this.publicAt = publicAt;
        this.mainTag = mainTag;
    }

    public String getAuthorUsername() {
        return user;
    }

    public void setAuthorUsername(String user) {
        this.user = user;
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

    public String getMainTag() {
        return mainTag;
    }

    public void setMainTag(String mainTag) {
        this.mainTag = mainTag;
    }
}
