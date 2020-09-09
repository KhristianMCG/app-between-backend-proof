package com.proof.between.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringFoxConfigurationTest {

    @Test
    void shouldReturnWSpringFoxConfiguration() {
        final SpringFoxConfiguration springFoxConfiguration = new SpringFoxConfiguration();
        Assertions.assertNotNull(springFoxConfiguration.api());
    }
}
