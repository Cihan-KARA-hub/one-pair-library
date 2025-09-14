package com.pairone.library.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstname", length = 35, nullable = false)
    private String firstname;
    @Column(name = "lastname", length = 35, nullable = false)
    private String lastname;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

    public Author(List<Book> books) {
        this.books = books;
    }

    public Author() {

    }

    public void setFirstname(String firstname) {
    }

    public void setLastname(String lastname) {
    }

    public Integer getAuthorId() {
        return 0;
    }

    public String getFirstname() {
        return "";
    }

    public String getLastname() {
        return "";
    }
}
