package com.pairone.library.controller;

import com.pairone.library.dto.publisher.Request.PublisherCreateRequest;
import com.pairone.library.dto.publisher.Request.PublisherUpdateRequest;
import com.pairone.library.dto.publisher.Response.PublisherResponse;
import com.pairone.library.service.PublisherServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publishers")
public class PublisherController {

    private final PublisherServiceImpl publisherServiceImpl;

    public PublisherController(PublisherServiceImpl publisherServiceImpl) {
        this.publisherServiceImpl = publisherServiceImpl;
    }


    @PostMapping
    public ResponseEntity<PublisherResponse> createPublisher(@RequestBody PublisherCreateRequest request) {
        PublisherResponse response = publisherServiceImpl.create(request);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PublisherResponse> updatePublisher(
            @PathVariable Integer id,
            @RequestBody PublisherUpdateRequest request) {
        PublisherResponse response = publisherServiceImpl.update(id, request);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponse> getPublisherById(@PathVariable Integer id) {
        PublisherResponse response = publisherServiceImpl.getById(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PublisherResponse>> getAllPublishers() {
        List<PublisherResponse> publishers = publisherServiceImpl.getAll();
        return ResponseEntity.ok(publishers);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Integer id) {
        publisherServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}
