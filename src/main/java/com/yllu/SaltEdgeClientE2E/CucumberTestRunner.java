package com.yllu.SaltEdgeClientE2E;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features"},
        extraGlue = {"com.yllu.SaltEdgeClientE2E.saltedge"}
)
public class CucumberTestRunner {


}
