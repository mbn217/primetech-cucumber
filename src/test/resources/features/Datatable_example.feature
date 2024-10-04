Feature: Example of cucumber data table implementation

  @demo
  Scenario: List of fruit I like
    Given I have the following list og fruit
      | fruit  |
      | apple  |
      | banana |
      | orange |
      | kiwi   |
    When I go to the market
    Then I should have 4 fruits in my basket



#    Given I like apple
#    And I like banana
#    And I like orange
#    And I like kiwi
#    When I go to the market
#    Then I should have 4 fruits in my basket