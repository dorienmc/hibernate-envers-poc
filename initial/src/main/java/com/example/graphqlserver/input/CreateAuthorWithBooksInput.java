package com.example.graphqlserver.input;

import java.util.List;

/**
 * @author Dorien Lorijn
 */
public record CreateAuthorWithBooksInput(CreateAuthorInput author, List<CreateBookInput> books) {

}
