package com.newsportal.controller;

import com.newsportal.dto.CommentCreateDTO;
import com.newsportal.dto.CommentDTO;
import com.newsportal.dto.CommentUpdateDTO;
import com.newsportal.service.CommentService;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @GetMapping("/{newsId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByNewsId(@PathVariable Long newsId) {
        List<CommentDTO> comments = commentService.getCommentsByNewsId(newsId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createComment(@RequestBody CommentCreateDTO commentCreateDTO) {
        if (!userService.isCurrentUserUser()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        commentService.createComment(commentCreateDTO.getNewsId(), commentCreateDTO.getContent());
        return ResponseEntity.ok("Comment created successfully");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable Long id) {
        if (!userService.isCurrentUserAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        commentService.deleteComment(id);
        return ResponseEntity.ok("Comment deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllNews() {
        if (!userService.isCurrentUserAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @GetMapping("/admin_date/{date}")
    public ResponseEntity<?> getNewsByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant date) {
        if (!userService.isCurrentUserAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        return ResponseEntity.ok(commentService.getCommentsByDate(date));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateNews(@RequestBody CommentUpdateDTO commentUpdateDTO) {
        if (!userService.isCurrentUserAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        commentService.updateComment(commentUpdateDTO);
        return ResponseEntity.ok("Comment updated successfully");
    }
}