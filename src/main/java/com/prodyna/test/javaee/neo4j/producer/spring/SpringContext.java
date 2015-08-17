package com.prodyna.test.javaee.neo4j.producer.spring;

import javax.inject.Qualifier;
import java.lang.annotation.*;

@Qualifier
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface SpringContext {

    String name() default "default";

}
