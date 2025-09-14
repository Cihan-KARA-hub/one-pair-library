package com.pairone.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book_info")
public class BookInfo {
    /* isbn varchar
 title varchar
 status varchar
 type varchar
 language varchar
 condition varchar
 copy_count int
 location varchar
 barcode varchar
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    @Column(name = "isbn", nullable = false)
    private String isbn;
    @Column(name = "title", length = 255)
    private String title;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "language", length = 3, nullable = false)
    private String language;
    @Column(name = "condition", nullable = false)
    private String condition;
    @Column(name = "copy_count")
    private int copyCount;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "barcode", length = 13, nullable = false)
    private String barcode;
    @OneToMany(mappedBy = "BookInfo", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    public int getCopyCount() {
        return copyCount;
    }

    public void setCopyCount(int copyCount) {
        this.copyCount = copyCount;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

}
