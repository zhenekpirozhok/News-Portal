package com.newsportal.dto;

import java.time.Instant;

public class NewsUpdateDTO {
    private Long id; // Used for identifying which news to update
    private Long authorUserId;
    private String title;
    private String content;
    private String imageUrl;
    private Integer isMainNews;
    private Integer priority;
    private Integer views;
    private Integer likes;
    private Long statusId;
    private Instant publicAt;
    private Instant unpublicAt;
    private Long updatedBy;

    public NewsUpdateDTO(Long id, Long authorUserId, String title, String content, String imageUrl, Integer isMainNews, Integer priority, Integer views, Integer likes, Long statusId, Instant publicAt, Instant unpublicAt, Long updatedBy) {
        this.id = id;
        this.authorUserId = authorUserId;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.isMainNews = isMainNews;
        this.priority = priority;
        this.views = views;
        this.likes = likes;
        this.statusId = statusId;
        this.publicAt = publicAt;
        this.unpublicAt = unpublicAt;
        this.updatedBy = updatedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getIsMainNews() {
        return isMainNews;
    }

    public void setIsMainNews(Integer isMainNews) {
        this.isMainNews = isMainNews;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Instant getPublicAt() {
        return publicAt;
    }

    public void setPublicAt(Instant publicAt) {
        this.publicAt = publicAt;
    }

    public Instant getUnpublicAt() {
        return unpublicAt;
    }

    public void setUnpublicAt(Instant unpublicAt) {
        this.unpublicAt = unpublicAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
}
