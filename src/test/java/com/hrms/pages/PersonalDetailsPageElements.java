package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class PersonalDetailsPageElements extends CommonMethods {

	@FindBy(id = "personal_cmbNation")
	public WebElement nationalityDD;

	@FindBy(css="input[type='radio']")
	public List<WebElement> genderRadioGroup;
	
	@FindBy(id = "personal_txtLicenNo")
	public WebElement DriverLicense;

	@FindBy(id = "personal_txtLicExpDate")
	public WebElement LicenseExpiryDate;
	
	@FindBy(id = "personal_cmbMarital")
	public WebElement MartialStatus;

	@FindBy(id = "personal_DOB")
	public WebElement dateOfBirth;

	@FindBy(css = "input#personal_chkSmokeFlag")
	public WebElement Smoker;
	
	@FindBy(id = "personal_txtEmpNickName")
	public WebElement NickName;
	
	@FindBy(id="personal_txtMilitarySer")
	public WebElement MilitaryService;
	
	@FindBy(id="personal_txtNICNo")
	public WebElement SSN;
	
	@FindBy(id="btnSave")
	public WebElement EditButton;
	
	
	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);


	
	
		
	}
	
}
