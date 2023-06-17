package com.yllu.SaltEdgeClientE2E;

import com.yllu.SaltEdgeClientE2E.pages_saltedge.FakeBankWithClientKeys;
import com.yllu.SaltEdgeClientE2E.properties.ClientProperties;
import com.yllu.SaltEdgeClientE2E.saltedge.SaltEdgeClient;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = {SaltEdgeClient.class, FakeBankWithClientKeys.class})
@EnableConfigurationProperties({ClientProperties.class})
public class CucumberTestConfiguration {
}
