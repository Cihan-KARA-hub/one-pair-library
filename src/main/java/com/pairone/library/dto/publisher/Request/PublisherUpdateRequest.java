package com.pairone.library.dto.publisher.Request;

public class PublisherUpdateRequest {
    private String name;

    public PublisherUpdateRequest() {}

    public PublisherUpdateRequest(String name) {
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
        return "PublisherUpdateRequest{name='" + name + "'}";
    }
}
