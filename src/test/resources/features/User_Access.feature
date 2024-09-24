Feature: User Access Management
  As a user I want to login to my crater application

  Scenario: User should be able to login with valid credentials
    Given user is navigated to Crater login page
    When user enters valid username and valid password
    And user clicks on login button
    Then user should be logged in successfully

# Cucumber reuses the steps that are already implemented.
# if there are same two steps,
# cucumber only generates one step definition and reuses that step definition between that two steps

  Scenario: User should not be able to login with invalid email
    Given user is navigated to Crater login page
    When user enters invalid username and valid password
    And user clicks on login button
    Then user should see an error message "These credentials do not match our records." displayed
    And user should not be logged in
