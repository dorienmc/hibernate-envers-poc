package com.example.graphqlserver.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.graphqlserver.entity.Author;
import com.example.graphqlserver.input.CreateAuthorInput;
import com.example.graphqlserver.service.AuthorService;

/**
 * TODO: Description
 * @author Dorien Lorijn
 */
@Controller
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public List<Author> authors() {
        return authorService.findAll();
    }

    @MutationMapping
    public Author createAuthor(@Argument CreateAuthorInput input) {
        return authorService.create(Author.of(input));
    }

}
