package com.example.spring_cucumber.user;

import com.example.spring_cucumber.model.User;
import com.example.spring_cucumber.repository.UserRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import lombok.RequiredArgsConstructor;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

@RequiredArgsConstructor
public class UserLoginStepDefinitionsByRepositoryLayer {
    private final UserRepository userRepository;
    private boolean onLoginPage = false;
    private boolean loginSuccess = false;

    @Given("save new user to database")
    public void saveNewUserToDatabase() {
        userRepository.save(User.builder().id(1L).username("username").password("password").build());
    }
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        onLoginPage = true;
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginSuccess = userRepository.findByUsernameAndPassword("username", "password").isPresent();
    }

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        loginSuccess = userRepository.findByUsernameAndPassword("username", "invalid-password").isPresent();
    }

    @Then("the user should be redirected to the welcome page")
    public void the_user_should_be_redirected_to_the_welcome_page() {
        assertTrue(onLoginPage && loginSuccess);
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        assertFalse(loginSuccess);
    }

    @And("the user should remain on the login page")
    public void the_user_should_remain_on_the_login_page() {
        assertTrue(onLoginPage);
    }

    @Then("a success message should be displayed")
    public void aSuccessMessageShouldBeDisplayed() {
        assertTrue(loginSuccess);
    }
}