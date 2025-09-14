package com.pairone.library.dto.publisher.Response;
import java.util.List;
public class PublisherListResponse {
    private List<PublisherResponse> publishers;

    public PublisherListResponse() {}

    public PublisherListResponse(List<PublisherResponse> publishers) {
        this.publishers = publishers;
    }

    public List<PublisherResponse> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<PublisherResponse> publishers) {
        this.publishers = publishers;
    }
}
