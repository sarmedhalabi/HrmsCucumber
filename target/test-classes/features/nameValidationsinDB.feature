 Feature:  Name validation against DB
 Scenario: First Name validation against DB

 Given I login successfully to the HRMS applicaiton.
 And navigate to the employee page and click on PIM
 
   When user enter Valid employee id
  And click on sarch button 
  Then verify table is displayed
  And get first name from table
  When get first name  from db
  Then validate first name from the ui against db
 