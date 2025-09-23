package com.pairone.library.mapper;

import com.pairone.library.dto.bookinfo.reponse.BookInfoGetResponseDto;
import com.pairone.library.dto.bookinfo.reponse.BookInfoUpdateResponseDto;
import com.pairone.library.dto.bookinfo.request.BookInfoCreateRequestDto;
import com.pairone.library.dto.bookinfo.reponse.BookInfoCreateResponseDto;
import com.pairone.library.dto.bookinfo.request.BookInfoUpdateRequestDto;
import com.pairone.library.entity.BookInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookInfoMapper {
    BookInfoMapper INSTANCE = Mappers.getMapper(BookInfoMapper.class);
    BookInfo  bookInfoCreateDtoMapToEntity(BookInfoCreateRequestDto dto);
    BookInfo  bookInfoUpdateDtoMapToEntity(BookInfoUpdateRequestDto dto);
    BookInfoCreateResponseDto mapToBookInfoCreateResponseDto(BookInfo bookInfo);
    BookInfoUpdateResponseDto mapToBookInfoUpdateResponseDto(BookInfo bookInfo);

    @Mapping(source = "availableCopies", target = "availableCopies")
    @Mapping(source = "totalCopy", target = "totalCopy")
    BookInfoGetResponseDto mapToBookInfoGetResponseDto(BookInfo bookInfo);

}
