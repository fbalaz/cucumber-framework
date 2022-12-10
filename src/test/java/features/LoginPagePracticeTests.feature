Feature: Login page practice

  Scenario: Tab switching test
    Given I open "Login page practice" page
    When I click on "Free access prelink" element
    And I switch tab
    And I wait for "6" seconds
    Then I see "Contact email" element should be "visible"
    And I extract "Contact email" element text
    And I switch tab
    And I type extracted text into "Username" field
    Then I see extracted text in "Username" field
    And I wait for "3" seconds