package com.prodyna.test.javaee.neo4j.producer.spring;


import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.prodyna.test.javaee.neo4j.repository")
@EnableTransactionManagement
public class Application extends Neo4jConfiguration {

    public static final int NEO4J_PORT = 7474;

    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("com.prodyna.test.javaee.neo4j.domain");
    }

    @Bean
    public Neo4jServer neo4jServer() {
        return new RemoteServer("http://localhost:" + NEO4J_PORT);
    }

    @Override
    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Session getSession() throws Exception {
        return super.getSession();
    }
}