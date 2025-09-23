package com.pairone.library.mapper;

import com.pairone.library.dto.book.request.BookCreateRequest;
import com.pairone.library.dto.book.request.BookUpdateRequest;
import com.pairone.library.dto.book.response.BookCreateResponse;
import com.pairone.library.dto.book.response.BookDeleteResponse;
import com.pairone.library.dto.book.response.BookListResponse;
import com.pairone.library.dto.book.response.BookUpdateResponse;
import com.pairone.library.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "id", ignore = true) // DTO’da yok
    @Mapping(target = "bookinfoId", source = "bookInfoId", qualifiedByName = "mapBookInfo")
    @Mapping(target = "publisher", source = "publisherId", qualifiedByName = "mapPublisher")
    @Mapping(target = "category", source = "categoryId", qualifiedByName = "mapCategory")
    @Mapping(target = "authors", source = "authorId", qualifiedByName = "mapAuthors")
    Book BookCreateRequestToEntity(BookCreateRequest dto);

    @Mapping(target = "id", ignore = true) // DTO’da yok
    @Mapping(target = "bookinfoId", source = "bookInfoId", qualifiedByName = "mapBookInfo")
    @Mapping(target = "publisher", source = "publisherId", qualifiedByName = "mapPublisher")
    @Mapping(target = "category", source = "categoryId", qualifiedByName = "mapCategory")
    @Mapping(target = "authors", source = "authorId", qualifiedByName = "mapAuthors")
    Book BookUpdateRequestToEntity(BookUpdateRequest dto);

    BookCreateResponse toDto(Book book);

    BookUpdateResponse EntityToBookUpdateResponse(Book createdBook);
    BookDeleteResponse bookDeleteResponseDto(Book book);
    @Mapping(source = "bookinfoId.bookId", target = "bookinfoId")
    @Mapping(source = "publisher.id", target = "publisher")
    @Mapping(source = "category.id", target = "category")
    @Mapping(source = "authors", target = "authors", qualifiedByName = "authorsToIds")
    BookListResponse entityToBookListResponseDto(Book book);

    @Named("authorsToIds")
    default Set<Integer> authorsToIds(Set<com.pairone.library.entity.Author> authors) {
        return authors.stream()
                .map(com.pairone.library.entity.Author::getId)
                .collect(Collectors.toSet());
    }


    @Named("mapBookInfo")
    default BookInfo mapBookInfo(Integer id) {
        if (id == null) return null;
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookId(id);
        return bookInfo;
    }

    @Named("mapPublisher")
    default Publisher mapPublisher(Integer id) {
        if (id == null) return null;
        Publisher publisher = new Publisher();
        publisher.setId(id);
        return publisher;
    }

    @Named("mapCategory")
    default Category mapCategory(Integer id) {
        if (id == null) return null;
        Category category = new Category();
        category.setId(id);
        return category;
    }

    @Named("mapAuthors")
    default Set<Author> mapAuthors(Set<Integer> ids) {
        if (ids == null || ids.isEmpty()) return new HashSet<>();
        return ids.stream()
                .map(id -> {
                    Author author = new Author();
                    author.setId(id);
                    return author;
                })
                .collect(Collectors.toSet());
    }
}
