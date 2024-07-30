package com.wangn.java.Neo4jdemo.service;


import com.wangn.java.Neo4jdemo.Repository.ComponentRepository;
import com.wangn.java.Neo4jdemo.Repository.ProductRepository;
import com.wangn.java.Neo4jdemo.entity.Component;
import com.wangn.java.Neo4jdemo.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;

@Service
public class ProductService {
    @Resource
    private ProductRepository productRepository;

    @Resource
    private ComponentRepository componentRepository;

    @Transactional
    public void createProductWithComponents() {
        Component component1 = new Component();
        component1.setName("Component 1");

        Component component2 = new Component();
        component2.setName("Component 2");

        componentRepository.saveAll(Arrays.asList(component1, component2));

        Product product = new Product();
        product.setName("Product 1");
        product.setComponents(Arrays.asList(component1, component2));

        productRepository.save(product);
    }
}