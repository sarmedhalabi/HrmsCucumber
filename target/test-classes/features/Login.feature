@sprint12
Feature: Error Message Test

  Scenario: Error message validation with valid username and invalid passoword
    When user enter valid username and inalid password
    And user click on login button
    Then user should see "Invalid credentials" error message displayed

  Scenario: Error message valditation with valid username and empty password
    When user enter valid username and leave password empty
    And user click on login button
    Then user should see "Password cannot be empty" error message displayed

  Scenario: Error message valditation with valid password and empty username
    When user enter valid password and leave username empty
    And user click on login button
    Then user should see "Username cannot be empty" error message displayed

  @smoke
  Scenario Outline: 
    When user enter "<Username>" and "<Password>"
    And user click on login button
    Then "<ErrorMessage>" is displayed

    Examples: 
      | Username | Password    | ErrorMessage             |
      | Admin    | Hum@nhrm234 | Invalid credentials      |
      | Admin    |             | Password cannot be empty |
      |          | Hum@nhrm123 | Username cannot be empty |

  @Regression
  Scenario: Error Meesage validation
    When user check username and password then errorMessage is dispalyed correctly
      | Username | Password    | ErrorMessage        |
      | Admin    | Hum@nhrm234 | Invalid credentials |
      | Admin    | dadad       | Invalid credentials |
      | xza      | Hum@nhrm123 | Invalid credentials |
