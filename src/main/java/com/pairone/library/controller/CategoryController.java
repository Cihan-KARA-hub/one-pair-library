package com.pairone.library.controller;

import com.pairone.library.dto.category.request.CategoryCreateRequestDto;
import com.pairone.library.dto.category.request.CategoryUpdateRequestDto;
import com.pairone.library.dto.category.response.CategoryDeleteResponseDto;
import com.pairone.library.dto.category.response.CategoryGetResponseDto;
import com.pairone.library.dto.category.response.CategoryUpdateResponseDto;
import com.pairone.library.service.abstractservice.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryGetResponseDto save(@RequestBody CategoryCreateRequestDto dto) {
        return categoryService.saveCategory(dto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryUpdateResponseDto update(@RequestBody CategoryUpdateRequestDto dto) {
        return categoryService.updateCategory(dto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryGetResponseDto get(@PathVariable Integer id) {
        return categoryService.categoryId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDeleteResponseDto delete(@PathVariable Integer id) {
        return categoryService.deleteCategory(id);
    }
}
