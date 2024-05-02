Feature: Search for a planet by name

  Scenario: Successfully search for a planet by its name
    Given Fred is a Star Wars fan
    When he requests information for the planet "Alderaan"
    Then he should receive a successful response containing a list of planets
    And he should see that the name of the first planet listed is "Alderaan"
