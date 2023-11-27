package com.example.graphqlserver.entity;

import java.util.UUID;

import com.example.graphqlserver.input.CreateBookInput;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

/**
 * Book
 *
 * @author Dorien Lorijn
 */
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private UUID id;

    @Version
    private long version;
    @Column
    private String name;
    @Column
    private int pageCount;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(String name, int pageCount) {
        this.name = name;
        this.pageCount = pageCount;
    }

    public Book() {

    }

    public static Book of(CreateBookInput bookInput) {
        return new Book(bookInput.name(), bookInput.pageCount());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
