package com.pairone.library.mapper;

import com.pairone.library.dto.publisher.Request.PublisherCreateRequest;
import com.pairone.library.dto.publisher.Request.PublisherUpdateRequest;
import com.pairone.library.dto.publisher.Response.PublisherResponse;
import com.pairone.library.entity.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper {

    // CreateRequest -> Entity
    public static Publisher toEntity(PublisherCreateRequest request) {
        if (request == null) {
            return null;
        }

        Publisher publisher = new Publisher();
        publisher.setName(request.getName());
        return publisher;
    }

    // Entity -> Response
    public static PublisherResponse toResponse(Publisher publisher) {
        if (publisher == null) {
            return null;
        }

        return new PublisherResponse(publisher.getId(), publisher.getName());
    }

    // UpdateRequest -> Existing Entity
    public static void updateEntity(Publisher publisher, PublisherUpdateRequest request) {
        if (publisher != null && request != null) {
            publisher.setName(request.getName());
        }
    }
}
