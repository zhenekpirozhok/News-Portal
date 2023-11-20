package com.newsportal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @Column(name = "status_id")
    private Long id;

    @Column(name = "status_name")
    private String statusName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
