package com.prodyna.test.javaee.neo4j;


import com.prodyna.test.javaee.neo4j.domain.Product;

import javax.ejb.Local;

@Local
public interface ProductService {

    Iterable<Product> findAllProducts();

}
