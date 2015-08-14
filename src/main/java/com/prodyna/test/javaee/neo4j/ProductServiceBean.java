package com.prodyna.test.javaee.neo4j;


import org.slf4j.Logger;

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
        return productRepository.findAll() ;
    }

}
