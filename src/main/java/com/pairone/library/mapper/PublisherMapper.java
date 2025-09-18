package com.pairone.library.mapper;

import com.pairone.library.dto.publisher.Request.PublisherCreateRequest;
import com.pairone.library.dto.publisher.Request.PublisherUpdateRequest;
import com.pairone.library.dto.publisher.Response.PublisherResponse;
import com.pairone.library.entity.Publisher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    static Publisher toEntity(PublisherCreateRequest request) {
        return null;
    }

    static PublisherResponse toResponse(Publisher save) {
        return null;
    }

    static void updateEntity(Publisher existing, PublisherUpdateRequest request) {

    }
}
