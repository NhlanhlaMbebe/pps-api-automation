Feature: Character
  Scenario: All Characters
    Given I have an endpoint "https://www.breakingbadapi.com/api/characters"
    When I get characters
    Then I display them

  Scenario: Display Walter White's Birthday
    Given I have an endpoint "https://www.breakingbadapi.com/api/characters/1"
    When I get characters
    Then I display birthday
