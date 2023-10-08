package com.custom.validation.controller;

import com.custom.validation.entity.Category;
import com.custom.validation.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContentController {
    @Autowired
    private ContentService contentService;

    @GetMapping("/list-along-with-sublist")
    public List<Category> getContentList() {
        List<Category> categories = contentService.getAllContent();
        return categories;
    }
}
