Feature: Retrieve character information based on their unique identifier

  Scenario: Successfully access details of a specific character
    Given Fred is a Star Wars fan
    When he requests information for the character with identifier 1
    Then he should receive the character info successfully
    And he should see that the character's name is "Luke Skywalker"
