package com.niketech.helloneo4j3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication(scanBasePackages = {"com.niketech"})
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class Application {

    /**
     * Main entry point of the application.
     *
     * @param args command line arguments
     */
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
