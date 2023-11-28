package com.newsportal.dto;

import java.time.Instant;

public class NewsDTO {
    private String authorUsername;
    private String title;
    private String content;
    private String imageUrl;
    private Integer views;
    private Integer likes;
    private Instant publicAt;

    private String tags;

    public NewsDTO(){

    }

    public NewsDTO(String authorUsername, String title, String content, String imageUrl, Integer views, Integer likes, Instant publicAt) {
        this.authorUsername = authorUsername;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.views = views;
        this.likes = likes;
        this.publicAt = publicAt;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
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

    public Instant getPublicAt() {
        return publicAt;
    }

    public void setPublicAt(Instant publicAt) {
        this.publicAt = publicAt;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}