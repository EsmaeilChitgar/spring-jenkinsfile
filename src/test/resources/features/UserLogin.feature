Feature: User Login

  Scenario: Successful login with valid credentials
    Given save new user to database
    Given the user is on the login page
    When the user enters valid credentials
    Then a success message should be displayed
    Then the user should be redirected to the welcome page

  Scenario: Failed login with invalid credentials
    Given the user is on the login page
    When the user enters invalid credentials
    Then an error message should be displayed
    And the user should remain on the login page