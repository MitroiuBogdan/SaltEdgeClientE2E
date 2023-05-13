package com.yllu.SaltEdgeClientE2E.configuration;

import com.yllu.SaltEdgeClientE2E.properties.ClientProperties;
import com.yllu.SaltEdgeClientE2E.saltedge.SaltEdgeClient;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@CucumberContextConfiguration
@SpringBootTest(classes = {SaltEdgeClient.class, RestTemplate.class, ClientProperties.class})
public class CucumberTestConfiguration {
}
