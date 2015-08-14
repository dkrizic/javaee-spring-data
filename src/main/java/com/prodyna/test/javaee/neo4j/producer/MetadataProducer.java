package com.prodyna.test.javaee.neo4j.producer;

import org.neo4j.ogm.metadata.MetaData;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class MetadataProducer {

    @Produces
    public MetaData produce() {
        MetaData metadata = new MetaData("com.prodyna.test.javaee.neo4j");
        return metadata;
    }


}
