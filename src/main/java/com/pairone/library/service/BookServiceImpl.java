package com.pairone.library.service;

import com.pairone.library.dto.book.*;
import com.pairone.library.entity.*;

import com.pairone.library.repository.BookRepository;
import com.pairone.library.service.abstractservice.AuthorService;
import com.pairone.library.service.abstractservice.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorService authorService;
    private final AuthorMappers authorMappers;
    private final BookInfoServiceImpl bookInfoService;
    private final PublisherServiceImpl publisherServiceImpl;
    private final CategoryServiceImpl categoryServiceImpl;


    public BookServiceImpl(BookRepository bookRepository,
                           BookMapper bookMapper,
                           AuthorService authorService,
                           AuthorMappers authorMappers,
                           BookInfoServiceImpl bookInfoService,
                           PublisherServiceImpl publisherServiceImpl, CategoryServiceImpl categoryServiceImpl) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.authorService = authorService;
        this.authorMappers = authorMappers;
        this.bookInfoService = bookInfoService;
        this.publisherServiceImpl = publisherServiceImpl;
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @Transactional
    public BookCreateRes create(BookCreateReq req) {
        List<AuthorDto> authorDtos = req.getAuthorId().stream()
                .map(authorService::getAuthorById)
                .toList();
        List<Author> authors = authorMappers.mapToEntityList(authorDtos);
        BookInfo bookInfo = bookInfoService.save(req.getBookinfoId());
        Publisher publisher = publisherServiceImpl.bookServiceGetPublisher(req.getPublisherId());
        Category category = categoryServiceImpl.getCategoryId(req.getCategoryId());
        bookRepository.save(bookMapper.BookCreateReqToEntity(req, bookInfo, publisher, authors, category));
        return new BookCreateRes(req.getName(), "Book Created");
    }


    public BookUpdateRes update(BookUpdateReq req) {
        bookRepository.findById(req.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "book not found "));
        List<AuthorDto> authorDtos = req.getAuthorId().stream()
                .map(authorService::getAuthorById)
                .toList();
        List<Author> authors = authorMappers.mapToEntityList(authorDtos);
        BookInfo bookInfo = bookInfoService.save(req.getBookinfoId());
        Publisher publisher = publisherServiceImpl.bookServiceGetPublisher(req.getPublisherId());
        Category category = categoryServiceImpl.getCategoryId(req.getCategoryId());
        Book resBook = bookRepository.save(bookMapper.BookUpdateReqToEntity(req, bookInfo, publisher, authors, category));
        return new BookUpdateRes(req.getName(), resBook.getId()+ "Book Updated");
    }

    public String delete(Integer id) {
        bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "book not found "));
        bookRepository.deleteById(id);
        return "Book Deleted" + id;
    }

    public List<BookListDto> getAll(int size, int page) {
        Pageable pageable = PageRequest.of(size, page);
        Page<Book> books = bookRepository.findAll(pageable);
        return books.stream().map(bookMapper::BookListDtoMap).toList();

    }
}
