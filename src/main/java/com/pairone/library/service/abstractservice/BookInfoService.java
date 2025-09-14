package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.bookinfo.BookGetResponse;
import com.pairone.library.dto.bookinfo.BookInfoCreateDto;
import com.pairone.library.entity.BookInfo;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface BookInfoService {
    BookInfo save(BookInfoCreateDto bookInfo);
    BookInfoCreateDto getBookInfo(Integer bookId) throws ChangeSetPersister.NotFoundException;
    BookGetResponse getBookId(int bookId);
}
