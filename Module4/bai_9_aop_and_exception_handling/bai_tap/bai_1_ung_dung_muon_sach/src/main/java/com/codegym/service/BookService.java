package com.codegym.service;

import com.codegym.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(int id);

    void save(Book book);

    void update(Book book);

    void delete(int id);
}
