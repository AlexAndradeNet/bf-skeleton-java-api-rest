Feature: Inform the user when a character does not found

  Scenario: The user should be informed when a character does not found
    Given Fred is a Star Wars fan
    When the user requests information for the character with identifier 0
    Then the user should be informed that the character does not found
