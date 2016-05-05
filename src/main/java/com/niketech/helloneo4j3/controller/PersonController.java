package com.niketech.helloneo4j3.controller;

import com.niketech.helloneo4j3.domain.AddPersonRequest;
import com.niketech.helloneo4j3.domain.AddPersonResponse;
import com.niketech.helloneo4j3.domain.FindPersonResponse;
import com.niketech.helloneo4j3.domain.internal.Person;
import com.niketech.helloneo4j3.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 *
 */
@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     *
     * @param addPersonRequest
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AddPersonResponse> addPerson(@Valid @RequestBody AddPersonRequest addPersonRequest) {
        Person person = personService.addPerson(addPersonRequest.getName());

        AddPersonResponse body = new AddPersonResponse(person);

        return ResponseEntity.status(HttpStatus.CREATED)
                    .body(body);
    }

    /**
     *
     * @param name
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,
                    value = "/{name}",
                    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FindPersonResponse> findPerson(@RequestParam("name") String name) {
        Person person = personService.findPerson(name);

        FindPersonResponse body = new FindPersonResponse(person);

        return ResponseEntity.ok(body);
    }
}
