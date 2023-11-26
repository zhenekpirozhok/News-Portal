package com.newsportal.repository;

import com.newsportal.dto.NewsInfoDTO;
import com.newsportal.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

  // 1. 25 последних новостей с учетом приоритета
  @Query("SELECT new com.newsportal.dto.NewsInfoDTO(u.username, n.title, n.imageUrl, n.views, n.publicAt) " +
          "FROM News n JOIN n.user u " +
          "WHERE n.statusId = 1 AND n.publicAt <= CURRENT_TIMESTAMP " +
          "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP) " +
          "ORDER BY n.publicAt DESC, n.priority DESC")
  List<NewsInfoDTO> findTop25News(Pageable pageable);

    // 2. 4 новости за сегодня с наибольшими просмотрами
    @Query("SELECT new com.newsportal.dto.NewsInfoDTO(u.username, n.title, n.imageUrl, n.views, n.publicAt) " +
            "FROM News n JOIN n.user u " +
            "WHERE n.statusId = 1 AND n.publicAt BETWEEN :startOfDay AND :endOfDay " +
            "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP) " +
            "ORDER BY n.views DESC")
    Page<NewsInfoDTO> findTop4TodayNewsByViews(LocalDateTime startOfDay, LocalDateTime endOfDay, Pageable pageable);


  // 3. 4 последние новости определенного автора за сегодня
  @Query("SELECT new com.newsportal.dto.NewsInfoDTO(u.username, n.title, n.imageUrl, n.views, n.publicAt) " +
          "FROM News n JOIN n.user u " +
          "WHERE u.id = :authorUserId AND n.statusId = 1 " +
          "AND n.publicAt BETWEEN :startOfDay AND :endOfDay " +
          "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP) " +
          "ORDER BY n.priority DESC, n.publicAt DESC")
  List<NewsInfoDTO> findTopNewsByAuthorToday(@Param("authorUserId") Long authorUserId,
                                             @Param("startOfDay") LocalDateTime startOfDay,
                                             @Param("endOfDay") LocalDateTime endOfDay,
                                             Pageable pageable);


  // 4. Последняя главная новость
  @Query("SELECT new com.newsportal.dto.NewsInfoDTO(u.username, n.title, n.imageUrl, n.views, n.publicAt) " +
          "FROM News n JOIN n.user u " +
          "WHERE n.statusId = 1 AND n.isMainNews = 1 " +
          "AND n.publicAt <= CURRENT_TIMESTAMP " +
          "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP) " +
          "ORDER BY n.publicAt DESC")
  List<NewsInfoDTO> findMainNews(Pageable pageable);





  // 5. 25 новостей за определенную дату
  @Query("SELECT new com.newsportal.dto.NewsInfoDTO(u.username, n.title, n.imageUrl, n.views, n.publicAt) " +
          "FROM News n JOIN n.user u " +
          "WHERE n.statusId = 1 AND n.publicAt BETWEEN :startOfDay AND :endOfDay " +
          "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP) " +
          "ORDER BY n.priority DESC, n.publicAt DESC")
  Page<NewsInfoDTO> findNewsByDate(LocalDateTime startOfDay, LocalDateTime endOfDay, Pageable pageable);



  // 6. Новость по ID
    Optional<News> findById(Long id);


    //7. Загрузить еще
    @Query("SELECT new com.newsportal.dto.NewsInfoDTO(u.username, n.title, n.imageUrl, n.views, n.publicAt) " +
            "FROM News n JOIN n.user u " +
            "WHERE n.statusId = 1 AND n.publicAt <= CURRENT_TIMESTAMP " +
            "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP) " +
            "ORDER BY n.publicAt DESC, n.priority DESC")
    Page<NewsInfoDTO> findNewsWithPagination(Pageable pageable);


  @Query("SELECT new com.newsportal.dto.NewsInfoDTO(u.username, n.title, n.imageUrl, n.views, n.publicAt) " +
          "FROM News n JOIN n.user u " +
          "WHERE (LOWER(u.username) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
          "LOWER(n.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
          "LOWER(n.content) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
          "AND n.statusId = 1 AND n.publicAt <= CURRENT_TIMESTAMP " +
          "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP)")
  List<NewsInfoDTO> search(@Param("keyword") String keyword);


  List<News> findByAuthorUserId(Long authorUserId, Sort sort);
    List<News> findByPublicAt(Instant date, Sort sort);

    }
