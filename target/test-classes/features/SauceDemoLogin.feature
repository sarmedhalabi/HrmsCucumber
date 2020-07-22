#Author: sarmedhalabi@syntax.com
Feature: SauceDemoLogin
  
  Description: User enter valid username and password and validating successfull login to SauceDemo 
               applicaiton

  Scenario Outline: validating login functionality for SauceDemo application.
    When User enter valid "<Username>" and "<Password>"
    Then User does the "<Validation>" for login fucntionality

    Examples: 
      | Username                | Password     | Validation |
      | standard_user           | secret_sauce | Products   |
      | performance_glitch_user | secret_sauce | Products   |
      | problem_user            | secret_sauce | Products   |

  Scenario: login functionality for DemoSauce applicaiton 
    When User enter valid username and password and Validation is successfull
      | Username                | Password     | Validation |
      | standard_user           | secret_sauce | Products   |
      | performance_glitch_user | secret_sauce | Products   |
      | problem_user            | secret_sauce | Products   |
