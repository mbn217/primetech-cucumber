@crater
Feature: Add New Invoice

  Scenario: Successfully add a new invoice
    Given user is logged in successfully
    And the user is on the invoices page
    When the user clicks on the Add New Invoice button
    And the user selects a client from the New Customer dropdown
    And the user add exchange rate "13.00"
    And the user selects an item from the Item dropdown
    And the user enters the quantity "2"
    And the user enters the price "4.99"
    And the user clicks on the Save Invoice button
    Then the invoice should be saved and listed in the invoices list
    And the invoice total should match the items and their quantities
