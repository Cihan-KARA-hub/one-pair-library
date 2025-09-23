package com.pairone.library.dto.book.response;


import com.pairone.library.entity.enums.BookStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

public class BookListResponse {
    @NotNull
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    private int pageCount;
    @NotNull
    private int editionNo;
    @NotNull
    private Integer bookinfoId;
    @NotNull
    private Integer publisher;
    @NotNull
    private Integer category;
    @NotNull
    private Set<Integer> authors = new HashSet<>();
    @NotNull
    private BookStatus bookStatus;

    public BookListResponse() {
    }

    public @NotNull Integer getId() {
        return id;
    }

    public void setId(@NotNull Integer id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    @NotNull
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(@NotNull int pageCount) {
        this.pageCount = pageCount;
    }

    @NotNull
    public int getEditionNo() {
        return editionNo;
    }

    public void setEditionNo(@NotNull int editionNo) {
        this.editionNo = editionNo;
    }

    public @NotNull Integer getBookinfoId() {
        return bookinfoId;
    }

    public void setBookinfoId(@NotNull Integer bookinfoId) {
        this.bookinfoId = bookinfoId;
    }

    public @NotNull Integer getPublisher() {
        return publisher;
    }

    public void setPublisher(@NotNull Integer publisher) {
        this.publisher = publisher;
    }

    public @NotNull Integer getCategory() {
        return category;
    }

    public void setCategory(@NotNull Integer category) {
        this.category = category;
    }

    public @NotNull Set<Integer> getAuthors() {
        return authors;
    }

    public void setAuthors(@NotNull Set<Integer> authors) {
        this.authors = authors;
    }

    public @NotNull BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(@NotNull BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }
}



