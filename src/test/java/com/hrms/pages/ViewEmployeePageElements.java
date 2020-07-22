package com.hrms.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;

public class ViewEmployeePageElements extends CommonMethods {
	@FindBy(id = "empsearch_employee_name_empName")
	public WebElement empName;

	@FindBy(id = "empsearch_id")
	public WebElement empID;

	@FindBy(id = "searchBtn")
	public WebElement searchBtn;

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr")
	public List<WebElement> employeeTableRow;

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[2]")
	public WebElement employeeIdValdiaiton;

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[4]")
	public WebElement empLastNameValdiation;

	@FindBy(xpath = "//ul[@id='sidenav']/li")
	public List<WebElement> employeeList;

	@FindBy(xpath ="//table[@id='resultTable']")
	public WebElement employeesTable;

	public boolean isTableDisplayed() {
		return employeesTable.isDisplayed();
	}

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[3]")
	public List<WebElement> tableFirstName;

	public List<Map<String, String>> getFirstNameFromTable() {
		List<Map<String, String>> uiName = new ArrayList<>();
		for (WebElement row : tableFirstName) {
			Map<String, String> storeUiNames = new LinkedHashMap<>();
			String tableName = row.getText();
			storeUiNames.put("emp_firstname", tableName);
			uiName.add(storeUiNames);
		}
		return uiName;
	}

	public ViewEmployeePageElements() {
		PageFactory.initElements(driver, this);
	}

	public void chooseEmp(String expectedId) {

		boolean flag = false;
		while (!flag) {
			for (int i = 1; i < employeeTableRow.size(); i++) {
				String rowText = employeeTableRow.get(i - 1).getText();
				if (rowText.contains(expectedId)) {
					flag = true;
					driver.findElement(By.xpath("/table[@id='resultTable']/tbody/tr[" + i + "]/td[1]")).click();
					sleep(2);
					driver.findElement(By.cssSelector("input#btnDelete")).click();
					sleep(2);
					break;
				}

			}

		}
	}

	public void employeeList(String text) {
		for (WebElement lists : employeeList) {
			String actual = lists.getText();
			if (actual.equals(text)) {
				jsClick(lists);
				break;
			}
		}

	}

}
