Feature: Testing Login feature

  Scenario: Testing login feature
    Given user on login page
    And user click on "Auto + Renters"
    And user enter ZIPCODE "19056"
    And user click on Start a quote button
    Then user land on Welcome page
