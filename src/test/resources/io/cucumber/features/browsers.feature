Feature: Browsers

  Scenario Outline: launch browsers
    Given The <browser> driver is present
    When I launch the <browser> browser
    Then Browser should be opened
    Examples:
      | browser |
      | chrome |
      | firefox |
