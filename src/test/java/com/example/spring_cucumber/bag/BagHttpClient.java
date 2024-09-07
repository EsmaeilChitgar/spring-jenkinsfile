package com.example.spring_cucumber.bag;

import com.example.spring_cucumber._cucumber.HttpClient;
import com.example.spring_cucumber.model.Bag;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class BagHttpClient extends HttpClient {

    private final String THINGS_ENDPOINT = "/things";

    public int put(final String something) {
        return postForStatus(THINGS_ENDPOINT, something);
    }

    public Bag getContents() {
        return getForEntity(THINGS_ENDPOINT, Bag.class);
    }

    public void clean() {
        delete(THINGS_ENDPOINT);
    }
}