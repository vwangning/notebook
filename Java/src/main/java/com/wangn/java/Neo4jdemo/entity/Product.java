package com.wangn.java.Neo4jdemo.entity;


import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;


@Data
@Node
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Relationship(type = "CONTAINS", direction = Relationship.Direction.OUTGOING)
    private List<Component> components;
}