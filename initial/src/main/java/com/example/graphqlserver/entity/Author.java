package com.example.graphqlserver.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Dorien Lorijn
 */
@Entity
@Table(name = "author")
public class Author {

    @Id
    private UUID id = UUID.randomUUID();
    @Column
    private String firstName;
    @Column
    private String lastName;

    public Author(String tag, String firstName, String lastName) {
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
