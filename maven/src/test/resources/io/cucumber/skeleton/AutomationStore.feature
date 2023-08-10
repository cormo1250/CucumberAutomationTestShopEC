Feature: login

  Scenario: Correct Credentials
    //Given Open browser
    And I open login page Automation Store
    When I click on account baner
    And I type "KonRafal" as login in login page
    And I type "n8QSi@43HVSF" as password in login page
    And i click Login button
    Then I'm logged in