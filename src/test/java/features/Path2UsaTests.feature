Feature: Path2Usa Tests

  Scenario: Select date from datepicker
    Given I open "Path2Usa" page
    When I click on "Date of travel" field
    Then I see "Datepicker" element should be "visible" on Path2Usa page
   And I select "2023" as a departure year on Path2Usa page
    And I select "September" as a departure month on Path2Usa page
    And I wait for "4" seconds
    And I select "22" as a departure day
    Then I see "Date of travel" field should have value "09/22/2023"

    #page ocividne nezvlada automatizaciu - v debugu a obcas funguje korektne, na chrome nefunguje ani scrollIntoView