Feature: User functionalities

  Scenario: add new user
    Given the user list is empty
    When adding new user:
      | id  | username  | password  |
      | 1   | ali       | pass      |
    Then the user list should contain 1 users

  Scenario: Update an existing user
    Given the user list is empty
    And adding new user:
      | id  | username  | password  |
      | 1   | ali       | pass      |
    When updating user with id 1:
      | username  | password  |
      | aliUpdated| passNew   |
    Then the user with id 1 should have username "aliUpdated" and password "passNew"

  Scenario: Delete a user
    Given the user list is empty
    And adding new user:
      | id  | username  | password  |
      | 1   | ali       | pass      |
    When deleting user with id 1
    Then the user list should contain 0 users

  Scenario: Add multiple users
    Given the user list is empty
    When adding new users:
      | id  | username  | password  |
      | 1   | ali       | pass      |
      | 2   | sara      | pass2   |
      | 3   | mehdi     | pass12   |
    Then the user list should contain 3 users