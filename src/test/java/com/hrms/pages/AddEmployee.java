package com.hrms.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;

public class AddEmployee extends CommonMethods {
	
	
	@FindBy(css="input#firstName")
	public WebElement firstName;
	
	@FindBy (xpath="//input[@id='middleName']")
	public WebElement middleName;
	
	@FindBy(xpath="//input[@name='lastName']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@id='chkLogin']")
	public WebElement checkLogin;
	
	@FindBy(css="input#user_name")
	public WebElement username;
	
	@FindBy (css="input#user_password")
	public WebElement password;
	
	@FindBy (css="input#re_password")
	public WebElement confirmPassword;
	
	@FindBy (css="input#btnSave")
	public WebElement btnSave;
	
	@FindBy(id="employeeId")
	public WebElement employeeId;
	
	@FindBy (xpath="//div[@id='profile-pic']/h1")
	public WebElement nameDisplayed;
	
	public AddEmployee() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	
	

}
