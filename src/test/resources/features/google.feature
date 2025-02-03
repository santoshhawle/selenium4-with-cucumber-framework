Feature: User verify google search

  @google
  Scenario: User verify google search
    Given User is on google search page
    When User search for "Selenium"
    Then User should see the search results

  @google
  Scenario Outline: User verify google search with different products
    Given User is on google search page
    When User search for "<product>"
    Then User should see the search results
    Examples:
      | product   |
      | Selenium  |
      | WebDriver |
      | Cucumber  |