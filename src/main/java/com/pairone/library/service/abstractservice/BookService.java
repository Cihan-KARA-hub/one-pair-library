package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.book.request.BookCreateRequest;
import com.pairone.library.dto.book.request.BookUpdateRequest;
import com.pairone.library.dto.book.response.BookCreateResponse;
import com.pairone.library.dto.book.response.BookDeleteResponse;
import com.pairone.library.dto.book.response.BookListResponse;
import com.pairone.library.dto.book.response.BookUpdateResponse;
import org.springframework.data.domain.Page;

public interface BookService {
    BookCreateResponse create(BookCreateRequest req);

    BookUpdateResponse update(BookUpdateRequest req);
    BookDeleteResponse delete(Integer id);

    Page<BookListResponse> getAll(int size, int page);}
