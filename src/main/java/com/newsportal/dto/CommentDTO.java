package com.newsportal.dto;

public class CommentDTO {
    private Long userId;
    private Long newsId; 
    private String content;
   /* private LocalDateTime createdAt;*/

    public CommentDTO(Long userId, Long newsId, String content/*, LocalDateTime createdAt*/) {
        this.userId = userId;
        this.newsId = newsId;
        this.content = content;
        /*this.createdAt = createdAt;*/
    }

    public CommentDTO(long userId, String content, String createdAt) {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

   /* public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
*/
    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }
}