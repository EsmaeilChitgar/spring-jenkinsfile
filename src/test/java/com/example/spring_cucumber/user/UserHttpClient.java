package com.example.spring_cucumber.user;

import com.example.spring_cucumber.model.User;
import com.example.spring_cucumber._cucumber.HttpClient;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class UserHttpClient extends HttpClient {

    private final String USER_ENDPOINT = "/users";

    public User addUser(User user) {
        return postForEntity(USER_ENDPOINT, user, User.class);
    }

    public User updateUser(Long id, User user) {
        return putForEntity(USER_ENDPOINT + "/" + id, user, User.class);
    }

    public void deleteUser(Long id) {
        delete(USER_ENDPOINT + "/" + id);
    }

    public void clean() {
        delete(USER_ENDPOINT);
    }

    public List<User> getUsers() {
        return getForEntity(USER_ENDPOINT, List.class);
    }

    public User getUserById(Long id) {
        return getForEntity(USER_ENDPOINT + "/" + id, User.class);
    }

    public User getUserByName(String name) {
        return getForEntity(USER_ENDPOINT + "/name/" + name, User.class);
    }
}