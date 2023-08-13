Feature: Payment

  Scenario: Succes Payment
    Given I open home page of Automation Store, click ona account baner and login with correct credentials login "KonRafal" and password "n8QSi@43HVSF"
    When I go to cattegory -> Apparel & Accessories -> Shoes and click on red sandals
    And I choose size 4 UK, change quantity to "2", click add to cart button, click checkout and confirm order
    Then My order has been processed

