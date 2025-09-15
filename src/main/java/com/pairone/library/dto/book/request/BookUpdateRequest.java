package com.pairone.library.dto.book.request;

import com.pairone.library.dto.bookinfo.request.BookInfoCreateRequestDto;

import java.util.List;

public class BookUpdateRequest {
    private int id;
    private String name;
    private int pageCount;
    private int editionNo;
    private BookInfoCreateRequestDto bookinfoId;
    private Integer publisherId;
    private Integer categoryId;
    private List<Integer> authorId;

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
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

    public BookInfoCreateRequestDto getBookinfoId() {
        return bookinfoId;
    }

    public void setBookinfoId(BookInfoCreateRequestDto bookinfoId) {
        this.bookinfoId = bookinfoId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<Integer> getAuthorId() {
        return authorId;
    }

    public void setAuthorId(List<Integer> authorId) {
        this.authorId = authorId;
    }


}
