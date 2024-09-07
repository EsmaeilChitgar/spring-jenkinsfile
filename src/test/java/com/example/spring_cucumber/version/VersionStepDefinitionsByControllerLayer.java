package com.example.spring_cucumber.version;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
public class VersionStepDefinitionsByControllerLayer {
    private final RestTemplate restTemplate;

    @LocalServerPort
    private int port;
    private String actualResponse;

    @When("request the version")
    public void requestTheVersion() {
        actualResponse = this.restTemplate.getForObject("http://localhost:" + port + "/version", String.class);
    }

    @Then("the response should be {string}")
    public void theResponseShouldBe(String expectedVersion) {
        assertEquals(expectedVersion, actualResponse);
    }
}