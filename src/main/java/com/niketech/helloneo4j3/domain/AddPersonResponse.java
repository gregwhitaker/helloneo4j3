package com.niketech.helloneo4j3.domain;

import com.niketech.helloneo4j3.domain.internal.Person;
import org.springframework.hateoas.ResourceSupport;

public class AddPersonResponse extends ResourceSupport {

    private String name;

    public AddPersonResponse(Person person) {
        this.name = person.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
