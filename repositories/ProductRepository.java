package org.phoenix13.productservice25.repositories;

import org.phoenix13.productservice25.models.Category;
import org.phoenix13.productservice25.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product save(Product product);

    public Product findById(long id);
    public List<Product> findAll();
    public void deleteById(long id);

    public Product findProductByCategory(Category category);
}
