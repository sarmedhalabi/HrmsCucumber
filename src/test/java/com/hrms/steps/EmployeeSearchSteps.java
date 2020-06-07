package com.hrms.steps;


import org.junit.Assert;


import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchSteps extends CommonMethods {

//	@Given("user navigated to HRMS")
//	public void user_navigated_to_HRMS() {
//	    setUp();
//	}


	

	@Given("user is logged with valid admin credentials")
	public void user_is_logged_with_valid_admin_credentials() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

	}

	@Given("user navigate to employee list page")
	public void user_navigate_to_employee_list_page() {
		jsClick(dashboard.PIM);
		jsClick(dashboard.empListPage);
	}

	@When("user enter Valid employee id")
	public void user_enter_Valid_employee_id() {
		sendText(viewEmp.empID, "10079");

	}

	@When("click on sarch button")
	public void click_on_sarch_button() {
		jsClick(viewEmp.searchBtn);

	}

	@Then("user see employee information is displayed")
	public void user_see_employee_information_is_displayed() {
		String expectedIdEmployee = "10079";
		String actualIdEmployee = viewEmp.employeeIdValdiaiton.getText();
		Assert.assertEquals("IdEmployee do not match", actualIdEmployee, expectedIdEmployee);
		sleep(2);
		tearDown();

	}
	
	@When("user enter Valid employee name and last name")
	public void user_enter_Valid_employee_name_and_last_name() {
		sendText(viewEmp.empName, "Adhikari");
		sleep(5);}
	
	
	
	@Then("user see employee information name is displayed")
	public void user_see_employee_information_name_is_displayed() {
	  String expectedName="Adhikari";
	  String actualLastName=viewEmp.empLastNameValdiation.getText();
	  Assert.assertEquals("Names do not match",expectedName, actualLastName);
	  tearDown();
		
	}
	

	
}
	
