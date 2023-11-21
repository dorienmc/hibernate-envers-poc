package com.example.graphqlserver.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphqlserver.entity.Book;

/**
 * @author Dorien Lorijn
 */

public interface BookRepository extends JpaRepository<Book, UUID> {

}
