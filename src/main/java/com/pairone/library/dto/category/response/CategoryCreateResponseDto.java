package com.pairone.library.dto.category.response;

import jakarta.validation.constraints.NotNull;

public class CategoryCreateResponseDto {
    @NotNull
    private String id;

    public CategoryCreateResponseDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
