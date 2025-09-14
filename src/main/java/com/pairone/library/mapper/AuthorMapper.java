package com.pairone.library.mapper;

import com.pairone.library.dto.author.AuthorDto;
import com.pairone.library.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;



@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author  MapToEntity(AuthorDto dto);

    AuthorDto mapToDto(Author author);

    List<Author> mapToEntityList(List<AuthorDto> dtoList);

}
