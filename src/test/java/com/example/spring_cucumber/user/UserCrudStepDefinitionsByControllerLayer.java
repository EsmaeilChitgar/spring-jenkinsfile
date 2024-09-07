package com.example.spring_cucumber.user;

import com.example.spring_cucumber.model.User;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class UserCrudStepDefinitionsByControllerLayer {

    @Autowired
    private UserHttpClient userHttpClient;

    @Given("the user list is empty$")
    public void theUserListIsEmpty() {
        userHttpClient.clean();
        assertThat(userHttpClient.getUsers().isEmpty()).isTrue();
    }

    @When("adding new user:")
    public void addingNewUser(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        User user = new User();
        user.setId(Long.valueOf(data.get("id")));
        user.setUsername(data.get("username"));
        user.setPassword(data.get("password"));
        userHttpClient.addUser(user);
    }

    @When("updating user with id {long}:")
    public void updatingUser(Long id, DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        User updatedUser = new User();
        updatedUser.setId(id);
        updatedUser.setUsername(data.get("username"));
        updatedUser.setPassword(data.get("password"));
        userHttpClient.updateUser(id, updatedUser);
    }

    @Then("^the user list should contain (\\d+) users$")
    public void theUserListShouldContainOnly1User(final int quantity) {
        List users = userHttpClient.getUsers();
        Assertions.assertEquals(quantity, users.size());
    }

    @When("deleting user with id {long}")
    public void deletingUser(Long id) {
        userHttpClient.deleteUser(id);
    }

    @Then("the user with id {long} should have username {string} and password {string}")
    public void theUserShouldHaveUpdatedValues(Long id, String expectedUsername, String expectedPassword) {
        User user = userHttpClient.getUserById(id);
        assertThat(user.getUsername()).isEqualTo(expectedUsername);
        assertThat(user.getPassword()).isEqualTo(expectedPassword);
    }

    @When("adding new users:")
    public void addingNewUsers(DataTable dataTable) {
        List<Map<String, String>> userDataList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> data : userDataList) {
            User user = new User();
            user.setId(Long.valueOf(data.get("id")));
            user.setUsername(data.get("username"));
            user.setPassword(data.get("password"));
            userHttpClient.addUser(user);
        }
    }
}