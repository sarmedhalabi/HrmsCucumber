@inTesting
Feature: Multiple Credentials

  Scenario Outline: Creating multiple credentials
    When user enter valid "<username>" and "<passowrd>"
    And user click on  login button
    Then "<firstname>" is successfully logged in

    Examples: 
      | username | password         | firstname |
      | Admin    | Hum@nhrm123      | Admin     |
      | abd77    | Syntax123!       | Abdullah  |
      | Mahady   | Mahady@Rayham123 | John      |
