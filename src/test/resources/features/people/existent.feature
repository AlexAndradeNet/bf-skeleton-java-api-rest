Feature: Retrieve character information based on their unique identifier

  Scenario: Successfully access details of a specific character
    Given Fred is a Star Wars fan
    When the user requests information for the character with identifier 1
    Then the character info should be retrieved successfully
    And the name of the character should be "Luke Skywalker"
