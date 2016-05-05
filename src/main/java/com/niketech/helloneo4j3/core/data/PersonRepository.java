package com.niketech.helloneo4j3.core.data;

import com.niketech.helloneo4j3.domain.internal.Person;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;
import org.springframework.stereotype.Component;

@Component
public class PersonRepository {

    private final Driver driver;

    public PersonRepository() {
        driver = GraphDatabase.driver("bolt://internal.neo4j-us-west-2.niketech.com");
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
