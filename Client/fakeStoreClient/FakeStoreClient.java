package org.phoenix13.productservice25.Client.fakeStoreClient;

import io.micrometer.common.lang.Nullable;
import org.phoenix13.productservice25.dtos.ProductRequestDTO;
import org.phoenix13.productservice25.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                   Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();

        RequestCallback requestCallback =restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
    public ProductRequestDTO createProduct(ProductRequestDTO fakeStoreDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductRequestDTO> repsonse =  restTemplate.postForEntity("https://fakestoreapi.com/products", fakeStoreDTO, ProductRequestDTO.class);
        ProductRequestDTO newproductRequestDTO = repsonse.getBody();
        //ProductRequestDTO productRequestDTO = repsonse.getBody();
        return newproductRequestDTO;

    }


    public ProductRequestDTO getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductRequestDTO> repsonse =  restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                ProductRequestDTO.class, id);
        ProductRequestDTO productRequestDTO = repsonse.getBody();

        return productRequestDTO;
    }


    public Product updateProductById(long id,FakeStoreDTO fakeStoreDTO) {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();

        ResponseEntity<FakeStoreDTO> fakeStoreProductDtoResponseEntity = requestForEntity(
                HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                fakeStoreDTO,
                FakeStoreDTO.class,
                id
        );

//        if (fakeStoreProductDtoResponseEntity.getHeaders())


        FakeStoreDTO fakeStoreProductDtoResponse = restTemplate.patchForObject(
                "https://fakestoreapi.com/products/{id}",
                fakeStoreDTO,
                FakeStoreDTO.class,
                id
        );
        return fakeStoreProductDtoResponse.toProduct(fakeStoreProductDtoResponse);
    }

    public List<ProductRequestDTO> getProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductRequestDTO[]> repsonse =  restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                ProductRequestDTO[].class);
        ProductRequestDTO productRequestDTO[] = repsonse.getBody();
        List<ProductRequestDTO> products = new ArrayList<>();
        //List<Product> productList = new ArrayList<>();
        for(int i = 0; i<productRequestDTO.length; i++)
        {
            products.add(productRequestDTO[i]);
        }

        return products;
    }

}
