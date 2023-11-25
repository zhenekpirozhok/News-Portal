package com.newsportal.controller;

import com.newsportal.dto.CommentCreateDTO;
import com.newsportal.dto.CommentDTO;
import com.newsportal.dto.CommentUpdateDTO;
import com.newsportal.model.Comment;
import com.newsportal.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

   @GetMapping("/{newsId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByNewsId(@PathVariable Long newsId) {
        List<CommentDTO> comments = commentService.getCommentsByNewsId(newsId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createComment(@RequestBody CommentCreateDTO commentCreateDTO) {
        commentService.createComment(commentCreateDTO.getUserId(), commentCreateDTO.getNewsId(), commentCreateDTO.getContent());
        return ResponseEntity.ok("Comment created successfully");
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok("Comment deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getAllNews() {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @GetMapping("/admin_date/{date}")
    public ResponseEntity<List<Comment>> getNewsByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant date) {
        return ResponseEntity.ok(commentService.getCommentsByDate(date));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateNews(@RequestBody CommentUpdateDTO commentUpdateDTO) {
        commentService.updateComment(commentUpdateDTO);
        return ResponseEntity.ok("Comment updated successfully");
    }
}