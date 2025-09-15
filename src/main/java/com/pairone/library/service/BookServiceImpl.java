package com.pairone.library.service;

import com.pairone.library.dto.book.request.BookCreateRequest;
import com.pairone.library.dto.book.request.BookUpdateRequest;
import com.pairone.library.dto.book.response.BookCreateResponse;
import com.pairone.library.dto.book.response.BookDeleteResponseDto;
import com.pairone.library.dto.book.response.BookListResponseDto;
import com.pairone.library.dto.book.response.BookUpdateResponse;
import com.pairone.library.entity.Book;
import com.pairone.library.mapper.BookMapper;
import com.pairone.library.repository.BookRepository;
import com.pairone.library.rules.*;
import com.pairone.library.service.abstractservice.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookBusinessRule bookBusinessRule;
    private final CategoryBusinessRule categoryBusinessRule;
    private final BookInfoBusinessRule bookInfoBusinessRule;
    private final PublisherBusinessRule publisherBusinessRule;
    private final AuthorBusinessRule authorBusinessRule;

    public BookServiceImpl(BookRepository bookRepository,
                           BookMapper bookMapper,
                           BookBusinessRule bookBusinessRule,
                           CategoryBusinessRule categoryBusinessRule,
                           BookInfoBusinessRule bookInfoBusinessRule,
                           PublisherBusinessRule publisherBusinessRule, AuthorBusinessRule authorBusinessRule) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper.INSTANCE;
        this.bookBusinessRule = bookBusinessRule;
        this.categoryBusinessRule = categoryBusinessRule;
        this.bookInfoBusinessRule = bookInfoBusinessRule;
        this.publisherBusinessRule = publisherBusinessRule;
        this.authorBusinessRule = authorBusinessRule;
    }


    public BookCreateResponse create(BookCreateRequest req) {
        Book book = bookMapper.BookCreateRequestToEntity(req);
        book.setCategory(categoryBusinessRule.getCategoryMustExistWithGivenId(req.getCategoryId()));
        book.setBookinfoId(bookInfoBusinessRule.bookInfoMustExistWithGivenId(req.getBookInfoId()));
        book.setPublisher(publisherBusinessRule.bookServiceGetPublisher(req.getPublisherId()));
        book.setAuthors(authorBusinessRule.findByIds(req.getAuthorId()));
        bookBusinessRule.findBookIsNotExists(book);
        Book createdBook = bookRepository.save(book);
        return bookMapper.toDto(createdBook);

    }


    public BookUpdateResponse update(BookUpdateRequest req) {
        Book book = bookMapper.BookUpdateRequestToEntity(req);
        book.setCategory(categoryBusinessRule.getCategoryMustExistWithGivenId(req.getCategoryId()));
        book.setBookinfoId(bookInfoBusinessRule.bookInfoMustExistWithGivenId(req.getBookInfoId()));
        book.setPublisher(publisherBusinessRule.bookServiceGetPublisher(req.getPublisherId()));
        book.setAuthors(authorBusinessRule.findByIds(req.getAuthorId()));
        bookBusinessRule.findBookIsNotExists(book);
        Book createdBook = bookRepository.save(book);
        return bookMapper.EntityToBookUpdateResponse(createdBook);

    }

    public BookDeleteResponseDto delete(Integer id) {
        Book book = bookBusinessRule.findBookIsExists(id);
        bookRepository.delete(book);
        return bookMapper.bookDeleteResponseDto(book);

    }

    public List<BookListResponseDto> getAll(int size, int page) {

    }
}
