package com.pairone.library.service;

import com.pairone.library.dto.book.request.BookCreateRequest;
import com.pairone.library.dto.book.request.BookUpdateRequest;
import com.pairone.library.dto.book.response.BookCreateResponse;
import com.pairone.library.dto.book.response.BookDeleteResponseDto;
import com.pairone.library.dto.book.response.BookListResponseDto;
import com.pairone.library.dto.book.response.BookUpdateResponse;
import com.pairone.library.service.abstractservice.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    public BookServiceImpl() {
    }


    public BookCreateResponse create(BookCreateRequest req) {


    }


    public BookUpdateResponse update(BookUpdateRequest req) {

    }

    public BookDeleteResponseDto delete(Integer id) {

    }

    public List<BookListResponseDto> getAll(int size, int page) {

    }
}
