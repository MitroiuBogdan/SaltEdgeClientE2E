package com.yllu.SaltEdgeClientE2E.steps;


import com.yllu.SaltEdgeClientE2E.pages.BasePage;
import com.yllu.SaltEdgeClientE2E.pages.ConfirmPage;
import com.yllu.SaltEdgeClientE2E.pages.FakeBankPage;
import com.yllu.SaltEdgeClientE2E.properties.ClientProperties;
import com.yllu.SaltEdgeClientE2E.saltedge.InitiateSessionRequest;
import com.yllu.SaltEdgeClientE2E.saltedge.SaltEdgeClient;
import com.yllu.SaltEdgeClientE2E.saltedge.SessionData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = {SaltEdgeClient.class, RestTemplate.class, ClientProperties.class, FakeBankPage.class})
@CucumberContextConfiguration
public class GetConnectionUrlStep {

    @Autowired
    SaltEdgeClient saltEdgeClient;
    @Autowired
    FakeBankPage fakeBankPage;

    private String connectUrl;


    @Given("get connect url")
    public void getConnectUrl() {
        InitiateSessionRequest initiateSessionRequest = InitiateSessionRequest.builder()
                .customerId("980673697524226607")
                .aspspCode("fake_oauth_client_xf")
                .build();


        SessionData sessionData = saltEdgeClient.getConnectUrl(initiateSessionRequest);
        this.connectUrl = sessionData.getLoginUrl();
    }

    @Then("the url is returned")
    public void theUrlIsReturned() throws InterruptedException {
        fakeBankPage.navigateTo(connectUrl);
        System.out.println(connectUrl);
    }

}
