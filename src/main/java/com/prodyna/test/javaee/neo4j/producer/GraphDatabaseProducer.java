package com.prodyna.test.javaee.neo4j.producer;

import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase;

import javax.enterprise.inject.Produces;

public class GraphDatabaseProducer {

    @Produces
    public GraphDatabase produce() {
        return new SpringCypherRestGraphDatabase("http://localhost:7474/db/data", "neo4j", "secret");
    }

}
