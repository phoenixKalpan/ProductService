package org.phoenix13.productservice25.services;

import io.micrometer.common.lang.Nullable;
import org.phoenix13.productservice25.Client.fakeStoreClient.FakeStoreClient;
import org.phoenix13.productservice25.Client.fakeStoreClient.FakeStoreDTO;
import org.phoenix13.productservice25.dtos.ProductRequestDTO;
import org.phoenix13.productservice25.models.Category;
import org.phoenix13.productservice25.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
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
    public FakeStoreProductServiceImpl(FakeStoreClient fakeStoreClient) {
        //this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreClient = fakeStoreClient;
    }
    @Override
    public Product createProduct(ProductRequestDTO productRequestDTO) {

        ProductRequestDTO fakeStoreDTO = fakeStoreClient.createProduct(productRequestDTO);

        return fakeStoreDTO.toProduct(fakeStoreDTO);
    }

    @Override
    public Product getProductById(Long id) {

        ProductRequestDTO productRequestDTO = fakeStoreClient.getProductById(id);

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
    public boolean deleteProductById(long id) {
        return false;
    }



}

