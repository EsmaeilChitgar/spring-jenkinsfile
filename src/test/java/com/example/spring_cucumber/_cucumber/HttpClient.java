package com.example.spring_cucumber._cucumber;

import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public abstract class HttpClient {

    private final String SERVER_URL = "http://localhost";

    @LocalServerPort
    private int port;

    protected final RestTemplate restTemplate = new RestTemplate();

    protected String endpoint(String endpointPath) {
        return SERVER_URL + ":" + port + endpointPath;
    }

    protected <T> T getForEntity(String endpointPath, Class<T> responseType) {
        return restTemplate.getForEntity(endpoint(endpointPath), responseType).getBody();
    }

    protected <T> T postForEntity(String endpointPath, Object request, Class<T> responseType) {
        return restTemplate.postForEntity(endpoint(endpointPath), request, responseType).getBody();
    }

    protected <T> T putForEntity(String endpointPath, Object request, Class<T> responseType) {
        return restTemplate.exchange(endpoint(endpointPath), HttpMethod.PUT, new HttpEntity<>(request), responseType).getBody();
    }

    protected void delete(String endpointPath) {
        restTemplate.delete(endpoint(endpointPath));
    }

    protected int postForStatus(String endpointPath, Object request) {
        return restTemplate.postForEntity(endpoint(endpointPath), request, Void.class).getStatusCode().value();
    }
}
