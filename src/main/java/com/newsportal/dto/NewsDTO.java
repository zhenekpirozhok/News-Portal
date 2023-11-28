package com.newsportal.dto;

import com.newsportal.model.Tag;

import java.time.Instant;
import java.util.Set;

public class NewsDTO {
    private Long id;
    private String authorUsername;
    private String title;
    private String content;
    private String imageUrl;
    private Integer views;
    private Integer likes;
    private Instant publicAt;
    private Set<String> tags;

    public NewsDTO(Long id, String authorUsername, String title, String content, String imageUrl, Integer views, Integer likes, Instant publicAt, Set<String> tags) {
        this.id = id;
        this.authorUsername = authorUsername;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.views = views;
        this.likes = likes;
        this.publicAt = publicAt;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}