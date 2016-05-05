package com.niketech.helloneo4j3.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import rx.Observable;

/**
 * Service responsible for returning an example message.
 */
@Component
public class ExampleService {
    private static final Logger LOG = LoggerFactory.getLogger(ExampleService.class);

    private volatile String recipient = "World";

    /**
     * Gets the current message.
     *
     * @return example message
     */
    public Observable<String> getMessage() {
        LOG.info("Getting the message from the ExampleService!");

        return Observable.create(sub -> {
            sub.onNext(String.format("Hello %s!", recipient));
            sub.onCompleted();
        });
    }

    /**
     * Changes the recipient of the example message.
     *
     * @param name message recipient
     */
    public void setMessageRecipient(String name) {
        LOG.info("Setting new message recipient: {}", name);
        recipient = name;
    }
}
