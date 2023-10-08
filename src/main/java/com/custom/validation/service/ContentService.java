package com.custom.validation.service;

import com.custom.validation.entity.Category;
import com.custom.validation.entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentService {
    public List<Category> categories = new ArrayList<>();

    public List<Category> getAllContent() {

        List<Course> courses = new ArrayList<>();
        courses.add(new Course(2001, 1001, "AWS Essentials", 180, 100));
        courses.add(new Course(2002, 1002, "java ", 180, 100));
        courses.add(new Course(2003, 1003, "C ", 180, 100));

        List<Category> categories = new ArrayList<>();

        categories.add(new Category(1001, "Cloud Computing", "network of remote servers hosted on the Internet to store", courses));
        categories.add(new Category(1002, "java", "oops", courses));
        categories.add(new Category(1003, "Android", "Mobile", courses));
        System.out.println("categories size " + categories.size());
        return categories;
    }
}
