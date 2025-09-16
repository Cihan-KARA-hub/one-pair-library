package com.pairone.library.dto.author.response;

import jakarta.validation.constraints.NotNull;

public class AuthorUpdateResponse {
    @NotNull
    private Integer authorId;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
}
