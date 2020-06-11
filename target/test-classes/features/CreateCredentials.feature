@smoke
Feature: Multiple Credentials

  Scenario Outline: Creating multiple credentials
    When user enter valid "<username>" and "<password>"
    And user click on  login button
    Then "<firstname>" is successfully logged in

    Examples: 
      | username | password         | firstname |
      | Admin    | Hum@nhrm123      | Admin     |
      | luffy123   | Syntax123!!       | Luffy  |
     
