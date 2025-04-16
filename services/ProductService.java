package org.phoenix13.productservice25.services;



import org.phoenix13.productservice25.dtos.ProductRequestDTO;
import org.phoenix13.productservice25.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService
{
    public Product createProduct(ProductRequestDTO productRequestDTO);
    public Product getProductById(Long id);
    public Product updateProductById(long id,Product product);
    public List<Product> getProducts();
    public boolean deleteProductById(long id);
    public Product replaceProductById(long id, Product product);
    public List<Page<Product>> findAllProducts(Pageable pageable);
}
