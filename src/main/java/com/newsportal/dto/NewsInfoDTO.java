package com.newsportal.dto;

import java.time.Instant;

public class NewsInfoDTO {

    private Long id;
    private String user;
    private String title;
    private String imageUrl;
    private Integer views;
    private Instant publicAt;
    private String mainTag;

    public NewsInfoDTO(){

    }

    public NewsInfoDTO(Long id, String user, String title, String imageUrl, Integer views, Instant publicAt, String mainTag) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.imageUrl = imageUrl;
        this.views = views;
        this.publicAt = publicAt;
        this.mainTag = mainTag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
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
