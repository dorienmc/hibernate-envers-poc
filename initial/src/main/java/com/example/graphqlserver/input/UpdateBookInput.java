package com.example.graphqlserver.input;

import java.util.UUID;

/**
 * TODO: Description
 * @author Dorien Lorijn
 */
public record UpdateBookInput(UUID id, String name, int pageCount) {
}
