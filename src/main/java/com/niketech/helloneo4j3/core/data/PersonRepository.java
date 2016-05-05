package com.niketech.helloneo4j3.core.data;

import com.niketech.helloneo4j3.domain.internal.Person;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.springframework.stereotype.Component;

@Component
public class PersonRepository {

    private final Driver driver;

    public PersonRepository() {
        driver = GraphDatabase.driver("bolt://internal.neo4j-us-west-2.niketech.com");
    }

    public void add(Person person) {

    }

    public Person find(String name) {
        return null;
    }
}
