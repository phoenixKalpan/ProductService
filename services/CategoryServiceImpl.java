package org.phoenix13.productservice25.services;

import org.phoenix13.productservice25.models.Category;
import org.phoenix13.productservice25.repositories.CategoryRepostiory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepostiory categoryRepostiory;

    public CategoryServiceImpl(CategoryRepostiory categoryRepostiory) {
        this.categoryRepostiory = categoryRepostiory;
    }
    @Override
    public List<Category> getAllCategories() {
        return categoryRepostiory.findAll();
    }

    @Override
    public Category getCategorybyId(long id) {
        return categoryRepostiory.findById(id).get();
    }
}
