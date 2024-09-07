Feature: Version API

  Scenario: Get API version
    When request the version
    Then the response should be "1.0"