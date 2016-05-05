package com.niketech.helloneo4j3.domain;

import com.niketech.blueprint.springboot.core.validation.ValidationSupport;
import com.niketech.blueprint.springboot.core.validation.Validator;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public class ExampleRecipient implements ValidationSupport<ExampleRecipient> {

    @NotBlank
    private String name;

    @Override
    public Validator<ExampleRecipient> validator() {
        return (target, errors) -> {
            if (target.getName().equalsIgnoreCase("bob")) {
                errors.rejectValue("name", "", "Bob cannot receive messages!");
            }
        };
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
