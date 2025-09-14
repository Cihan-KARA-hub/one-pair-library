package com.pairone.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    /*book_id int
 name varchar
 page_count int
 edition_no int
 bookinfo_id int
 publisher_id int
 category_id int
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "page_count", nullable = false)
    private int pageCount;
    @Column(name = "edition_no", nullable = false)
    private int editionNo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookinfo_id", nullable = false)
    private BookInfo bookinfoId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)

    private Set<Author> authors = new HashSet<>();

    public Book() {
    }


    public int getEditionNo() {
        return editionNo;
    }

    public void setEditionNo(int editionNo) {
        this.editionNo = editionNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public BookInfo getBookinfoId() {
        return bookinfoId;
    }

    public void setBookinfoId(BookInfo bookinfoId) {
        this.bookinfoId = bookinfoId;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
