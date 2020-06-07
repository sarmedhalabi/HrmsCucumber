
@sprint13
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

