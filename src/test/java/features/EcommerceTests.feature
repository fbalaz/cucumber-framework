Feature: Ecommerce page tests

  Scenario: Add items to cart and proceed to checkout
    Given I open "Greenkart" page
    And I add "Pumpkin" of quantity "4" into cart
    And I click on "Cart" button
    Then "Proceed to checkout" button should be "visible"
    And I click on "Proceed to checkout" button
    Then I wait for "5" seconds

