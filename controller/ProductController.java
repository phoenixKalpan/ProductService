package org.phoenix13.productservice25.controller;

import org.phoenix13.productservice25.dtos.ProductRequestDTO;
import org.phoenix13.productservice25.models.Product;
import org.phoenix13.productservice25.services.FakeStoreProductServiceImpl;
import org.phoenix13.productservice25.services.ProductService;
import org.phoenix13.productservice25.services.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    private FakeStoreProductServiceImpl fakeStoreProductService;
    private ProductServiceImpl productService;
    public ProductController(FakeStoreProductServiceImpl fakeStoreProductService, ProductServiceImpl productService) {
            this.fakeStoreProductService = fakeStoreProductService;
            this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts()
    {
        ResponseEntity<List<Product>> response = new ResponseEntity(
                //fakeStoreProductService.getProducts(),
                this.productService.getProducts(),
                HttpStatus.OK);

        return response;
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequestDTO productRequestDTO)
    {
        ResponseEntity<Product> response = new ResponseEntity(
                //fakeStoreProductService.createProduct(productRequestDTO),
                productService.createProduct(productRequestDTO),

                HttpStatus.OK);

        return response;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id)
    {
        ResponseEntity<Product> response = new ResponseEntity(
                //fakeStoreProductService.getProductById(id),
                this.productService.getProductById(id),
                HttpStatus.OK);

        return response;
    }
    @PutMapping("{id}")
    public Product updateProductById(@PathVariable("id") long id, @RequestBody Product product)
    {
        //return fakeStoreProductService.updateProductById(id,product);
        return this.productService.updateProductById(id, product);
    }
    @DeleteMapping("{id}")
    public boolean deleteProductById(@PathVariable("id") long id)
    {
    //    return fakeStoreProductService.deleteProductById(id);
            return this.productService.deleteProductById(id);
    }

}

