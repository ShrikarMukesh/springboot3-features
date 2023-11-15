package com.springboot3.controller;

import com.springboot3.entity.Product;
import com.springboot3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/api/products")
    public List<Product> findAll(){
        return productService.findAll();
    }
}
