package com.wangn.java.Neo4jdemo.Repository;

import com.wangn.java.Neo4jdemo.entity.Component;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ComponentRepository extends Neo4jRepository<Component, Long> {
}
