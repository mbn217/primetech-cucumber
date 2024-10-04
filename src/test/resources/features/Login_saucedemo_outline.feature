Feature: Login to sauce demo
  As a user
  I should not be able to login using invalid credentials
#To make a scenario outline we have three rules
#  1. We need to use Scenario outline instead of Scenario
#  2. We need to parameterize the fields that will have different values
#  3. we need to use Examples for the parameters

  Scenario Outline: can not login with invalid credentials
    Given user on login page
    When user enters  "<username>" and enters "<password>"
    Then user should not be able to login

    Examples:
      | username                | password     |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_abc   |
      | performance_glitch_user | secret_xyz   |
      | error_user              | secret_rrr   |



#  locked_out_user
#  problem_user
#  performance_glitch_user
#  error_user