package com.wangn.java.Neo4jdemo.Repository;

import com.wangn.java.Neo4jdemo.entity.Product;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProductRepository extends Neo4jRepository<Product, Long> {
}
