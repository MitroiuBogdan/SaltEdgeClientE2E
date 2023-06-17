package com.yllu.SaltEdgeClientE2E.saltedge;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.vavr.control.Try;

import java.util.Map;

import static io.restassured.config.RedirectConfig.redirectConfig;

public class RestAssuredTemplate {

    private RequestSpecification initialSpec;
    private ObjectMapper objectMapper;

    public RestAssuredTemplate() {
        this.objectMapper = new ObjectMapper();
        this.initialSpec = setInitialRequestSpecification();
    }


    public Response post(String url, Object body, Map<String, String> headers) {
        RequestSpecification requestSpec= RestAssured.given().spec(initialSpec);

        String requestBody = Try.of(() -> objectMapper.writeValueAsString(body)).get();
        headers.entrySet().stream()
                .forEach(entry -> requestSpec.header(entry.getKey(), entry.getValue()));

        requestSpec.body(requestBody);
        requestSpec.log().all();

        Response response = requestSpec.post(url);
        response.getBody().print();

        return response;
    }

    private static RequestSpecification setInitialRequestSpecification() {
        RestAssuredConfig sslConfig = setCertificatesAndDoNotFollowRedirects();

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setUrlEncodingEnabled(false)
                .build();

        return RestAssured.given()
                .spec(requestSpecification)
                .config(sslConfig);

    }
    private static RestAssuredConfig setCertificatesAndDoNotFollowRedirects() {

        String truststore_path = "src/main/resources/trust.jks";
        String keystore_path = "src/main/resources/identity-acc.jks";
        return RestAssured.config()
                .redirect(redirectConfig().followRedirects(false)
//                .sslConfig(sslConfig()
//                        .with()
//                        .trustStore(truststore_path, getVaultProperty())
//                        .and()
//                        .keyStore(keystore_path, getVaultProperty())
                );
    }
}
