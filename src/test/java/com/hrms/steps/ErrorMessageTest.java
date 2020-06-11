package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ErrorMessageTest extends CommonMethods {

	@When("user enter valid username and inalid password")
	public void user_enter_valid_username_and_inalid_password() {
		sendText(login.username, "Admin");
		sendText(login.password, "helllo");

	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		jsClick(login.loginBtn);

	}

	@Then("user should see {string} error message displayed")
	public void user_should_see_error_message_displayed(String string) {
		String actualtext = login.errorMsg.getText();
		Assert.assertEquals(string, actualtext);
		
	}

	@When("user enter valid username and leave password empty")
	public void user_enter_valid_username_and_leave_password_empty() {
		sendText(login.username, "Admin");

	}

	@When("user enter valid password and leave username empty")
	public void user_enter_valid_password_and_leave_username_empty() {
		sendText(login.password, "Hum@nhrm123");

	}

	@When("user enter {string} and {string}")
	public void user_enter_and(String string, String string2) {
		sendText(login.username, string);
		sendText(login.password, string2);

	}

	@Then("{string} is displayed")
	public void is_displayed(String string) {

		String actual = login.errorMsg.getText();

		Assert.assertEquals("ErrorMessage doest not match", string, actual);

	}

	@When("user check username and password then errorMessage is dispalyed correctly")
	public void user_check_username_and_password_then_errorMessage_is_dispalyed_correctly(DataTable dataTable) {
		List<Map<String, String>> errormessageDispaly = dataTable.asMaps();
		for (Map<String, String> map : errormessageDispaly) {
			String username = map.get("Username");
			String password = map.get("Password");

			sendText(login.username, username);
			sendText(login.password, password);
			jsClick(login.loginBtn);
			String actual = login.errorMsg.getText();
			String expected = map.get("ErrorMessage");

			Assert.assertEquals("ErrorMessage does not match", expected, actual);
			sleep(2);

		}

	}

}
