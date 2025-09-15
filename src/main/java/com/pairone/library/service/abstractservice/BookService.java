package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.book.request.BookCreateRequest;
import com.pairone.library.dto.book.request.BookUpdateRequest;
import com.pairone.library.dto.book.response.BookCreateResponse;
import com.pairone.library.dto.book.response.BookDeleteResponseDto;
import com.pairone.library.dto.book.response.BookListResponseDto;
import com.pairone.library.dto.book.response.BookUpdateResponse;

import java.util.List;

public interface BookService {
    BookCreateResponse create(BookCreateRequest req);

    BookUpdateResponse update(BookUpdateRequest req);
    BookDeleteResponseDto delete(Integer id);

    List<BookListResponseDto> getAll(int size, int page);}
