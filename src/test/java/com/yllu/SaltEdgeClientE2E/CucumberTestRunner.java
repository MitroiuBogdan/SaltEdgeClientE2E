package com.yllu.SaltEdgeClientE2E;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/yllu/SaltEdgeClientE2E/features"},
        glue = {"com.yllu.SaltEdgeClientE2E.steps"}
)
public class CucumberTestRunner {


}
