package com.pairone.library.rules;

import com.pairone.library.core.exception.type.BusinessException;
import com.pairone.library.entity.Category;
import com.pairone.library.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryBusinessRule {
    private final CategoryRepository categoryRepository;

    public CategoryBusinessRule(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryMustExistWithGivenId(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("data not found"));
    }

    public Category getCategoryMustNotExistWithGivenName(String name) {
        Category entity = categoryRepository.findByIgnoreCaseName(name).orElseThrow(null);
        if (entity != null) {
            throw new BusinessException("cannot be added because data exists");
        }
        return entity;
    }
    public void getCategoryMustNotExistWithGivenId(Integer id) {
        Category entity = categoryRepository.findById(id).orElseThrow(null);
        if (entity != null) {
            throw new BusinessException("cannot be added because data exists");
        }
    }
}
