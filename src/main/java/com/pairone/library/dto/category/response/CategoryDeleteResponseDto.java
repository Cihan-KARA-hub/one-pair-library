package com.pairone.library.dto.category.response;

public class CategoryDeleteResponseDto {
    private Integer id;
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
