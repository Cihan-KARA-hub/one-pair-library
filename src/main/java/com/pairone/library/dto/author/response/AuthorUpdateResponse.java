package com.pairone.library.dto.author.response;

import jakarta.validation.constraints.NotNull;

public class AuthorUpdateResponse {
    @NotNull
    private Integer id;

    public Integer getAuthorId() {
        return id;
    }

    public void setAuthorId(Integer authorId) {
        this.id = authorId;
    }
}
