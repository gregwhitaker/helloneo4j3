package com.niketech.helloneo4j3.domain;

/**
 * Example model returned by @{@link com.niketech.helloneo4j3.controller.ExampleController}.
 */
public class ExampleMessage {
    private final String text;

    public ExampleMessage(String text) {
        this.text = text;
    }

    /**
     * @return message text
     */
    public String getText() {
        return text;
    }
}
