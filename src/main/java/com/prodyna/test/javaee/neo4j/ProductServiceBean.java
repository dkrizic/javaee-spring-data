package com.prodyna.test.javaee.neo4j;


import com.prodyna.test.javaee.neo4j.domain.Product;
import com.prodyna.test.javaee.neo4j.repository.ProductRepository;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProductServiceBean implements ProductService {

    @Inject
    private Logger log;

    @Inject
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> findAllProducts() {
        log.info("Finding all");
        return productRepository.findAll();
    }

}
