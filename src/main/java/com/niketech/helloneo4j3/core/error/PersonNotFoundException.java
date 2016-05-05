package com.niketech.helloneo4j3.core.error;

import com.niketech.blueprint.springboot.core.error.BlueprintRuntimeException;
import org.springframework.http.HttpStatus;

public class PersonNotFoundException extends BlueprintRuntimeException {

    public PersonNotFoundException(String name) {
        super(HttpStatus.NOT_FOUND, String.format("The person, %s, does not exist.", name));
    }
}
