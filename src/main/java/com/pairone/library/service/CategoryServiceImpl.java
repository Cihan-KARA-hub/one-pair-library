package com.pairone.library.service;

import com.pairone.library.entity.Category;
import com.pairone.library.repository.CategoryRepository;
import com.pairone.library.service.abstractservice.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryId(Integer id) {
        return  categoryRepository.findById(id).orElseThrow();
    }

}
