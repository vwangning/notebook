package com.wangn.java.Neo4jdemo.entity;


import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
public class Component {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

}