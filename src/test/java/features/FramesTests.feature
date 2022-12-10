Feature: Frames tests

  Scenario: Drag and drop using frames
    Given I open "Jquery" page
    When I switch to "Frame" element
    Then I drag "Draggable" element and drop it into "Droppable" element
    And I wait for "5" seconds
