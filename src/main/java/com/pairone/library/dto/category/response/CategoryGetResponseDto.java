package com.pairone.library.dto.category.response;

import jakarta.validation.constraints.NotBlank;

public class CategoryGetResponseDto {
    @NotBlank
    private String name;

    public CategoryGetResponseDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
