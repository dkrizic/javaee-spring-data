package com.prodyna.test.javaee.neo4j;


import javax.ejb.Local;

@Local
public interface ProductService {

    Iterable<Product> findAllProducts();

}
