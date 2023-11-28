package com.newsportal.dto;

import java.time.Instant;

public class NewsCreateDTO {

    private String title;
    private String content;
    private String imageUrl;
    private Integer views;
    private Integer likes;
    private Instant publicAt;


    public NewsCreateDTO(String title, String content, String imageUrl, Integer views, Integer likes, Instant publicAt) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.views = views;
        this.likes = likes;
        this.publicAt = publicAt;
    }

    public NewsCreateDTO() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Instant getPublicAt() {
        return publicAt;
    }

    public void setPublicAt(Instant publicAt) {
        this.publicAt = publicAt;
    }
}