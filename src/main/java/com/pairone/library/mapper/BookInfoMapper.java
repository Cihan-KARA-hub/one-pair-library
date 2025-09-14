package com.pairone.library.mapper;

import com.pairone.library.dto.bookinfo.BookGetResponse;
import com.pairone.library.dto.bookinfo.BookInfoCreateDto;
import com.pairone.library.entity.BookInfo;
import org.springframework.stereotype.Component;

@Component
public class BookInfoMapper {

    public BookInfoCreateDto entityToDto(BookInfo entity) {
        return new BookInfoCreateDto(
                entity.getBookId(),
                entity.getIsbn(),
                entity.getTitle(),
                entity.getStatus(),
                entity.getType(),
                entity.getLanguage(),
                entity.getCondition(),
                entity.getCopyCount(),
                entity.getLocation(),
                entity.getBarcode());
    }
    public BookInfo GetDtoToEntity(BookInfoCreateDto dto) {
        if (dto == null) return null;
        BookInfo entity = new BookInfo();
        entity.setIsbn(dto.getIsbn());
        entity.setTitle(dto.getTitle());
        entity.setStatus(dto.getStatus());
        entity.setType(dto.getType());
        entity.setLanguage(dto.getLanguage());
        entity.setCondition(dto.getCondition());
        entity.setCopyCount(dto.getCopyCount());
        entity.setLocation(dto.getLocation());
        entity.setBarcode(dto.getBarcode());

        return entity;
    }

    public BookGetResponse bookGetResponseInfo(BookInfo entity) {
        return new BookGetResponse(
                entity.getBookId(),
                entity.getIsbn(),
                entity.getTitle(),
                entity.getStatus(),
                entity.getType(),
                entity.getLanguage(),
                entity.getCondition(),
                entity.getCopyCount(),
                entity.getLocation(),
                entity.getBarcode());
    }
    }

