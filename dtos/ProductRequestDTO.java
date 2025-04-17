package org.phoenix13.productservice25.dtos;

import lombok.Getter;
import lombok.Setter;
import org.phoenix13.productservice25.models.Category;
import org.phoenix13.productservice25.models.Product;

import java.io.Serializable;

@Getter
@Setter
public class ProductRequestDTO implements Serializable {
    private long id;
    private String title;
    private String description;
    private String category;
    private String image;
    private double price;

    public Product toProduct(ProductRequestDTO productRequestDTO)
    {
        Product product = new Product();
        product.setId(productRequestDTO.getId());
        product.setName(productRequestDTO.getTitle());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice((int)productRequestDTO.getPrice());
        Category category = new Category();
        category.setName(productRequestDTO.getCategory());
        product.setCategory(category);
        product.setImageUrl(productRequestDTO.getImage());
        return product;
    }
}
