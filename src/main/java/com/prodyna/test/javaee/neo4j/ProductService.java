package com.prodyna.test.javaee.neo4j;


import org.springframework.data.neo4j.conversion.Result;

import javax.ejb.Local;

@Local
public interface ProductService {

    public Result<Product> findAllProducts();

}
