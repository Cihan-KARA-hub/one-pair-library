package com.pairone.library.dto.publisher.Response;

public class PublisherResponse {
    private int publisherId;
    private String name;
    public PublisherResponse() {}
    public PublisherResponse(int publisherId, String name) {
        this.publisherId = publisherId;
        this.name = name;
    }
    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return "PublisherResponse [publisherId=" + publisherId + ", name=" + name + "]";
    }

}
