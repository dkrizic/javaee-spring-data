package com.prodyna.test.javaee.neo4j;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.jboss.shrinkwrap.api.ShrinkWrap.*;

@RunWith(Arquillian.class)
public class ProductServiceTest {

    @Deployment
    public static WebArchive deployment() {
        WebArchive war = create(WebArchive.class, "hello.war");
        war.addPackages(true, "com.prodyna.test.javaee.neo4j");
        war.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        war.addAsLibraries(Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve().withTransitivity().asFile());
        System.out.println(war.toString(true));
        return war;
    }

    @Inject
    private HelloWorld hello;

    @Test
    public void dummy() {
        hello.hello();
    }

}
