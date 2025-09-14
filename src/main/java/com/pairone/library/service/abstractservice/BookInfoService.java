package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.bookinfo.reponse.BookInfoCreateResponseDto;
import com.pairone.library.dto.bookinfo.reponse.BookInfoGetResponseDto;
import com.pairone.library.dto.bookinfo.reponse.BookInfoUpdateResponseDto;
import com.pairone.library.dto.bookinfo.request.BookInfoCreateRequestDto;
import com.pairone.library.dto.bookinfo.request.BookInfoUpdateRequestDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookInfoService {
    BookInfoCreateResponseDto save(BookInfoCreateRequestDto bookInfo);
    BookInfoUpdateResponseDto update(BookInfoUpdateRequestDto bookInfo);
    BookInfoGetResponseDto getBookInfo(Integer bookId);
    Page<BookInfoGetResponseDto> getAll(int size ,int page);
}
