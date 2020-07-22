package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.hrms.utils.CommonMethods;



import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoLogin extends CommonMethods {

	@When("User enter valid {string} and {string}")
	public void user_enter_valid_and(String string, String string2) {
		sendText(sauceLogin.userName, string);
		sendText(sauceLogin.password, string2);
		click(sauceLogin.LoginBTN);
		sleep(2);
	}

	@Then("User does the {string} for login fucntionality")
	public void user_does_the_for_login_fucntionality(String string) {
		String actual = sauceLogin.productLogo.getText();
		String expected = string;
		Assert.assertEquals("Message do not match", expected, actual);

	}
	@When("User enter valid username and password and Validation is successfull")
	public void user_enter_valid_username_and_password_and_Validation_is_successfull(DataTable dataTable) {
	    List<Map<String,String>> sauceDemo= dataTable.asMaps();
	    for(Map<String,String> map: sauceDemo) {
	    	sendText(sauceLogin.userName, map.get("Username"));
	    	sendText(sauceLogin.password, map.get("Password"));
	    	jsClick(sauceLogin.LoginBTN);
	    	String expected= map.get("Validation");
	    	String actual= sauceLogin.productLogo.getText();
	    	Assert.assertEquals("Mesage do not match", expected, actual);
	    	driver.findElement(By.cssSelector("div[class=bm-burger-button]")).click();
	    	sleep(2);
	    	driver.findElement(By.xpath("//nav[@class='bm-item-list']/a[3]")).click();
	    	
	    	
	    	
	    }
	
	
	}



		
	
	
	}


	
			
			
		




