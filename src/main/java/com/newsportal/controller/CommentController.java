package com.newsportal.controller;

import com.newsportal.dto.CommentCreateDTO;
import com.newsportal.dto.CommentDTO;
import com.newsportal.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}