package com.pairone.library.dto.category.request;

public class CategoryUpdateRequestDto {
    private Integer id;
    private String name;

    public CategoryUpdateRequestDto() {
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
