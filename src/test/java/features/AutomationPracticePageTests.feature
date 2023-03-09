Feature: AutomationPractice page tests
@Smoke
  Scenario: Accept alert
    Given I open "Automation practice" page
    When I type "Filip" into "Name" field
    And I click on "Alert" button
    Then I click on "Accept" in alert
@Smoke
  Scenario: Dismiss alert
    Given I open "Automation practice" page
    When I type "Filip" into "Name" field
    And I click on "Confirm" button
    Then I click on "Dismiss" in alert

@Smoke
  Scenario: Find element in element
    Given I open "Automation practice" page
    When I scroll to the end of page
    Then I open "Soapui" prelink in new tab
    Then I close browser
@Smoke
  Scenario: Get titles of the opened tabs
    Given I open "Automation practice" page
    When I scroll to the end of page
    Then I open "Soapui" prelink in new tab
    Then I open "Appium" prelink in new tab
    And I get title of every opened tab
    Then I see tabs should have title "Practice page" And "appium mobile automation testing from scratch + frameworks tutorial | udemy" And "the world's most popular api testing tool | soapui"
@Smoke
  Scenario: Check response code of broken link
    Given I open "Automation practice" page
    When I scroll to the end of page
    Then I extract url from "Broken Link" prelink element
    And I navigate to extracted url
    Then I check HTTP code should be "404"
@Smoke
  Scenario: Check response codes of all prelinks in footer
    Given I open "Automation practice" page
    When I scroll to the end of page
    Then I extract urls from "All" prelink elements
    And I navigate to extracted urls
    Then I check HTTP codes should be "200"