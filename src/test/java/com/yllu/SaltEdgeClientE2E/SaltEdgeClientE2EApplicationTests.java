package com.yllu.SaltEdgeClientE2E;

import com.yllu.SaltEdgeClientE2E.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SaltEdgeClientE2EApplicationTests {

    @Autowired
    MainPage mainPage;

    @Test
    void contextLoads() {
        mainPage.performScenario();
    }

}
