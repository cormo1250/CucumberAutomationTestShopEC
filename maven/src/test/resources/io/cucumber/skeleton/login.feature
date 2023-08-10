Feature: login

  Scenario: Correct Credentials
    Given Open browser
    And   I open login page
    When  I type "tomsmith" as login
    And   I type "SuperSecretPassword!" as password
    And   I click login button
    Then  I'm logged in

  Scenario: Incorrect Credentials
    Given Open browser
    And   I open login page
    When  I type "tomsmith" as login
    And   I type "SuperSecretPassword!!" as password
    And   I click login button
    Then  I'm not logged in

  Scenario Outline: Check Credentials
    Given I open login page
    When I type "<login>" and "<password>"
    Then <expectedResult>
    Examples:
      | login    | password             | expectedResult     |
      | tomsmith | SuperSecretPassword! | I am logged in     |
      | tomsmith | incorrectpassword    | I am NOT logged in |