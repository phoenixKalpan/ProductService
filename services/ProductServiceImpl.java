package org.phoenix13.productservice25.services;

import org.phoenix13.productservice25.dtos.ProductRequestDTO;
import org.phoenix13.productservice25.models.Product;
import org.phoenix13.productservice25.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product createProduct(ProductRequestDTO productRequestDTO) {
        return productRepository.save(productRequestDTO.toProduct(productRequestDTO));
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Product updateProductById(long id, Product product) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public boolean deleteProductById(long id) {
        return false;
    }

    @Override
    public Product replaceProductById(long id, Product product) {
        return null;
    }
}
