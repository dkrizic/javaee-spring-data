package com.prodyna.test.javaee.neo4j.producer;

import com.prodyna.test.javaee.neo4j.repository.ProductRepository;
import org.neo4j.ogm.metadata.MetaData;
import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class ProductRepositoryProducer {

    @Inject
    private Logger log;

    @Inject
    private MetaData metadata;

    @Inject
    private Session session;

    @Autowired
    private ProductRepository productRepository;

    @Produces
    public ProductRepository produceProductRepository() throws Exception {
        log.info("Creating ProductRepository " + productRepository);
        return productRepository;
//        Neo4jMappingContext mappingContext = new Neo4jMappingContext(metadata);
//        mappingContext.afterPropertiesSet();
//        log.warn("Managed types " + mappingContext.getManagedTypes() );
//        GraphRepositoryFactory grf = new GraphRepositoryFactory(session, mappingContext);
//        return grf.getRepository(ProductRepository.class);
    }

}
