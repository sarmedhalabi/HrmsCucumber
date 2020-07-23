Feature: Employee Search
@Runner
  Scenario: Search employee by id
   
    And user is logged with valid admin credentials
    And user navigate to employee list page
    When user enter Valid employee id
    And click on sarch button
    Then user see employee information is displayed

  Scenario: Search employee by name
  
    And user is logged with valid admin credentials
    And user navigate to employee list page
    When user enter Valid employee name and last name
    And click on sarch button
    Then user see employee information name is displayed
