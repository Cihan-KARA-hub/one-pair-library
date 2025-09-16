package com.pairone.library.service;

import com.pairone.library.dto.bookinfo.reponse.BookInfoCreateResponseDto;
import com.pairone.library.dto.bookinfo.reponse.BookInfoGetResponseDto;
import com.pairone.library.dto.bookinfo.reponse.BookInfoUpdateResponseDto;
import com.pairone.library.dto.bookinfo.request.BookInfoCreateRequestDto;
import com.pairone.library.dto.bookinfo.request.BookInfoUpdateRequestDto;
import com.pairone.library.entity.BookInfo;
import com.pairone.library.mapper.BookInfoMapper;
import com.pairone.library.repository.BookInfoRepository;
import com.pairone.library.rules.BookInfoBusinessRule;
import com.pairone.library.service.abstractservice.BookInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class BookInfoServiceImpl implements BookInfoService {
    private final BookInfoRepository bookInfoRepository;
    private final BookInfoMapper bookInfoMapper;
    private final BookInfoBusinessRule bookInfoBusinessRule;

    public BookInfoServiceImpl(BookInfoRepository bookInfoRepository, BookInfoMapper bookInfoMapper, BookInfoBusinessRule bookInfoBusinessRule) {
        this.bookInfoRepository = bookInfoRepository;
        this.bookInfoMapper = bookInfoMapper.INSTANCE;
        this.bookInfoBusinessRule = bookInfoBusinessRule;
    }

    @Override
    public BookInfoCreateResponseDto save(BookInfoCreateRequestDto bookInfo) {
        bookInfoBusinessRule.bookInfoMustNotExistWithGivenId(bookInfo.getIsbn());
        BookInfo info = bookInfoMapper.bookInfoCreateDtoMapToEntity(bookInfo);
        bookInfoRepository.save(info);
        return bookInfoMapper.mapToBookInfoCreateResponseDto(info);
    }

    @Override
    public BookInfoUpdateResponseDto update(BookInfoUpdateRequestDto bookInfo) {
        bookInfoBusinessRule.bookInfoMustExistWithGivenId(bookInfo.getBookId());
        BookInfo info = bookInfoMapper.bookInfoUpdateDtoMapToEntity(bookInfo);
        bookInfoRepository.save(info);
        return bookInfoMapper.mapToBookInfoUpdateResponseDto(info);
    }

    @Override
    public BookInfoGetResponseDto getBookInfo(Integer bookId) {
        BookInfo info = bookInfoBusinessRule.bookInfoMustExistWithGivenId(bookId);
        return bookInfoMapper.mapToBookInfoGetResponseDto(info);
    }
    @Override
    public Page<BookInfoGetResponseDto> getAll(int size ,int page) {
        Pageable pageable = PageRequest.of(size, page);
        Page<BookInfo> info = bookInfoBusinessRule.findAll(pageable);
        return info.map(bookInfoMapper::mapToBookInfoGetResponseDto);
    }
}
