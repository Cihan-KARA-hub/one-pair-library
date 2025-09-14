package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.book.*;

import java.util.List;

public interface BookService {
    BookCreateRes create(BookCreateReq req);

    BookUpdateRes update(BookUpdateReq req);

    String delete(Integer id);

    List<BookListDto> getAll(int size, int page);}
