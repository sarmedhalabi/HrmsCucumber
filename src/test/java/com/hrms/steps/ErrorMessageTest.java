package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Given;
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
		String actualtext= login.errorMsg.getText();
		Assert.assertEquals(string, actualtext);
	    TakesScreenshot("ErrorMessage");
	}

	@When("user enter valid username and leave password empty")
	public void user_enter_valid_username_and_leave_password_empty() {
		sendText(login.username,"Admin");
		
	   
	}

	@When("user enter valid password and leave username empty")
	public void user_enter_valid_password_and_leave_username_empty() {
		sendText(login.password, "Hum@nhrm123");
	   
	}



	

}
