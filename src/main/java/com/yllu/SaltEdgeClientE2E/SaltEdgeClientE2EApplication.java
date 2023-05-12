package com.yllu.SaltEdgeClientE2E;

import com.yllu.SaltEdgeClientE2E.pages.MainPage;
import com.yllu.SaltEdgeClientE2E.properties.AppProperties;
import com.yllu.SaltEdgeClientE2E.properties.ClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({AppProperties.class, ClientProperties.class})
public class SaltEdgeClientE2EApplication implements CommandLineRunner {


    @Autowired
    MainPage mainPage;

    public static void main(String[] args) {
        SpringApplication.run(SaltEdgeClientE2EApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mainPage.performScenario();
    }
}
