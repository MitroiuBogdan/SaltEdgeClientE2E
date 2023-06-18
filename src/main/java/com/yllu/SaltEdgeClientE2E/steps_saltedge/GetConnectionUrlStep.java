package com.yllu.SaltEdgeClientE2E.steps_saltedge;


import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.core.load.configuration.LoadingConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.yllu.SaltEdgeClientE2E.pages_saltedge.FakeBankWithClientKeys;
import com.yllu.SaltEdgeClientE2E.saltedge.model.InitiateSessionRequest;
import com.yllu.SaltEdgeClientE2E.saltedge.SaltEdgeClient;
import com.yllu.SaltEdgeClientE2E.saltedge.model.SessionData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
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

        SessionData sessionData = saltEdgeClient.getConnectUrl(initiateSessionRequest)
                .then()
                .assertThat().body(matchesJsonSchemaInClasspath("get-connect-url.json"))
                .assertThat().statusCode(200)
                .extract()
                .as(new TypeRef<>() {});

        Assert.assertNotNull(sessionData.getConnect_url());

//        then().body("price", is(12.12f))
//                body("$", hasItems(1, 2, 3));

        //        JsonPath.from(response.asString()).get("field");
//        https://www.hascode.com/2011/10/testing-restful-web-services-made-easy-using-the-rest-assured-framework/
//        SessionData sessionData = response.as(new TypeRef<>() {
//        });
//        Assert.assertNotNull(sessionData);
//        Assert.assertNotNull(sessionData.getConnect_url());
// Whe


//        SessionData sessionData = response.getBody().as(SessionData.class);
        this.connectUrl = sessionData.getConnect_url();
    }

    @Then("the url is returned")
    public void theUrlIsReturned() {
        fakeBankWithClientKeys.startWidgetHappyFlow(connectUrl);
        System.out.println(connectUrl);

    }

}
