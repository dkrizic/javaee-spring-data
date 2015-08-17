package com.prodyna.test.javaee.neo4j;

import com.prodyna.test.javaee.neo4j.domain.Product;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.jboss.shrinkwrap.api.ShrinkWrap.*;

@RunWith(Arquillian.class)
public class ProductServiceTest {

    @Deployment
    public static WebArchive deployment() {
        WebArchive war = create(WebArchive.class, "hello.war");
        war.addPackages(true, "com.prodyna.test.javaee");
        war.addAsWebInfResource("META-INF/beans.xml", "classes/META-INF/beans.xml");
        war.addAsWebInfResource("META-INF/web.xml", "web.xml");
        war.addAsWebInfResource("META-INF/applicationContext.xml", "applicationContext.xml");
        war.addAsLibraries(Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve().withTransitivity().asFile());
        System.out.println(war.toString(true));
        return war;
    }

    @Inject
    private ProductService productService;

    @Test
    public void readAllProducts() {
        Assert.assertNotNull( productService );
        for (Product product : productService.findAllProducts()) {
            System.out.println(product);
        }
    }

}
