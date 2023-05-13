package com.yllu.SaltEdgeClientE2E.saltedge;

import com.yllu.SaltEdgeClientE2E.properties.ClientProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class SaltEdgeClient {

    private final RestTemplate restTemplate;
    private final ClientProperties clientProperties;

    private final static String GET_CONNECT_URL = "http://localhost:8090/session/create";

    public SaltEdgeClient(RestTemplate restTemplate, ClientProperties clientProperties) {
        this.restTemplate = restTemplate;
        this.clientProperties = clientProperties;
    }

    public SessionData getConnectUrl(InitiateSessionRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<InitiateSessionRequest> entity = new HttpEntity<>(request, headers);

        return restTemplate.exchange(GET_CONNECT_URL, HttpMethod.POST, entity, SessionData.class).getBody();
    }
}
