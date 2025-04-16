package org.phoenix13.productservice25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Entity
@Document(indexName = "Product")
public class Product extends BaseModel {
    private String name;
    private String description;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Category category;
    private String imageUrl;
    private int price;
}
