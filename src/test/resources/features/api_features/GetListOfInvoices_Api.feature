@api
Feature: Get list of invoices

  Scenario: Get list og invoices
    Given Im logged in successfully
    When I perform GET operation for "api/v1/invoices" endpoint
    Then I should get 200 status code
    And I should get list of invoices