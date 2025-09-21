package com.pairone.library.rules;

import com.pairone.library.core.exception.type.BusinessException;
import com.pairone.library.entity.Publisher;
import com.pairone.library.repository.PublisherRepository;
import org.springframework.stereotype.Component;

@Component
public class PublisherBusinessRule {
    private final PublisherRepository publisherRepository;

    public PublisherBusinessRule(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher bookServiceGetPublisher(Integer id) {
        return publisherRepository.findById(id).orElseThrow(()-> new BusinessException(null));
    }
}
