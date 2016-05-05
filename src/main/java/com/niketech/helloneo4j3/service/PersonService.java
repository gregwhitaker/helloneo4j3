package com.niketech.helloneo4j3.service;

import com.niketech.helloneo4j3.core.data.PersonRepository;
import com.niketech.helloneo4j3.core.error.PersonNotFoundException;
import com.niketech.helloneo4j3.domain.internal.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class PersonService {

    @Autowired
    private PersonRepository repo;

    /**
     *
     * @param name
     * @return
     */
    public Person addPerson(String name) {
        Person newPerson = new Person(name);
        repo.add(newPerson);

        return newPerson;
    }

    /**
     *
     * @param name
     * @return
     */
    public Person findPerson(String name) {
        Person person = repo.find(name);

        if (person == null) {
            throw new PersonNotFoundException(name);
        }

        return person;
    }
}
