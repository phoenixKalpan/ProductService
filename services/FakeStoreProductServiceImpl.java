package org.phoenix13.productservice25.services;

import io.micrometer.common.lang.Nullable;
import org.phoenix13.productservice25.Client.fakeStoreClient.FakeStoreClient;
import org.phoenix13.productservice25.Client.fakeStoreClient.FakeStoreDTO;
import org.phoenix13.productservice25.dtos.ProductRequestDTO;
import org.phoenix13.productservice25.models.Category;
import org.phoenix13.productservice25.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreClient fakeStoreClient;
    private RedisTemplate<String, Object> redisTemplate;
    // String -> Data Type of Key
    // Object -> Data Type of Value

    public FakeStoreProductServiceImpl(FakeStoreClient fakeStoreClient, RedisTemplate<String, Object> redisTemplate) {
        //this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreClient = fakeStoreClient;
        this.redisTemplate = redisTemplate;
    }
    @Override
    public Product createProduct(ProductRequestDTO productRequestDTO) {

        ProductRequestDTO fakeStoreDTO = fakeStoreClient.createProduct(productRequestDTO);

        return fakeStoreDTO.toProduct(fakeStoreDTO);
    }

    @Override
    public Product getProductById(Long id) {
        ProductRequestDTO productRequestDTO;
        productRequestDTO=(ProductRequestDTO) redisTemplate.opsForHash().get("PRODUCTS", id);

        if (productRequestDTO != null) {
            System.out.println("Fetched from Cache");
            return productRequestDTO.toProduct(productRequestDTO);
        }
        System.out.println("Fetched from API");
        productRequestDTO = fakeStoreClient.getProductById(id);
        redisTemplate.opsForHash().put("PRODUCTS", id, productRequestDTO);
        return productRequestDTO.toProduct(productRequestDTO);
    }




    @Override
    public List<Product> getProducts() {


        List<ProductRequestDTO> products = fakeStoreClient.getProducts();
        List<Product> productList = new ArrayList<>();

        for(int i = 0; i<products.size(); i++)
        {

            productList.add(products.get(i).toProduct(products.get(i)));

        }
        return productList;
    }

    @Override
    public Product updateProductById(long id,Product product) {
        FakeStoreDTO fakeStoreDTO = new FakeStoreDTO();
        fakeStoreDTO.setId(product.getId());
        fakeStoreDTO.setCategory(product.getCategory().getName());
        fakeStoreDTO.setDescription(product.getDescription());
        fakeStoreDTO.setPrice(product.getPrice());
        fakeStoreDTO.setTitle(product.getName());
        fakeStoreDTO.setImage(product.getImageUrl());
        return fakeStoreClient.updateProductById(id,fakeStoreDTO);
    }
    @Override
    public Product replaceProductById(long id, Product product) {
        FakeStoreDTO fakeStoreDTO = new FakeStoreDTO();
        fakeStoreDTO.setId(product.getId());
        fakeStoreDTO.setCategory(product.getCategory().getName());
        fakeStoreDTO.setDescription(product.getDescription());
        fakeStoreDTO.setPrice(product.getPrice());
        fakeStoreDTO.setTitle(product.getName());
        fakeStoreDTO.setImage(product.getImageUrl());
        return fakeStoreClient.updateProductById(id,fakeStoreDTO);
    }

    @Override
    public List<Page<Product>> findAllProducts(Pageable pageable) {
        return List.of();
    }

    @Override
    public boolean deleteProductById(long id) {
        return false;
    }



}

