package com.prodyna.test.javaee.neo4j.repository;

import com.prodyna.test.javaee.neo4j.domain.Product;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends GraphRepository<Product> {

}
