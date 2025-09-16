package com.pairone.library.mapper;

import com.pairone.library.dto.category.request.CategoryCreateRequestDto;
import com.pairone.library.dto.category.request.CategoryUpdateRequestDto;
import com.pairone.library.dto.category.response.CategoryCreateResponseDto;
import com.pairone.library.dto.category.response.CategoryDeleteResponseDto;
import com.pairone.library.dto.category.response.CategoryGetResponseDto;
import com.pairone.library.dto.category.response.CategoryUpdateResponseDto;
import com.pairone.library.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category categoryCreateRequestDtoMapToEntity(CategoryCreateRequestDto category);
    CategoryCreateResponseDto entityToCategoryCreateResponseDto(Category category);

    Category categoryUpdateRequestDtoMapToEntity(CategoryUpdateRequestDto category);

    CategoryGetResponseDto entityMapToCategoryGetResponseDto(Category category);

    CategoryUpdateResponseDto entityMapToCategoryUpdateResponseDto(Category category);

    CategoryDeleteResponseDto entityMapToCategoryDeleteResponseDto(Category category);
}
