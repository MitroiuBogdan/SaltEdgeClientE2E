package com.yllu.SaltEdgeClientE2E.saltedge;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.config.RedirectConfig.redirectConfig;

public class RestAssuredTemplate {

    private final RequestSpecification initialSpec;

    public RestAssuredTemplate() {
        this.initialSpec = setInitialRequestSpecification();
    }

    public Response exchange(String url, Method method, Object requestBody, Headers headers) {
        return RestAssured.given()
                .given()
                .spec(initialSpec)
                .body(requestBody)
                .headers(headers)
                .request(method, url);
    }

    private static RequestSpecification setInitialRequestSpecification() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .urlEncodingEnabled(false)
                .config(setCertificatesAndDoNotFollowRedirects())
                .filters(List.of(
                        new RequestLoggingFilter(),
                        new ResponseLoggingFilter(),
                        new ErrorLoggingFilter()
                ));

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
