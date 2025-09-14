package com.pairone.library.dto.book;

import com.pairone.library.dto.bookinfo.BookInfoCreateDto;

import java.util.List;

public class BookUpdateReq {
    private int id;
    private String name;
    private int pageCount;
    private int editionNo;
    private BookInfoCreateDto bookinfoId;
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

    public BookInfoCreateDto getBookinfoId() {
        return bookinfoId;
    }

    public void setBookinfoId(BookInfoCreateDto bookinfoId) {
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
