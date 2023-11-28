package com.newsportal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "news_tag")
public class NewsTag {

    @Id
    @Column(name = "link_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "news_id")
    private long newsId;

    @Column(name = "tag_id")
    private long tagId;

    @Column(name = "main_tag")
    private long mainTag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public long getMainTag() {
        return mainTag;
    }

    public void setMainTag(long mainTag) {
        this.mainTag = mainTag;
    }
}