Feature: Add Item
  As a user
  I want to add an item to the list of item
  So i can see it as part of the list

  Scenario:
    Given user is logged in successfully
    And the user is on the item page
    When the user clicks on the Add Item button
    And the user enters the item name
    And the user enters the item description
    And the user enters the item price "12.99"
    And the user enters the item unit "grams"
    And the user clicks on the Save Item button
    Then the item should be listed in the items table


# BElow is an example of the manual test case for the gherkin exmaple above
#1.	Navigate to Crater application (You are able to login successfully)
#2.	Navigate to the Items page.
#3.	Click on the Add Item button.
#4.	Enter the item name.
#5.	Enter the item description.
#6.	Enter the item price “12.99.
#7.	Select the item unit “grams”
#8.	Click the Save Item button.
#9.	Verify that the new item is listed in the items table.







