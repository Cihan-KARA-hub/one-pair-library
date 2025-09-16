package com.pairone.library.dto.category.request;

import jakarta.validation.constraints.NotBlank;

public class CategoryCreateRequestDto {
    @NotBlank
    private String name;

    public CategoryCreateRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
