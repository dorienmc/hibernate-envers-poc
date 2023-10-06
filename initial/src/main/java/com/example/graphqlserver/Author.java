package com.example.graphqlserver;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dorien Lorijn
 */
public record Author(String id, String firstName, String lastName) {

    private static List<Author> authors = Arrays.asList(
            new Author("author-1", "Joshua", "Bloch"),
            new Author("author-2", "Douglas", "Adams"),
            new Author("author-3", "Bill", "Bryson")
    );

    public static Author getById(String id) {
        return authors.stream().filter( a -> a.id().equals(id)).findFirst().orElse(null);
    }
}
