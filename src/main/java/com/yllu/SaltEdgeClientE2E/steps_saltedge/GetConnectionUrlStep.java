package com.yllu.SaltEdgeClientE2E.steps_saltedge;


import com.yllu.SaltEdgeClientE2E.configuration.WebDriverConfiguration;
import com.yllu.SaltEdgeClientE2E.pages_saltedge.ConfirmPage;
import com.yllu.SaltEdgeClientE2E.pages_saltedge.FakeBankPage;
import com.yllu.SaltEdgeClientE2E.pages_saltedge.FlowSelectionPage;
import com.yllu.SaltEdgeClientE2E.pages_saltedge.ApplicationPage;
import com.yllu.SaltEdgeClientE2E.saltedge.InitiateSessionRequest;
import com.yllu.SaltEdgeClientE2E.saltedge.SaltEdgeClient;
import com.yllu.SaltEdgeClientE2E.saltedge.SessionData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.vavr.control.Try;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;


public class GetConnectionUrlStep {

    @Autowired
    SaltEdgeClient saltEdgeClient;
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
    public void theUrlIsReturned() {
        WebDriver webDriver = WebDriverConfiguration.chromeDriver();
        FakeBankPage fakeBankPage = new FakeBankPage(webDriver);
        fakeBankPage.navigateTo(connectUrl);

        String connectUrl = Try.of(fakeBankPage::clickProceed)
                .mapTry(ConfirmPage::confirmClick)
                .mapTry(FlowSelectionPage::clickGrantAccess)
                .mapTry(ApplicationPage::returnBackToApplication)
                .get();

        System.out.println(connectUrl);

    }

}