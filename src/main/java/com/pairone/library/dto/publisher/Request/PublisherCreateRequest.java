package com.pairone.library.dto.publisher.Request;

public class PublisherCreateRequest {
    private String name;

    public PublisherCreateRequest() {}

    public PublisherCreateRequest(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PublisherCreateRequest{name='" + name + "'}";
    }
}
