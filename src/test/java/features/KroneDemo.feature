Feature: Krone demo

  Scenario: Validate Linkedin URL
    Given I open "Krone Homepage" page
    When I scroll to the "Footer" of the page
    And I accept all cookies if notification is shown
    And I click on "Linkedin" icon
    And I switch to newly opened tab
    Then I am on correct "Linkedin" url

  Scenario: Validate Instagram URL
    Given I open "Krone Homepage" page
    When I scroll to the "Footer" of the page
    And I accept all cookies if notification is shown
    And I click on "Instagram" icon
    And I switch to newly opened tab
    Then I am on correct "Instagram" url