package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MultipleCredentials extends CommonMethods {
	
	@When("user enter valid {string} and {string}")
	public void user_enter_valid_and(String string, String string2) {
	    sendText(login.username,string);
	    sendText(login.password, string2);
	}

	@When("user click on  login button")
	public void user_click_on_login_button() {
	   jsClick(login.loginBtn);
	   sleep(2);
	}

	@Then("{string} is successfully logged in")
	public void is_successfully_logged_in(String string) {
	   String actual= login.welcomeDisplayed.getText();
	   String expected= "Welcome "+string;
	   Assert.assertEquals("names do not match", expected, actual);
	}
	




}
