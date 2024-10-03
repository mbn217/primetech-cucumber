@crater
Feature: View Invoices

  Scenario: Successfully view and navigate the invoices page
    Given user is logged in successfully
    And the user is on the invoices page
    Then the Invoices label should be displayed
    And the user clicks on a specific invoice
    Then the invoice details should be displayed on the right side of the screen


 #And the pagination should be displayed as "Home/Invoices"  #this require more logic because its not a single label
