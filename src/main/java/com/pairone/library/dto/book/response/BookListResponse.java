package com.pairone.library.dto.book.response;


import com.pairone.library.entity.Author;
import com.pairone.library.entity.BookInfo;
import com.pairone.library.entity.Category;
import com.pairone.library.entity.Publisher;
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
    private BookInfo bookinfoId;
    @NotNull
    private Publisher publisher;
    @NotNull
    private Category category;
    @NotNull
    private Set<Author> authors = new HashSet<>();
    @NotNull
    private BookStatus bookStatus;

    public @NotNull BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(@NotNull BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public @NotNull BookInfo getBookinfoId() {
        return bookinfoId;
    }

    public void setBookinfoId(@NotNull BookInfo bookinfoId) {
        this.bookinfoId = bookinfoId;
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

    public @NotNull Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(@NotNull Publisher publisher) {
        this.publisher = publisher;
    }

    public @NotNull Category getCategory() {
        return category;
    }

    public void setCategory(@NotNull Category category) {
        this.category = category;
    }

    public @NotNull Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(@NotNull Set<Author> authors) {
        this.authors = authors;
    }
}



