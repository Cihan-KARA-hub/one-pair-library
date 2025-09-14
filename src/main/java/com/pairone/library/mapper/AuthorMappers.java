package com.pairone.library.mapper;

import com.pairone.library.dto.author.AuthorDto;
import com.pairone.library.entity.Author;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorMappers {


    public AuthorDto mapToDto(Author author) {
        AuthorDto dto = new AuthorDto();
        dto.setAuthorId(author.getAuthorId());
        dto.setFirstname(author.getFirstname());
        dto.setLastname(author.getLastname());
        return dto;
    }

    public Author MapToEntity(AuthorDto dto) {
        Author author = new Author();
        dto.setAuthorId(author.getAuthorId());
        author.setFirstname(dto.getFirstname());
        author.setLastname(dto.getLastname());
        return author;
    }
    public List<Author> mapToEntityList(List<AuthorDto> dtoList) {
        return dtoList.stream()
                .map(this::MapToEntity)
                .toList();
    }
}
