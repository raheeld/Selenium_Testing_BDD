Feature: Test home page

  Background:
    When user is on login page

  Scenario: testing login functionality
    And user enter "Raheel" and "12345"
    And user clicks on login button
    Then user verifies Welcome message with "Raheel"

  Scenario Outline: testing multiple users functionality
    And user enter "<username>" and "<password>"
    And user clicks on login button
    Then user verifies Welcome message with "<username>"

    Examples:
      | username | password |
      | eric     | 12345    |
      | john     | 12345    |
      | sam      | 12345    |

    Scenario: Verify test pro home page
      And user enter "Raheel" and "12345"
      And user clicks on login button
      And user selects country "United States" from dropdown
      And user enters "99 holly" by "#address"
      And user enters "email@gmail.com" by "#email"
      And user enters "2157897890" by "#phone"
      Then user clicks save button and verify message


