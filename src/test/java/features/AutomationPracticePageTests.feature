Feature: AutomationPractice page tests

  Scenario: Accept alert
    Given I open "Automation practice" page
    When I type "Filip" into "Name" field
    And I click on "Alert" button
    Then I click on "Accept" in alert

  Scenario: Dismiss alert
    Given I open "Automation practice" page
    When I type "Filip" into "Name" field
    And I click on "Confirm" button
    Then I click on "Dismiss" in alert


  Scenario: Find element in element
    Given I open "Automation practice" page
    When I scroll to the end of page
    Then I open "Soapui" prelink in new tab
    Then I close browser

  Scenario: Get titles of the opened tabs
    Given I open "Automation practice" page
    When I scroll to the end of page
    Then I open "Soapui" prelink in new tab
    Then I open "Appium" prelink in new tab
    And I get title of every opened tab
    Then I see tabs should have title "Practice page" And "appium mobile automation testing from scratch + frameworks tutorial | udemy" And "the world's most popular api testing tool | soapui"

  @Test
  Scenario: Scroll to tsble and count total amount of values
    Given I open "Automation practice" page
    When I scroll onto "Webtable" element
    And I scroll inside "Webtable" element
    Then I see total amount count is equal to value in "Total Amount Collected" element