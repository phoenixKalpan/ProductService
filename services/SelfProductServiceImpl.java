package org.phoenix13.productservice25.services;

import org.phoenix13.productservice25.dtos.ProductRequestDTO;
import org.phoenix13.productservice25.models.Product;
//import org.phoenix13.productservice25.ES.ProductESRepositories;
import org.phoenix13.productservice25.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "SelfProductService")
@Primary
public class SelfProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    //private ProductESRepositories productESRepositories;
    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        //this.productESRepositories = productESRepositories;
    }
    @Override
    public Product createProduct(ProductRequestDTO productRequestDTO) {
        return productRepository.save(productRequestDTO.toProduct(productRequestDTO));
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProductById(long id, Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {


        return productRepository.findAll();
    }

    @Override
    public boolean deleteProductById(long id) {
        productRepository.deleteById(id);
        return false;
    }

    @Override
    public Product replaceProductById(long id, Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Page<Product>> findAllProducts(Pageable pageable) {
        return null;
    }
}
