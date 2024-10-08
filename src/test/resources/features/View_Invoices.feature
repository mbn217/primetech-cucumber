@crater
Feature: View Invoices

  Scenario: Successfully view and navigate to the invoices page
    Given user is logged in successfully
    And the user is on the invoices page
    Then the Invoices label should be displayed
    And the user clicks on a specific invoice
    Then the invoice details should be displayed on the right side of the screen




#  1.	Navigate to Crater application (You are able to login successfully)
#  2.	Navigate to the Invoices page.
#  3.	Verify Invoices label is displayed
#  6.	Click on a specific invoice to view its details.
#  7.	Verify the invoice details are displayed correctly on the right side of the screen.
