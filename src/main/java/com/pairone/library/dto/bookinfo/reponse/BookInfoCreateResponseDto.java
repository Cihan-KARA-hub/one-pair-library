package com.pairone.library.dto.bookinfo.reponse;

public class BookInfoCreateResponseDto {
    private Integer bookId;
    private String isbn;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
