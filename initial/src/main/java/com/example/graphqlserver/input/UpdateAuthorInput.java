package com.example.graphqlserver.input;

import java.util.UUID;

/**
 * TODO: Description
 * @author Dorien Lorijn
 */
public record UpdateAuthorInput(UUID id, String firstName, String lastName) {

}
