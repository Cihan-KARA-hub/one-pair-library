package com.pairone.library.dto.category.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategoryDeleteResponseDto {
    @NotNull
    private Integer id;
    @NotBlank
    private String name;

    public CategoryDeleteResponseDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
