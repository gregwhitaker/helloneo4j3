package com.niketech.helloneo4j3.health;

import com.niketech.blueprint.springboot.core.health.BlueprintHealthCheck;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck extends BlueprintHealthCheck {

    @Override
    public Health doHealthCheck() {
        return Health.up().build();
    }
}
