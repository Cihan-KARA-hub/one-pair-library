package com.pairone.library.mapper;

import com.pairone.library.dto.author.request.AuthorCreateRequestDto;
import com.pairone.library.dto.author.request.AuthorUpdateRequestDto;
import com.pairone.library.dto.author.response.AuthorCreateResponse;
import com.pairone.library.dto.author.response.AuthorDeleteResponse;
import com.pairone.library.dto.author.response.AuthorGetResponse;
import com.pairone.library.dto.author.response.AuthorUpdateResponse;
import com.pairone.library.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Mapping(target = "books", ignore = true)
    Author mapToEntity(AuthorCreateRequestDto dto);

    @Mapping(target = "books", ignore = true)
    Author mapToEntity(AuthorUpdateRequestDto dto);

    AuthorUpdateResponse mapUpdateToDto(Author author);

    AuthorCreateResponse mapCreateToDto(Author author);

    AuthorDeleteResponse mapToAuthorDelete(Author author);

    AuthorGetResponse mapToAuthorGet(Author author);


}
