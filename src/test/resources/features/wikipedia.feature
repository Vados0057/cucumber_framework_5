Feature: Wikipedia Search

  Background:
    Given user navigates to "https://www.wikipedia.org/"


  Scenario: Validate Search
    When user searches for "Elon Musk" on Wikipedia
    Then user should see "Elon Musk" in the title
    And user should see "Elon Musk" in the url
    And user should see "Elon Musk" in the first heading