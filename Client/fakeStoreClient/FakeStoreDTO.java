package org.phoenix13.productservice25.Client.fakeStoreClient;

import lombok.Getter;
import lombok.Setter;
import org.phoenix13.productservice25.dtos.ProductRequestDTO;
import org.phoenix13.productservice25.models.Category;
import org.phoenix13.productservice25.models.Product;
@Getter
@Setter
public class FakeStoreDTO {
    private long id;
    private String title;
    private String description;
    private String category;
    private String image;
    private double price;

    public Product toProduct(FakeStoreDTO fakeStoreDTO)
    {
        Product product = new Product();
        product.setId(fakeStoreDTO.getId());
        product.setName(fakeStoreDTO.getTitle());
        product.setDescription(fakeStoreDTO.getDescription());
        product.setPrice((int)fakeStoreDTO.getPrice());
        Category category = new Category();
        category.setName(fakeStoreDTO.getCategory());
        product.setCategory(category);
        product.setImageUrl(fakeStoreDTO.getImage());
        return product;
    }
}
