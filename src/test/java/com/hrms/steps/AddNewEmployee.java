package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.pages.AddEmployee;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddNewEmployee extends CommonMethods{
	
	@Given("I login successfully to the HRMS applicaiton.")
	public void i_login_successfully_to_the_HRMS_applicaiton() {
	    sendText(login.username,ConfigsReader.getProperty("username"));
	    sendText(login.password, ConfigsReader.getProperty("password"));
	    click(login.loginBtn);
	    sleep(2);
	}

	@Given("navigate to the employee page and click on PIM")
	public void navigate_to_the_employee_page_and_click_on_PIM() {
	    jsClick(dashboard.PIM);
	}

	@When("click on Add employee")
	public void click_on_Add_employee() {
	    jsClick(dashboard.addEmp);
	}

	@When("enter employee first name and last name")
	public void enter_employee_first_name_and_last_name() {
	   sendText(addemployee.firstName, "Davis");
	   sendText(addemployee.lastName,"Beckham");
	   
	}

	@When("click on save button")
	public void click_on_save_button() {
	    jsClick(addemployee.btnSave);
	    sleep(2);
	}

	@Then("new employee is added successfully")
	public void new_employee_is_added_successfully() {
	    String expectedName="Davis Beckham";
	    String actualName= addemployee.nameDisplayed.getText();
	    Assert.assertEquals("Names do not match", expectedName, actualName);
	  
	    
	}

	@When("delete emplyee Id")
	public void delete_emplyee_Id() {
	    addemployee.employeeId.clear();
	    sleep(2);
	}
	
	@When("click on login credential button")
	public void click_on_login_credential_button() {
	  click(addemployee.checkLogin);
	}

	@When("enter username and password")
	public void enter_username_and_password() {
	    sendText(addemployee.username, "davidbeckham23");
	    sendText(addemployee.password, "Hum@nhrm123!!!");
	}

	@When("confirm password")
public void confirm_password() {
	   sendText(addemployee.confirmPassword, "Hum@nhrm123!!");
	}

	@Then("new employee with login credentials should be displayed successfullly")
	public void new_employee_with_login_credentials_should_be_displayed_successfullly() {
		String expectedName="Davis Beckham";
	    String actualName= addemployee.nameDisplayed.getText();
	    Assert.assertEquals("Names do not match", expectedName, actualName);
	}
	
	
	@When("user enter employee {string},{string} and {string}")
	public void user_enter_employee_and(String fName, String mName, String lName) {
	   sendText(addemployee.firstName, fName);
	   sendText(addemployee.lastName, mName);
	   sendText(addemployee.lastName, lName);
	}

	@Then("{string},{string} and {string} is added successfully")
	public void and_is_added_successfully(String string, String string2, String string3) {
	    System.out.println(" employee is added");
	    sleep(2);
	}
	
	
	@When("user enter employee details and click on save then employee is added")
	public void user_enter_employee_details_and_click_on_save(DataTable dataTable) {
	   List<Map<String,String>>addEmployeeList= dataTable.asMaps();
	   for(Map<String,String> map:addEmployeeList) {
		 String fname=map.get("FirstName");
		 String mname=map.get("MiddleName");
		 String lname=map.get("LastName");
		 
		  sendText(addemployee.firstName, fname);
		  sendText(addemployee.lastName, lname);
		  sendText(addemployee.middleName, mname);
		  click(addemployee.btnSave);
		   //adding assertion
		  String actual= addemployee.nameDisplayed.getText();
		  String expected=fname+ " "+mname+" "+lname;
		  Assert.assertEquals("Employee is not added successfully", expected, actual);
		  jsClick(dashboard.addEmp);
		  sleep(3);
		  
	   }
	   
	   
	}
	public void employee_is_added() {
		System.out.println("employee is added");}
		
		@When("user import excel sheet {string} to add new employee")
		public void user_import_excel_sheet_to_add_new_employee(String string) {
			List<Map<String,String>> excelmap=ExcelUtility.excelIntoListOfMaps(Constants.TESTDATA_FILEPATH, string);
			for(Map<String,String> map:excelmap) {
				
				sendText(addEmp.firstName, map.get("FirstName"));
				sendText(addEmp.middleName, map.get("MiddleName"));
				sendText(addEmp.lastName, map.get("LastName"));
				jsClick(addEmp.btnSave);
				jsClick(dashboard.addEmp);
				sleep(2);
		   
		}}

		@Then("new employee is displayed")
		public void new_employee_is_displayed() {
			System.out.println(" employee is added");
		    
		}



	    
	}


	












