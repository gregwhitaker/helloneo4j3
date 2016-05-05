package com.niketech.helloneo4j3;

import com.niketech.helloneo4j3.health.HealthCheck;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void context() {
        assertTrue("Unit is not an active profile",
                ArrayUtils.contains(applicationContext.getEnvironment().getActiveProfiles(), "unit"));

        HealthCheck healthCheck = applicationContext.getBean(HealthCheck.class);
        assertNotNull("HealthCheck bean is null", healthCheck);
    }
}
