package com.pairone.library.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pairone.library.entity.enums.BookStatus;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "page_count", nullable = false)
    private int pageCount;

    @Column(name = "edition_no", nullable = false)
    private int editionNo;

    @Column(name = "available_copies", nullable = false)
    private int availableCopies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookinfo_id", nullable = false)
    @JsonIgnore
    private BookInfo bookinfoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    @JsonIgnore
    private Publisher publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Author> authors = new HashSet<>();

    @Column(name = "book_status")
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    public Book() {
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public int getEditionNo() {
        return editionNo;
    }

    public void setEditionNo(int editionNo) {
        this.editionNo = editionNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}