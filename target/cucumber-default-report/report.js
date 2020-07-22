$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/nameValidationsinDB.feature");
formatter.feature({
  "name": "Name validation against DB",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "First Name validation against DB",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "skipped"
});
formatter.step({
  "name": "I login successfully to the HRMS applicaiton.",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.steps.AddNewEmployee.i_login_successfully_to_the_HRMS_applicaiton()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "navigate to the employee page and click on PIM",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.AddNewEmployee.navigate_to_the_employee_page_and_click_on_PIM()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user enter Valid employee id",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.user_enter_Valid_employee_id()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "click on sarch button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.EmployeeSearchSteps.click_on_sarch_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "verify table is displayed",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "get first name from table",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "get first name  from db",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "validate first name from the ui against db",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "status": "skipped"
});
});