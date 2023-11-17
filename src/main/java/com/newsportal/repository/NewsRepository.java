package com.newsportal.repository;

import com.newsportal.dto.NewsTitleDto;
import com.newsportal.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    @Query("SELECT n.title FROM News n")
    List<String> findAllTitles();
}
