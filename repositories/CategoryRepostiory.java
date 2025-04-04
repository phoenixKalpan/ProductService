package org.phoenix13.productservice25.repositories;

import org.phoenix13.productservice25.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepostiory extends JpaRepository<Category,Long> {

    public Category findByName(String name);
    public List<Category> findAll();
}
