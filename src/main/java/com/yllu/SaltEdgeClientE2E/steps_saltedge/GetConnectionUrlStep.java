package com.yllu.SaltEdgeClientE2E.steps_saltedge;


import com.yllu.SaltEdgeClientE2E.pages_saltedge.FakeBankWithClientKeys;
import com.yllu.SaltEdgeClientE2E.saltedge.model.InitiateSessionRequest;
import com.yllu.SaltEdgeClientE2E.saltedge.SaltEdgeClient;
import com.yllu.SaltEdgeClientE2E.saltedge.model.SessionData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.vavr.control.Option;
import io.vavr.control.Try;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.*;


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


//        Response response = saltEdgeClient.getConnectUrl(initiateSessionRequest);

        // Validations
//        response.then()
//                .body("connect_url", notNullValue());
//
//        when().
//                get("/lotto").
//                then().
//                time(lessThan(2000L));
        Headers headers = new Headers(
                new Header("Content-Type", "application/json")
        );
//        SessionData sessionData = saltEdgeClient.getConnectUrl(initiateSessionRequest, headers)
//                .then()
//                .assertThat().statusCode(200)
//                .assertThat().contentType(ContentType.JSON)
//                .assertThat().body(matchesJsonSchemaInClasspath("get-connect-url.json"))
//                .time(lessThan(1000L))
//                .extract()
//                .as(new TypeRef<>() {
//                });
//
//        SessionData sessionData = Try.of(() -> saltEdgeClient.getConnectUrl(initiateSessionRequest, headers))
//                .map(this::validateGetConnectUrlResponseHappyFlow)
//                .map(validatedResponse -> validatedResponse
//                        .extract()
//                        .as(new TypeRef<SessionData>() {
//                        }))
//                .andThen(data -> {
//                    Assert.assertNotNull(data.getConnect_url());
//                    Assert.assertNotNull(data.getExpires_at());
//                }).get();

        SessionData sessionData = Option.of(saltEdgeClient.getConnectUrl(initiateSessionRequest, headers))
                .map(this::validateGetConnectUrlResponseHappyFlow)
                .map(response -> response.extract().as((SessionData.class)))
                .peek(this::validateSessionDataContent)
                .get();


//        then().body("price", is(12.12f))
//                body("$", hasItems(1, 2, 3));

        //        JsonPath.from(response.asString()).get("field");
//        https://www.hascode.com/2011/10/testing-restful-web-services-made-easy-using-the-rest-assured-framework/
//        SessionData sessionData = response.as(new TypeRef<>() {
//        });

// Whe


//        SessionData sessionData = response.getBody().as(SessionData.class);
        this.connectUrl = sessionData.getConnect_url();
    }

    @Then("the url is returned")
    public void theUrlIsReturned() {
        fakeBankWithClientKeys.startWidgetHappyFlow(connectUrl);
        System.out.println(connectUrl);

    }

    public ValidatableResponse validateGetConnectUrlResponseHappyFlow(Response response) {
        return response.then()
                .assertThat().statusCode(200)
                .assertThat().contentType(ContentType.JSON)
                .assertThat().body(matchesJsonSchemaInClasspath("get-connect-url.json"))
                .time(lessThan(1000L));
    }

    public void validateSessionDataContent(SessionData sessionData) {
        Assert.assertNotNull(sessionData.getConnect_url());
        Assert.assertNotNull(sessionData.getExpires_at());
    }

}
