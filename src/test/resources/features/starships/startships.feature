Feature: List all starships

  Scenario: Successfully retrieve a list of starships
    Given Fred is a Star Wars fan
    When the user requests information about all starships
    Then the successful response should contain a list of starships
    And the response should include pagination properties "next" and "previous"
