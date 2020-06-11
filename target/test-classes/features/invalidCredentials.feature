Feature: Invalid Credentials

  Scenario: Login with invalid credentials
    When user enter invalid username and password and see error message
      | Username | Password   | ErrorMessage        |
      | Admin    | Admin123   | Invalid Credentials |
      | Hello    | Syntax123! | Invalid Credentials |
@smoke
  Scenario: Login with Invalid credentials
    When user enters invalid username and password and see error message
      | Admin | Admin123   | Invalid credentials |
      | Hello | Syntax123! | Invalid credentials |
      
      
