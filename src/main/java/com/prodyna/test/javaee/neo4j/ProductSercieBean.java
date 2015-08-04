package com.prodyna.test.javaee.neo4j;

import javax.inject.Inject;
import java.util.List;

public class ProductSercieBean implements ProductService {

    @Inject private ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return null;
    }
}
