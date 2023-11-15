package com.springboot3.client;

import com.springboot3.entity.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

public interface ProductClient {
    @PostExchange("/api/products")
    void save(@RequestBody Product product);

    @PutExchange("/api/products/{id}")
    Product update(@PathVariable int id, @RequestBody Product product);

    @GetExchange("/api/products/{id}")
    Product findById(@PathVariable int id);

    @GetExchange("/api/products")
    List<Product> findAll();

    @DeleteExchange("/api/products/{id}")
    Product delete(@PathVariable int id);
}
