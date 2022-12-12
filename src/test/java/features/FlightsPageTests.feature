Feature: Flights page tests

  Scenario: Choose value from static dropdown
    Given I open "Flights booking" page
    When I choose "USD" from "Currency" dropdown
    Then I see "USD" is chosen currency

  Scenario: Choose value from dynamic autosuggest dropdown
    Given I open "Flights booking" page
    When I type "Slo" into "Autosuggest" dropdown
    Then I see "Autosuggest options list" should be "visible"
    And I click on "Slovenia" in "Autosuggest options list" list
    Then I see "Autosuggest options list" should be "invisible"
    Then I see "Slovenia" in "Autosuggest" dropdown

  Scenario: Set number of passengers from dropdown
    Given I open "Flights booking" page
    When I click on "Passenger" dropdown
    And I choose "2" passengers as "Adult"
    And I choose "1" passenger as "Child"
    And I choose "3" passengers as "Infant"
    Then I see "2 Adult, 1 Child, 3 Infant" in "Passenger" dropdown


  Scenario: Select departure city from autosuggest and destination from dynamic dropdown
    Given I open "Flights booking" page
    When I click on "Departure" dropdown
    Then I see "Departure options list" should be "visible"
    And I click on "Bengaluru" in "Departure options list" list
    Then I see "Arrival options list" should be "visible"
    And I click on "Delhi" in "Arrival options list" list
   # Then I see "Arrival options list" should be "invisible"
   # Then I see "Delhi" in "Arrival" dropdown
    # neviem urobit vseobecne lebo departure aj arrival
    #  options list ma rovnake lokatory - dalo by sa urobit xpath albo css na konkretnu moznost a
    #  vybrat vzdy druhy index a na kazdu moznost vyrobit samostatny step alebo urobit lokator ktory sa bude
    #  vyskladavat dynamicky
    # da sa pouzit cez enumerations vyskladavanie xpathov - pozri cucumber poznamky
@Test
  Scenario: Select dates from Datepicker
    Given I open "Flights booking" page
    When I click on "Round trip" radiobutton
    And I click on "Depart date" datepicker icon
    Then I see "Departure dates options list" should be "visible"
    And I select "March 2023" as a departure month
    And I click on "24" in "Departure dates options list" list
    Then I see "Departure dates options list" should be "invisible"
    Then I see "24/03" in "Departure date" field