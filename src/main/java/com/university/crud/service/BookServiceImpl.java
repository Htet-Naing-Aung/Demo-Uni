package com.university.crud.service;

import com.university.crud.model.Books;
import com.university.crud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Books> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Books> getBookById(Long id) {
        return this.bookRepository.findById(id);
    }
}
