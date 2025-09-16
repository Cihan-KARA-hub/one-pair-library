package com.pairone.library.dto.category.response;

import jakarta.validation.constraints.NotNull;

public class CategoryUpdateResponseDto {
    @NotNull
    private String id;

    public CategoryUpdateResponseDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
