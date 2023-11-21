package com.example.graphqlserver.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphqlserver.entity.Author;

/**
 * @author Dorien Lorijn
 */
public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
