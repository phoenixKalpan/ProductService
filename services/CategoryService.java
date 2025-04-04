package org.phoenix13.productservice25.services;

import org.phoenix13.productservice25.models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories();
    public Category getCategorybyId(long id);
}
