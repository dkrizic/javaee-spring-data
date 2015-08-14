package com.prodyna.test.javaee.neo4j.producer;

import com.prodyna.test.javaee.neo4j.ProductRepository;
import org.neo4j.ogm.metadata.MetaData;
import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.springframework.data.neo4j.mapping.Neo4jMappingContext;
import org.springframework.data.neo4j.repository.support.GraphRepositoryFactory;

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

    @Produces
    public ProductRepository produceProductRepository() throws Exception {
        log.info("Creating ProductRepository");
        Neo4jMappingContext mappingContext = new Neo4jMappingContext(metadata);
        mappingContext.afterPropertiesSet();
        log.warn("Managed types " + mappingContext.getManagedTypes() );
        GraphRepositoryFactory grf = new GraphRepositoryFactory(session, mappingContext);
        return grf.getRepository(ProductRepository.class);
    }

}
