package com.pairone.library.service;

import com.pairone.library.dto.category.request.CategoryCreateRequestDto;
import com.pairone.library.dto.category.request.CategoryUpdateRequestDto;
import com.pairone.library.dto.category.response.CategoryDeleteResponseDto;
import com.pairone.library.dto.category.response.CategoryGetResponseDto;
import com.pairone.library.dto.category.response.CategoryUpdateResponseDto;
import com.pairone.library.entity.Category;
import com.pairone.library.mapper.CategoryMapper;
import com.pairone.library.repository.CategoryRepository;
import com.pairone.library.rules.CategoryBusinessRule;
import com.pairone.library.service.abstractservice.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final CategoryBusinessRule categoryBusinessRule;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper, CategoryBusinessRule categoryBusinessRule) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper.INSTANCE;
        this.categoryBusinessRule = categoryBusinessRule;
    }

    public CategoryGetResponseDto saveCategory(CategoryCreateRequestDto categoryCreateRequestDto) {
        categoryBusinessRule.getCategoryMustNotExistWithGivenName(categoryCreateRequestDto.getName());
        Category category = categoryMapper.categoryCreateRequestDtoMapToEntity(categoryCreateRequestDto);
        categoryRepository.save(category);
        return categoryMapper.entityMapToCategoryGetResponseDto(category);
    }

    public CategoryGetResponseDto categoryId(Integer id) {
        Category category = categoryBusinessRule.getCategoryMustExistWithGivenId(id);
        return categoryMapper.entityMapToCategoryGetResponseDto(category);
    }

    public CategoryUpdateResponseDto updateCategory(CategoryUpdateRequestDto categoryUpdateRequestDto) {
        categoryBusinessRule.getCategoryMustNotExistWithGivenName(categoryUpdateRequestDto.getName());
        Category category = categoryMapper.categoryUpdateRequestDtoMapToEntity(categoryUpdateRequestDto);
        categoryRepository.save(category);
        return categoryMapper.entityMapToCategoryUpdateResponseDto(category);
    }

    public CategoryDeleteResponseDto deleteCategory(Integer id) {
        Category category = categoryBusinessRule.getCategoryMustExistWithGivenId(id);
        categoryRepository.delete(category);
        return categoryMapper.entityMapToCategoryDeleteResponseDto(category);
    }

}
