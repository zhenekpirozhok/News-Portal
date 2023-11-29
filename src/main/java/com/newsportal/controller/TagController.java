package com.newsportal.controller;

import com.newsportal.service.NewsTagService;
import com.newsportal.service.TagService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @Autowired
    private NewsTagService newsTagService;
    @PostMapping("/addTags")
    public ResponseEntity<String> addTags(@RequestParam Long newsId, @RequestParam Long mainTagId) {
        try {
            newsTagService.addTags(newsId, mainTagId);
            return new ResponseEntity<>("Tag and News linked successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Tag or News not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error linking Tag and News", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}