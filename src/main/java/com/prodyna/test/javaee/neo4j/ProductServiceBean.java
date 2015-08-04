package com.prodyna.test.javaee.neo4j;

import org.springframework.data.neo4j.conversion.Result;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProductServiceBean implements ProductService {

    @Inject
    private ProductRepository productRepository;

    @Override
    public Result<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
