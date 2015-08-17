package com.prodyna.test.javaee.neo4j.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.neo4j.ogm.metadata.MetaData;
import org.neo4j.ogm.session.Neo4jSession;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * Created by dkrizic on 14.08.15.
 */
public class SessionProducer {

    @Produces
    public Session produce() {
        SessionFactory sessionFactory = new SessionFactory("com.prodyna.test.javaee");
        Session session = sessionFactory.openSession("http://localhost:7474/");
        return session;
    }

}
