package com.niketech.helloneo4j3.core.data;

import com.niketech.helloneo4j3.domain.internal.Person;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PersonRepository {

    @Value("${neo4j.hostname}")
    private String hostname;

    private Driver driver;

    @PostConstruct
    private void init() {
        driver = GraphDatabase.driver("bolt://" + hostname);
    }

    /**
     *
     * @param person
     */
    public void add(Person person) {
        Session session = driver.session();

        try {
            session.run("CREATE (p:Person {name: {name}})", Values.parameters("name", person.getName()));
        } finally {
            session.close();
        }
    }

    /**
     *
     * @param name
     * @return
     */
    public Person find(String name) {
        Session session = driver.session();

        try {
            StatementResult result = session.run("MATCH (p:Person) WHERE p.name = {name} RETURN p.name",
                    Values.parameters("name", Values.parameters("name", name)));

            while (result.hasNext()) {
                Record record = result.next();
                return new Person(record.get("name").toString());
            }

            return null;
        } finally {
            session.close();
        }
    }
}
