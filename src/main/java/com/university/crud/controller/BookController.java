package com.university.crud.controller;

import com.university.crud.model.Books;
import com.university.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //get all books
    @GetMapping
    private List<Books> getAllBooks(){
        return this.bookService.getAllBooks();
    }

    //get book by id
    @GetMapping(path = "/{id}")
    private Books getBookById(@PathVariable (value = "id") Long id){
        Optional<Books> booksById = this.bookService.getBookById(id);
        Books books = booksById.get();
        return books;
    }

    //create book


    //update book

    //delete book

}
