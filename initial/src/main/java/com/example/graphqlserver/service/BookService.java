package com.example.graphqlserver.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.graphqlserver.entity.Book;
import com.example.graphqlserver.repository.BookRepository;

/**
 * Dorien Lorijn
 */
@Component
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book update(Book book) {
        return bookRepository.save(book);
    }

    public boolean delete(UUID bookId){
        Book book = findById(bookId);
        if (book != null) {
            bookRepository.delete(book);
            return true;
        }
        return false;
    }

    public Book findById(UUID id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
