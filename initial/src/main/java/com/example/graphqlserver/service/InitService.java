package com.example.graphqlserver.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.graphqlserver.entity.Author;
import com.example.graphqlserver.entity.Book;

/**
 * @author Dorien Lorijn
 */
@Service
public class InitService {
    private final AuthorService authorService;
    private final BookService bookService;

    public InitService(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    private final List<Author> initAuthors = List.of(
            new Author("Joshua", "Bloch"),
            new Author("Douglas", "Adams"),
            new Author("Bill", "Bryson")
    );

    private final List<Book> initBooks = List.of(
            new Book("Effective Java", 416),
            new Book("Hitchhiker's Guide to the Galaxy", 208),
            new Book("Down Under", 436)
    );

    public void initialize() {
        initAuthors.forEach( au -> authorService.create(au));
        initBooks.forEach( book -> bookService.create(book));
    }
}
