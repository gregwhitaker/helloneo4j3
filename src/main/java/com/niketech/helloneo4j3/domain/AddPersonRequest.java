package com.niketech.helloneo4j3.domain;

import javax.validation.constraints.NotNull;

public class AddPersonRequest {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
