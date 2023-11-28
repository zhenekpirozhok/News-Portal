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
    @Query("SELECT new com.newsportal.dto.NewsInfoDTO(n.id, u.username, n.title, n.imageUrl, n.views, n.publicAt, t.tagName) " +
            "FROM News n JOIN n.user u " +
            "JOIN NewsTag nt ON n.id = nt.news.id " +
            "JOIN Tag t ON nt.tag.id = t.id " +
            "WHERE n.statusId = 1 AND n.publicAt <= CURRENT_TIMESTAMP " +
            "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP) " +
            "ORDER BY n.publicAt DESC, n.priority DESC")
    List<NewsInfoDTO> findTop25News(Pageable pageable);


    // 2. 4 новости за сегодня с наибольшими просмотрами
    @Query("SELECT new com.newsportal.dto.NewsInfoDTO(n.id, u.username, n.title, n.imageUrl, n.views, n.publicAt, t.tagName) " +
            "FROM News n JOIN n.user u " +
            "JOIN NewsTag nt ON n.id = nt.news.id " +
            "JOIN Tag t ON nt.tag.id = t.id " +
            "WHERE n.statusId = 1 AND n.publicAt BETWEEN :startOfDay AND :endOfDay " +
            "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP) " +
            "ORDER BY n.views DESC")
    Page<NewsInfoDTO> findTop4TodayNewsByViews(LocalDateTime startOfDay, LocalDateTime endOfDay, Pageable pageable);

    // 3. 4 последние новости определенного автора за сегодня
    @Query("SELECT new com.newsportal.dto.NewsInfoDTO(n.id, u.username, n.title, n.imageUrl, n.views, n.publicAt, t.tagName) " +
            "FROM News n JOIN n.user u " +
            "JOIN NewsTag nt ON n.id = nt.news.id " +
            "JOIN Tag t ON nt.tag.id = t.id " +
            "WHERE u.id = :authorUserId AND n.statusId = 1 " +
            "AND n.publicAt BETWEEN :startOfDay AND :endOfDay " +
            "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP) " +
            "ORDER BY n.priority DESC, n.publicAt DESC")
    List<NewsInfoDTO> findTopNewsByAuthorToday(@Param("authorUserId") Long authorUserId,
                                               @Param("startOfDay") LocalDateTime startOfDay,
                                               @Param("endOfDay") LocalDateTime endOfDay,
                                               Pageable pageable);

    // 4. Последняя главная новость
    @Query("SELECT new com.newsportal.dto.NewsInfoDTO(n.id, u.username, n.title, n.imageUrl, n.views, n.publicAt, t.tagName) " +
            "FROM News n JOIN n.user u " +
            "JOIN NewsTag nt ON n.id = nt.news.id " +
            "JOIN Tag t ON nt.tag.id = t.id " +
            "WHERE n.statusId = 1 AND n.isMainNews = 1 " +
            "AND n.publicAt <= CURRENT_TIMESTAMP " +
            "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP) " +
            "ORDER BY n.publicAt DESC")
    List<NewsInfoDTO> findMainNews(Pageable pageable);

    // 5. 25 новостей за определенную дату
    @Query("SELECT new com.newsportal.dto.NewsInfoDTO(n.id, u.username, n.title, n.imageUrl, n.views, n.publicAt, t.tagName) " +
            "FROM News n JOIN n.user u " +
            "JOIN NewsTag nt ON n.id = nt.news.id " +
            "JOIN Tag t ON nt.tag.id = t.id " +
            "WHERE n.statusId = 1 AND n.publicAt BETWEEN :startOfDay AND :endOfDay " +
            "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP) " +
            "ORDER BY n.priority DESC, n.publicAt DESC")
    Page<NewsInfoDTO> findNewsByDate(LocalDateTime startOfDay, LocalDateTime endOfDay, Pageable pageable);

    // 6. Новость по ID
    Optional<News> findById(Long id);

    //7. Загрузить еще
    @Query("SELECT new com.newsportal.dto.NewsInfoDTO(n.id, u.username, n.title, n.imageUrl, n.views, n.publicAt, t.tagName) " +
            "FROM News n JOIN n.user u " +
            "JOIN NewsTag nt ON n.id = nt.news.id " +
            "JOIN Tag t ON nt.tag.id = t.id " +
            "WHERE n.statusId = 1 AND n.publicAt <= CURRENT_TIMESTAMP " +
            "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP) " +
            "ORDER BY n.publicAt DESC, n.priority DESC")
    Page<NewsInfoDTO> findNewsWithPagination(Pageable pageable);

    @Query("SELECT DISTINCT new com.newsportal.dto.NewsInfoDTO(n.id, u.username, n.title, n.imageUrl, n.views, n.publicAt, t.tagName) " +
            "FROM News n JOIN n.user u " +
            "JOIN n.newsTags nt " +
            "JOIN nt.tag t " +
            "WHERE (LOWER(u.username) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(n.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(n.content) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "EXISTS (" +
            "    SELECT 1 FROM NewsTag nt1 " +
            "    JOIN Tag t1 ON nt1.tag.id = t1.id " +
            "    WHERE nt.news.id = n.id AND " +
            "    LOCATE(LOWER(t1.tagName), LOWER(:keyword)) <> 0" +
            ") " +
            ") " +
            "AND n.statusId = 1 AND n.publicAt <= CURRENT_TIMESTAMP " +
            "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP)")
    List<NewsInfoDTO> search(@Param("keyword") String keyword);


    @Query("SELECT DISTINCT new com.newsportal.dto.NewsInfoDTO(n.id, u.username, n.title, n.imageUrl, n.views, n.publicAt, t.tagName) " +
            "FROM News n JOIN n.user u " +
            "JOIN NewsTag nt ON n.id = nt.news.id " +
            "JOIN Tag t ON nt.tag.id = t.id " +
            "WHERE " +
            "LOWER(t.tagName) LIKE LOWER(CONCAT('%', :tag, '%')) " +
            "AND n.statusId = 1 AND n.publicAt <= CURRENT_TIMESTAMP " +
            "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP)"
    )
    List<NewsInfoDTO> searchNewsByTag(@Param("tag") String tag);

    @Query("SELECT DISTINCT new com.newsportal.dto.NewsInfoDTO(n.id, u.username, n.title, n.imageUrl, n.views, n.publicAt, t.tagName) " +
            "FROM News n JOIN n.user u " +
            "JOIN NewsTag nt ON n.id = nt.news.id " +
            "JOIN Tag t ON nt.tag.id = t.id " +
            "WHERE( " +
            "LOCATE(LOWER(t.tagName), LOWER(:tags)) <> 0 AND " +
            "n.id IN (" +
            "    SELECT n2.id " +
            "    FROM News n2 " +
            "    JOIN NewsTag nt2 ON n2.id = nt2.news.id " +
            "    JOIN Tag t2 ON nt2.mainTag = t2.id " +
            "    WHERE t2.tagName = t.tagName " +
            "    ORDER BY n2.publicAt DESC " +
            "    LIMIT 12" +
            ") " +
            ") " +
            "AND n.statusId = 1 AND n.publicAt <= CURRENT_TIMESTAMP " +
            "AND (n.unpublicAt IS NULL OR n.unpublicAt > CURRENT_TIMESTAMP)" +
            "ORDER BY t.tagName"
    )
    List<NewsInfoDTO> findPageOfNewsByTags(@Param("tags") String tags);

    List<News> findByAuthorUserId(Long authorUserId, Sort sort);

    List<News> findByPublicAt(Instant date, Sort sort);
}
