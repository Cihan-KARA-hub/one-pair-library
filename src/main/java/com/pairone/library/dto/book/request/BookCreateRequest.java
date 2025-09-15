package com.pairone.library.dto.book.request;

import java.util.List;
import java.util.Set;

public class BookCreateRequest {

    private String name;
    private int pageCount;
    private int editionNo;
    private int bookInfoId;
    private int publisherId;
    private int categoryId;
    private Set<Integer> authorId;
    public BookCreateRequest() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public int getEditionNo() {
        return editionNo;
    }

    public void setEditionNo(int editionNo) {
        this.editionNo = editionNo;
    }

    public int getBookInfoId() {
        return bookInfoId;
    }

    public void setBookInfoId(int bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public Set<Integer> getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Set<Integer> authorId) {
        this.authorId = authorId;
    }

}
