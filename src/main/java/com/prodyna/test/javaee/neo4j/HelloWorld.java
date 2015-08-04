package com.prodyna.test.javaee.neo4j;

import org.neo4j.graphdb.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.neo4j.rest.SpringCypherRestGraphDatabase;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class HelloWorld {

    private Logger log = LoggerFactory.getLogger(getClass());
    private SpringCypherRestGraphDatabase graphDatabase;

    @PostConstruct
    public void start() {
        log.info("Started");
        graphDatabase = new SpringCypherRestGraphDatabase("http://localhost:7474/db/data", "neo4j", "secret");
    }

    @PreDestroy
    public void stop() {
        log.info("Stopping");
        graphDatabase = null;
    }

    public void hello() {
        log.info("Hello");
        for (Node node : graphDatabase.getAllNodes()) {
            log.info("Node " + node);
        }
    }

}
