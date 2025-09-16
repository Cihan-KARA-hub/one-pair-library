package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.category.request.CategoryCreateRequestDto;
import com.pairone.library.dto.category.request.CategoryUpdateRequestDto;
import com.pairone.library.dto.category.response.CategoryCreateResponseDto;
import com.pairone.library.dto.category.response.CategoryDeleteResponseDto;
import com.pairone.library.dto.category.response.CategoryGetResponseDto;
import com.pairone.library.dto.category.response.CategoryUpdateResponseDto;
import com.pairone.library.entity.Category;

public interface CategoryService {
    CategoryGetResponseDto categoryId(Integer id);
    CategoryCreateResponseDto saveCategory(CategoryCreateRequestDto categoryCreateRequestDto);
    CategoryUpdateResponseDto updateCategory(CategoryUpdateRequestDto categoryUpdateRequestDto);
    CategoryDeleteResponseDto deleteCategory(Integer id);
}
