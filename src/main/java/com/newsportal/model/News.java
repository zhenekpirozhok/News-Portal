package com.newsportal.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "news")
public class News {

    @Id
    @Column(name = "news_id")
    private Long id;

    @Column(name = "author_user_id")
    private Long authorUserId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "is_main_news")
    private int isMainNews;

    @Column(name = "priority")
    private int priority;

    @Column(name = "views_on")
    private int views;

    @Column(name = "likes")
    private int likes;

    @Column(name = "status_id")
    private long statusId;

    @Column(name = "public_at")
    private LocalDateTime publicAt;

    @Column(name = "unpublic_at")
    private String unpublicAt;

    @Column(name = "updated_by")
    private int updatedBy;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "update_at")
    private String updateAt;

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

    public int getIsMainNews() {
        return isMainNews;
    }

    public void setIsMainNews(int isMainNews) {
        this.isMainNews = isMainNews;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public LocalDateTime getPublicAt() {
        return publicAt;
    }

    public void setPublicAt(LocalDateTime publicAt) {
        this.publicAt = publicAt;
    }

    public String getUnpublicAt() {
        return unpublicAt;
    }

    public void setUnpublicAt(String unpublicAt) {
        this.unpublicAt = unpublicAt;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}