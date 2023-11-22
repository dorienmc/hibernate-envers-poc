package com.example.graphqlserver.entity;

import java.util.List;
import java.util.UUID;

import com.example.graphqlserver.input.CreateAuthorInput;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

/**
 * @author Dorien Lorijn
 */
@Audited( withModifiedFlag = true )
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String firstName;
    @Column
    private String lastName;

    @NotAudited
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author() {
    }

    public static Author of(CreateAuthorInput input) {
        return new Author(input.firstName(), input.lastName());
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
