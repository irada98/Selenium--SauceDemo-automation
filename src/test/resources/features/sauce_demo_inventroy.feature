Feature: Sauce Demo inventory page

  Scenario: User logged in sauce demo page and then logged out
    Given user opens main page
    When user logs in with credentials: "standard_user" and "secret_sauce"
    Then user logging out

#  Scenario: User adding item to shopping cart
