package com.example.graphqlserver.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.graphqlserver.entity.Author;
import com.example.graphqlserver.repository.AuthorRepository;

/**
 * @author Dorien Lorijn
 */
@Component
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author create(Author author) {
        return authorRepository.save(author);
    }

    public Author update(Author author) {
        return authorRepository.save(author);
    }

    public void delete(Author author){
        authorRepository.delete(author);
    }

    public Author findById(UUID id) {
        return authorRepository.findById(id).orElse(null);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
