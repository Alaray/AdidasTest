Feature: Weather

  Scenario Outline: Check weather in cities
    Given I am at google search
    When I search for "weather.com"
    And Click on correct site in search results
    Then Site "https://weather.com/" is opened
    When "<City>" city entered in search
    Then Dropdown with suggestions appear
    When "<City>" city is chosen
    Then Weather for the "<City>" city appear
    Examples:
      | City |
      | Atlanta |
      | Huston |
      | Los Angeles |
      | New York |