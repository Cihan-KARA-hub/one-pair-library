package com.pairone.library.dto.book.request;

import com.pairone.library.entity.enums.BookStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Set;

public class BookUpdateRequest {
    @NotNull
    private Integer id;
    @NotBlank
    private String name;

    @NotNull
    @Positive
    private int pageCount;
    @NotNull
    @Positive
    private int editionNo;
    @NotNull
    private int bookInfoId;
    @NotNull
    private int publisherId;
    @NotNull
    private int categoryId;
    @NotNull
    private Set<Integer> authorId;
    @NotNull
    private BookStatus bookStatus;
    public BookUpdateRequest() {
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
    @Positive
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(@NotNull @Positive int pageCount) {
        this.pageCount = pageCount;
    }

    @NotNull
    @Positive
    public int getEditionNo() {
        return editionNo;
    }

    public void setEditionNo(@NotNull @Positive int editionNo) {
        this.editionNo = editionNo;
    }

    @NotNull
    public int getBookInfoId() {
        return bookInfoId;
    }

    public void setBookInfoId(@NotNull int bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    @NotNull
    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(@NotNull int publisherId) {
        this.publisherId = publisherId;
    }

    @NotNull
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@NotNull int categoryId) {
        this.categoryId = categoryId;
    }

    public @NotNull Set<Integer> getAuthorId() {
        return authorId;
    }

    public void setAuthorId(@NotNull Set<Integer> authorId) {
        this.authorId = authorId;
    }

    public @NotNull BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(@NotNull BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }
}
