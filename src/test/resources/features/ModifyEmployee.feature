#Author: sarmedhalabi@Syntax.com
@ModifyEmployee
Feature: Add and Modify Employe

  Background: 
    Given user login successfully to Hrms Applicaton
    And user navigate to the employee page
    @Regression
  Scenario: Add Employee
    When user add employee and employee is displayed successfully
      | FirstName | MiddleName | LastName |
      | Gold      | D          | Roger    |
    Then user modify employee
      | DriverLiscense | ExpirationDate | SSN           | MartialStatus | Nationality | DOB         | NickName |
      | B3434343       | 2022-Aug-03    | 345-434-43433 | Single        | Syrian      | 1965-Aug-23 | Luffy    |
