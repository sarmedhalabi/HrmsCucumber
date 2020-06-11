package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;


public class InvalidCredentials extends CommonMethods {
	
	@When("user enter invalid username and password and see error message")
	public void user_enter_invalid_username_and_password_and_see_error_message(DataTable dataTable) {
		
		List<Map<String,String>> invalidCredentials= dataTable.asMaps();
		for(Map<String,String> map:invalidCredentials) {
			String username= map.get("Username");
			String password= map.get("Password");
			String expected= map.get("ErrorMessage");
			sendText(login.username,username);
			sendText(login.password, password);
			click(login.loginBtn);
			sleep(2);
			String actual= login.errorMsg.getText();
			Assert.assertEquals("ErrorMessage do not match", expected, actual);
			sleep(2);
			
			
		}
		
	   
	}
	
	
	@When("user enters invalid username and password and see error message")
	public void user_enters_invalid_username_and_password_and_see_error_message(DataTable dataTable) {
	   List<List<String>> invalidCredentials= dataTable.asLists();
	   for(List<String> list:invalidCredentials) {
		   sendText(login.username, list.get(0));
		   sendText(login.password, list.get(1));
		   click(login.loginBtn);
		   String expected= list.get(2);
		   String actual= login.errorMsg.getText();
		   Assert.assertEquals("Message do not matach", expected, actual);
		   sleep(2);
	   }
	
	
	
	
	}




}
