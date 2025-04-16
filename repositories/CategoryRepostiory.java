package org.phoenix13.productservice25.repositories;

import org.phoenix13.productservice25.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepostiory extends JpaRepository<Category,Long> {

    public Category findByName(String name);
    public List<Category> findAll();
}
