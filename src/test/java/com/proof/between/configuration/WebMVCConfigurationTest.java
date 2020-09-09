package com.proof.between.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebMVCConfigurationTest {

    @Test
    void shouldReturnWebMVCConfiguration() {
        final WebMVCConfiguration webMvcConfiguration = new WebMVCConfiguration();
        Assertions.assertNotNull(webMvcConfiguration);
    }
}
