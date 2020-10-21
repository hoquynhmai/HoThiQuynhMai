package com.codegym.service;

import com.codegym.entity.Blog;
import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save (Blog blog);

    void update (Blog blog);

    void delete (int id);
}
