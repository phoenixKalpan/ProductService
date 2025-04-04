package org.phoenix13.productservice25.controller;

import org.phoenix13.productservice25.models.Category;
import org.phoenix13.productservice25.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/categories")
    public List<Category> getAllCategories()
    {

        return categoryService.getAllCategories();
    }
    @GetMapping("/categories/{id}")
    public Category getCategorybyId(@PathVariable("id") long id)
    {
        return categoryService.getCategorybyId(id);
    }


}
