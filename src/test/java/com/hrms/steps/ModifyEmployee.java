package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;


import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ModifyEmployee extends CommonMethods {
	@Given("user login successfully to Hrms Applicaton")
	public void user_login_successfully_to_Hrms_Applicaton() {

		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		jsClick(login.loginBtn);
		sleep(2);
	}

	@Given("user navigate to the employee page")
	public void user_navigate_to_the_employee_page() {
		jsClick(dashboard.PIM);
		jsClick(dashboard.addEmp);
		sleep(2);
	}

	@When("user add employee and employee is displayed successfully")
	public void user_add_employee_and_employee_is_displayed_successfully(DataTable dataTable) {
		List<Map<String, String>> addEmployee = dataTable.asMaps();
		for (Map<String, String> map : addEmployee) {

			sendText(addEmp.firstName, map.get("FirstName"));
			sendText(addEmp.middleName, map.get("MiddleName"));
			sendText(addEmp.lastName, map.get("LastName"));

			jsClick(addEmp.btnSave);
			String expected = map.get("FirstName") + " " + map.get("MiddleName") + " " + map.get("LastName");
			String actual = addEmp.nameDisplayed.getText();
			Assert.assertEquals("Name doest not match", expected, actual);

		}

	}

	@When("user modify employee")
	public void user_modify_employee(DataTable dataTable) {

		List<Map<String, String>> modifyEmployee = dataTable.asMaps();
		for (Map<String, String> map : modifyEmployee) {
			click(pdetails.EditButton);// go edit the page
			sendText(pdetails.DriverLicense, map.get("DriverLiscense"));
			sendText(pdetails.LicenseExpiryDate, map.get("ExpirationDate"));
			sendText(pdetails.SSN, map.get("SSN"));
			driver.findElement(By.cssSelector("input#personal_optGender_1")).click();
		
			selectValue(pdetails.MartialStatus, map.get("MartialStatus"));
			selectValue(pdetails.nationalityDD, map.get("Nationality"));
			sendText(pdetails.dateOfBirth, map.get("DOB"));

			sendText(pdetails.NickName, map.get("NickName"));
			jsClick(pdetails.Smoker);
			if (pdetails.Smoker.isEnabled()) {
				jsClick(pdetails.EditButton);
				sleep(5);
				

			}
			sleep(2);
			
		}
	}
}
