package com.yllu.SaltEdgeClientE2E.steps_saltedge;


import com.yllu.SaltEdgeClientE2E.pages_saltedge.FakeBankWithClientKeys;
import com.yllu.SaltEdgeClientE2E.saltedge.model.InitiateSessionRequest;
import com.yllu.SaltEdgeClientE2E.saltedge.SaltEdgeClient;
import com.yllu.SaltEdgeClientE2E.saltedge.model.SessionData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;


public class GetConnectionUrlStep {

    @Autowired
    SaltEdgeClient saltEdgeClient;
    @Autowired
    FakeBankWithClientKeys fakeBankWithClientKeys;

    private String connectUrl;

    @Given("get connect url")
    public void getConnectUrl() {
        InitiateSessionRequest initiateSessionRequest = InitiateSessionRequest.builder()
                .customerId("980673697524226607")
                .aspspCode("fake_oauth_client_xf")
                .build();


        Response response = saltEdgeClient.getConnectUrl(initiateSessionRequest);
        SessionData sessionData = response.getBody().as(SessionData.class);
        this.connectUrl = sessionData.getConnect_url();
    }

    @Then("the url is returned")
    public void theUrlIsReturned() {
        fakeBankWithClientKeys.startWidgetHappyFlow(connectUrl);
        System.out.println(connectUrl);

    }

}
