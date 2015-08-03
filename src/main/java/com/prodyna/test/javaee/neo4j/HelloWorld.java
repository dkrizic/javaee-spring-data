package com.prodyna.test.javaee.neo4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class HelloWorld {

    private Logger log = LoggerFactory.getLogger( getClass() );

    @PostConstruct
    public void start() {
        log.info("Started");
    }

    @PreDestroy
    public void stop() {
        log.info("Stopping");
    }

    public void hello() {
        log.info("Hello");
    }

}
