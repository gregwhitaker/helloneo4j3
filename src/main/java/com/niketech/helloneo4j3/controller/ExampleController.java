package com.niketech.helloneo4j3.controller;

import com.niketech.helloneo4j3.domain.ExampleMessage;
import com.niketech.helloneo4j3.domain.ExampleRecipient;
import com.niketech.helloneo4j3.service.ExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.dropwizard.DropwizardMetricServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.schedulers.Schedulers;

import javax.validation.Valid;

/**
 * Example controller responsible for returning a JSON formatted message.
 */
@RestController
@RequestMapping(value = "/example/message")
public class ExampleController {
    private static final Logger LOG = LoggerFactory.getLogger(ExampleController.class);

    @Autowired
    private ExampleService service;

    @Autowired
    private DropwizardMetricServices metrics;

    /**
     * Asynchronously retrieves the current message.
     *
     * @return asynchronous result
     */
    @RequestMapping(method = RequestMethod.GET)
    public DeferredResult<ResponseEntity<ExampleMessage>> getMessage() {
        final DeferredResult<ResponseEntity<ExampleMessage>> deferredResult = new DeferredResult<>();

        metrics.increment("exampletest");

        service.getMessage()
                .last()
                .subscribeOn(Schedulers.computation())
                .subscribe(text -> deferredResult.setResult(ResponseEntity.ok(new ExampleMessage(text))));

        return deferredResult;
    }

    /**
     * Sets the recipient of the message.
     *
     * @param recipient message recipient name
     */
    @RequestMapping(method = RequestMethod.PUT,
                    value = "/recipient",
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setMessageRecipient(@Valid @RequestBody ExampleRecipient recipient) {
        service.setMessageRecipient(recipient.getName());
    }
}
