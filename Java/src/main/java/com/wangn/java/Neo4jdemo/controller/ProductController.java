package com.wangn.java.Neo4jdemo.controller;


import com.wangn.java.Neo4jdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/create")
    public String create() {
        productService.createProductWithComponents();
        return "Product and components created";
    }
}