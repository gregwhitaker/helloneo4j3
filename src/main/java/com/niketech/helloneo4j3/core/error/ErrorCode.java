package com.niketech.helloneo4j3.core.error;

import com.niketech.blueprint.springboot.core.error.BlueprintErrorCode;

/**
 * Enumeration of error codes used within this application.
 */
public enum ErrorCode implements BlueprintErrorCode {
    UNHANDLED_ERROR("99999");

    private final String value;

    ErrorCode(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
