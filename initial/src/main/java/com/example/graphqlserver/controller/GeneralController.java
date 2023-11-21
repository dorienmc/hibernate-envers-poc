package com.example.graphqlserver.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.example.graphqlserver.entity.Author;
import com.example.graphqlserver.entity.Book;
import com.example.graphqlserver.input.CreateAuthorWithBooksInput;
import com.example.graphqlserver.input.CreateBookInput;
import com.example.graphqlserver.service.AuthorService;
import com.example.graphqlserver.service.BookService;
import com.example.graphqlserver.service.InitService;

/**
 * TODO: Description
 * @author Dorien Lorijn
 */
@Controller
public class GeneralController {

    private AuthorService authorService;
    private BookService bookService;
    private InitService initService;

    public GeneralController(AuthorService authorService, BookService bookService, InitService initService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.initService = initService;
    }

    @MutationMapping
    public List<Book> initialize() {
        initService.initialize();
        return bookService.findAll();
    }

    @MutationMapping
    public Author createAuthorWithBooks(@Argument CreateAuthorWithBooksInput input) {
        Author author = authorService.create(Author.of(input.author()));
        for (CreateBookInput bookInput: input.books()) {
            Book b = Book.of(bookInput);
            b.setAuthor(author);
            bookService.create(b);
        }
        return author;
    }

}
