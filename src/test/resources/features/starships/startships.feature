Feature: List all starships

  Scenario: Successfully retrieve a list of starships
    Given Fred is a Star Wars fan
    When he requests information about all starships
    Then he should receive a successful response containing a list of starships
    And he should be able to explore the information through the "next" and "previous" pagination properties
