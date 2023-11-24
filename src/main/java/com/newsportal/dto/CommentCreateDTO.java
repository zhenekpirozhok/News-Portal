package com.newsportal.dto;

public class CommentCreateDTO {
    private Long userId;
    private Long newsId;
    private String content;


    public CommentCreateDTO(Long userId, Long newsId, String content) {
        this.userId = userId;
        this.newsId = newsId;
        this.content = content;

    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}