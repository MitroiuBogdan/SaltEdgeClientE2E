package com.yllu.SaltEdgeClientE2E.steps;

import com.yllu.SaltEdgeClientE2E.temp.Calculate;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = Calculate.class)
@CucumberContextConfiguration
public class CalculateStep {
    @Autowired
    Calculate calculate;

    private int firstArg;
    private int secondArg;
    private int sum;

    @Given("the first number is {int}")
    public void theFirstNumberIs(int arg0) {
        firstArg = arg0;
    }

    @And("the second number is {int}")
    public void theSecondNumberIs(int arg0) {
        secondArg = arg0;
    }

    @When("I add the two numbers")
    public void iAddTheTwoNumbers() {
        sum = calculate.add(firstArg, secondArg);
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int arg0) {
        Assert.assertEquals(arg0, sum);
    }
}
