package org.phoenix13.productservice25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ProductService25Application {

    public static void main(String[] args) {
        SpringApplication.run(ProductService25Application.class, args);
    }

}
