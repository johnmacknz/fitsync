Feature: Health Statistics API

  Scenario: Retrieve Health Statistics
    Given the Health Statistics API is operational
    When a user requests health statistics
    Then the system should respond with a successful status