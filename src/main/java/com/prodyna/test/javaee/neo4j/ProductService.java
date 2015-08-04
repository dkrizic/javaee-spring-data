package com.prodyna.test.javaee.neo4j;


import javax.ejb.Stateless;
import java.util.List;

@Stateless
public interface ProductService {

    public List<Product> findAllProducts();

}
