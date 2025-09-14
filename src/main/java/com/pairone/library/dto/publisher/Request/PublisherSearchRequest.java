package com.pairone.library.dto.publisher.Request;

public class PublisherSearchRequest {
    private String name;
    private Long id;
    public PublisherSearchRequest() {

    }
    public PublisherSearchRequest(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
