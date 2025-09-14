package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.publisher.Request.PublisherCreateRequest;
import com.pairone.library.dto.publisher.Request.PublisherUpdateRequest;
import com.pairone.library.dto.publisher.Response.PublisherResponse;
import com.pairone.library.entity.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher bookServiceGetPublisher(Integer id);
    void delete(Integer id);
    List<PublisherResponse> getAll();
    PublisherResponse getById(Integer id);
    PublisherResponse update(Integer id, PublisherUpdateRequest request);
    PublisherResponse create(PublisherCreateRequest request);
}
