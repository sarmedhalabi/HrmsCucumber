package com.hrms.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver setUp() {
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		switch (ConfigsReader.getProperty("browser").toLowerCase()) {

		case "chrome":
			//System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			//System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported");
		}

		driver.get(ConfigsReader.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getProperty("url"));
		PageInitializer.initialize(); // initialize all page objects as part of setup
		return driver;
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
