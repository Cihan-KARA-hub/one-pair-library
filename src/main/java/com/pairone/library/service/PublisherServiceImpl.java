package com.pairone.library.service;

import com.pairone.library.dto.publisher.Request.PublisherCreateRequest;
import com.pairone.library.dto.publisher.Request.PublisherUpdateRequest;
import com.pairone.library.dto.publisher.Response.PublisherResponse;
import com.pairone.library.entity.Publisher;
import com.pairone.library.mapper.PublisherMapper;
import com.pairone.library.repository.PublisherRepository;
import com.pairone.library.service.abstractservice.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository repository;
    private final PublisherMapper publisherMapper;

    public PublisherServiceImpl(PublisherRepository repository, PublisherMapper publisherMapper) {
        this.repository = repository;
        this.publisherMapper = publisherMapper.INSTANCE;
    }

    public PublisherResponse create(PublisherCreateRequest request) {
        Publisher publisher = publisherMapper.toEntity(request);
        publisher = repository.save(publisher);
        return publisherMapper.toResponse(publisher);
    }

    public PublisherResponse update(Integer id, PublisherUpdateRequest request) {
        Optional<Publisher> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Publisher existing = optional.get();
       existing= publisherMapper.updateEntity( request);
        return publisherMapper.toResponse(repository.save(existing));
    }

    public PublisherResponse getById(Integer id) {
        return repository.findById(id)
                .map(publisherMapper::toResponse)
                .orElse(null);
    }

    public List<PublisherResponse> getAll() {
        return repository.findAll().stream().map(publisherMapper::toResponse).toList();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Publisher bookServiceGetPublisher(Integer id) {
        return repository.findById(id).orElseThrow(null);
    }
}
