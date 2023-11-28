package com.newsportal.dto;

public class CommentCreateDTO {

    private Long newsId;
    private String content;

    public CommentCreateDTO() {

    }

    public CommentCreateDTO(Long newsId, String content) {
        this.newsId = newsId;
        this.content = content;
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