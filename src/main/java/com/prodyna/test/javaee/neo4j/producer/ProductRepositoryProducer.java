package com.prodyna.test.javaee.neo4j.producer;

import com.prodyna.test.javaee.neo4j.Product;
import com.prodyna.test.javaee.neo4j.ProductRepository;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.neo4j.repository.GraphRepositoryFactory;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.data.neo4j.support.mapping.Neo4jMappingContext;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductRepositoryProducer {

    @Inject
    private GraphDatabase graphDatabase;

    @Inject
    private Neo4jMappingContext mappingContext;

    @Produces
    public ProductRepository produce() {
        // Set<Class> entities = new HashSet<Class>();
        // entities.add(Product.class);
        // mappingContext.setInitialEntitySet( entities );
        return new GraphRepositoryFactory(new Neo4jTemplate(graphDatabase), mappingContext).getRepository(ProductRepository.class);
    }

}
