package com.example.graphqlserver;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

/**
 * Controller to retrieve books
 *
 * @author Dorien Lorijn
 */
@Controller
public class BookController {

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @QueryMapping
    public List<Book> books() {
        return Book.findAll();
    }

    @SchemaMapping
    public Author authorById(Book book){
        return Author.getById(book.authorId());
    }
}
