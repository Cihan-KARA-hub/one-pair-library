package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.author.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto dto);
    AuthorDto updateAuthor(Integer id, AuthorDto dto);
    void deleteAuthor(Integer id);
    AuthorDto getAuthorById(Integer id);
    List<AuthorDto> getAllAuthors();

}
