Feature: Search for a planet by name

  Scenario: Successfully search for a planet by its name
    Given Fred is a Star Wars fan
    When the user requests information for the planet "Alderaan"
    Then the successful response should contain a list of planets
    And the "name" field of the first planet in the list should be "Alderaan"
