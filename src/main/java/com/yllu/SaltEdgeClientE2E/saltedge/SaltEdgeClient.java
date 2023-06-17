package com.yllu.SaltEdgeClientE2E.saltedge;

import com.yllu.SaltEdgeClientE2E.properties.ClientProperties;
import com.yllu.SaltEdgeClientE2E.saltedge.model.InitiateSessionRequest;
import io.restassured.response.Response;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class SaltEdgeClient {

    private final RestAssuredTemplate restAssuredTemplate;
    private final ClientProperties clientProperties;

    private final String GET_CONNECTION = "http://localhost:8090/session/create";

    public SaltEdgeClient(ClientProperties clientProperties) {
        this.restAssuredTemplate = new RestAssuredTemplate();
        this.clientProperties = clientProperties;

    }

    public Response getConnectUrl(InitiateSessionRequest request) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        return restAssuredTemplate.post(GET_CONNECTION, request, headers);
    }
}
