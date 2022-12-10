Feature: Amazon page tests

  Scenario: Amazon page tests
    Given I open "Amazon" page
    When I hover over "Accounts" element
    Then I see "Accounts options container" should be "visible" on Amazon page

  Scenario: Search in searchbox with capital letters
    Given I open "Amazon" page
    When I type "HELLO" into "Searchbox" element
    Then I wait for "5" seconds
