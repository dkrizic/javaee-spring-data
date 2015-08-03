package com.prodyna.test.javaee.neo4j;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.jboss.shrinkwrap.api.ShrinkWrap.*;

@RunWith(Arquillian.class)
public class HelloWorldTest {

    @Deployment
    public static WebArchive deployment() {
        WebArchive war = create(WebArchive.class, "hello.war");
        war.addPackages( true, "com.prodyna.test.javaee.neo4j");
        war.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        return war;
    }

    @Inject private HelloWorld hello;

    @Test
    public void dummy() {
        hello.hello();
    }

}