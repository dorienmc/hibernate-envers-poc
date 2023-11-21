package com.example.graphqlserver.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.example.graphqlserver.entity.Author;
import com.example.graphqlserver.entity.Book;
import com.example.graphqlserver.input.CreateBookInput;
import com.example.graphqlserver.service.BookService;

/**
 * Controller to retrieve books
 *
 * @author Dorien Lorijn
 */
@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<Book> books() {
        return bookService.findAll();
    }

    @SchemaMapping
    public Author authorById(Book book){
        return book.getAuthor();
    }

    @MutationMapping
    public Book createBook(@Argument CreateBookInput input) {
        return bookService.create(Book.of(input));
    }
}
