package com.university.crud.service;

import com.university.crud.model.Books;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Books> getAllBooks();

    Optional<Books> getBookById(Long id);
}
