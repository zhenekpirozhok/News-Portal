package com.newsportal.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "news_tags")
public class NewsTag {

    @EmbeddedId
    private NewsTagsId id;

    public NewsTag(NewsTagsId id) {
        this.id = id;
    }

    public NewsTagsId getId() {
        return id;
    }

    public void setId(NewsTagsId id) {
        this.id = id;
    }



    @Embeddable
    public static class NewsTagsId implements java.io.Serializable {
        @Column(name = "news_id", nullable = false)
        private Long newsId;

        @Column(name = "tag_id", nullable = false)
        private Long tagId;

        public NewsTagsId(Long newsId, Long tagId) {
            this.newsId = newsId;
            this.tagId = tagId;
        }

        public Long getNewsId() {
            return newsId;
        }

        public void setNewsId(Long newsId) {
            this.newsId = newsId;
        }

        public Long getTagId() {
            return tagId;
        }

        public void setTagId(Long tagId) {
            this.tagId = tagId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NewsTagsId that = (NewsTagsId) o;
            return Objects.equals(newsId, that.newsId) && Objects.equals(tagId, that.tagId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(newsId, tagId);
        }

        // Конструкторы, геттеры, сеттеры, hashCode и equals
    }
}