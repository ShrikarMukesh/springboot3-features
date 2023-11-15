package com.springboot3.service;

import com.springboot3.client.ProductClient;
import com.springboot3.entity.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ProductService implements ProductClient {

    private final RestClient restClient;

    public ProductService(){
        restClient = RestClient.builder()
                .baseUrl("https://6554a6f963cafc694fe6c169.mockapi.io")
                .build();
    }

    @Override
    public void save(Product product) {

       restClient.post()
               .uri("/api/products")
               .contentType(MediaType.APPLICATION_JSON)
               .body(product)
               .retrieve()
               .toBodilessEntity();

    }

    @Override
    public Product update(int id, Product product) {
        return null;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return restClient.get()
                .uri("/api/products")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Product>>() {
                });
    }

    @Override
    public Product delete(int id) {
        return null;
    }
}
