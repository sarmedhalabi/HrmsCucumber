Feature: Add New Employee

  Background: 
    Given I login successfully to the HRMS applicaiton.
    And navigate to the employee page and click on PIM
    When click on Add employee

  @smoke
  Scenario: Add new employee first name and last name
    And enter employee first name and last name
    And click on save button
    Then new employee is added successfully

  @smoke
  Scenario: Adding new employee without employee ID
    And enter employee first name and last name
    And delete emplyee Id
    And click on save button
    Then new employee is added successfully

  @smoke
  Scenario: Add new Employee with Login Credentials
    And enter employee first name and last name
    And click on login credential button
    And enter username and password
    And confirm password
    And click on save button
    Then new employee with login credentials should be displayed successfullly

  # to perform Data driven test <ddt> we use scenario outline with Examples
  @inProgress
  Scenario Outline: Adding multiple employees
    When user enter employee "<FirstName>","<MiddleName>" and "<LastName>"
    And click on save button
    Then "<FirstName>","<MiddleName>" and "<LastName>" is added successfully

    Examples: 
      | FirstName | MiddleName | LastName |
      | Faisal    | F          | sahki    |
      | Sarmed    | G          | Halabi   |
      | Yunus     | Emre       | Yaut     |

  # adding multiple employees using cucumber Datatable
  @dataTable
  Scenario: Adding multiple employees
    When user enter employee details and click on save then employee is added
    |FirstName|MiddleName|LastName|
    |John|J| Snith|
    |Jane|J| Snith|

   
