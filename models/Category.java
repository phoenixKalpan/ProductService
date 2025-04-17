package org.phoenix13.productservice25.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel implements Serializable {
    private String name;
    private String description;
    @OneToMany(mappedBy = "category",cascade = {CascadeType.REMOVE})
    private List<Product> products;
}

