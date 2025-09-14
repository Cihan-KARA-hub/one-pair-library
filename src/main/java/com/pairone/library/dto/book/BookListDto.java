package com.pairone.library.dto.book;

import java.util.List;
import java.util.Set;

public class BookListDto {
    private int id;
    private String name;
    private int pageCount;
    private int editionNo;
    private BookListBookInfoDto bookinfoId;
    private BookListPublisherDto publisher;
    private String categoryName;
    private List<String> authors;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public int getEditionNo() {
        return editionNo;
    }

    public void setEditionNo(int editionNo) {
        this.editionNo = editionNo;
    }

    public BookListBookInfoDto getBookinfoId() {
        return bookinfoId;
    }

    public void setBookinfoId(BookListBookInfoDto bookinfoId) {
        this.bookinfoId = bookinfoId;
    }

    public BookListPublisherDto getPublisher() {
        return publisher;
    }

    public void setPublisher(BookListPublisherDto publisher) {
        this.publisher = publisher;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

}



