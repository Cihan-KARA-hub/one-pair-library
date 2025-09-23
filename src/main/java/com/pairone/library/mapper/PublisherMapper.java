package com.pairone.library.mapper;

import com.pairone.library.dto.publisher.Request.PublisherCreateRequest;
import com.pairone.library.dto.publisher.Request.PublisherUpdateRequest;
import com.pairone.library.dto.publisher.Response.PublisherResponse;
import com.pairone.library.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

     Publisher toEntity(PublisherCreateRequest request);
    @Mapping(target = "publisherId",source = "id")
     PublisherResponse toResponse(Publisher save);

    Publisher updateEntity(PublisherUpdateRequest request);

}
