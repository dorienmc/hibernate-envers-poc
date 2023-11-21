package com.example.graphqlserver;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * TODO: Description
 * @author Dorien Lorijn
 */
@Controller
public class AuthorController {

    @QueryMapping
    public Author authorById(@Argument String id) {
                return Author.getById(id);
            }

    @QueryMapping
    public List<Author> authors() {
        return Author.findAll();
    }

}
