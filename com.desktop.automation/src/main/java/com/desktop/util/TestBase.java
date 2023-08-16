package com.desktop.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;



public class TestBase {

	protected WebDriver driver;

	protected static Properties testConfig;

	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException{
		
		testConfig = new Properties();
		testConfig.load(new FileInputStream("TestConfig.properties"));
		


	}
	
	@BeforeMethod
	public void beforeMethod() throws FileNotFoundException, IOException {

		Reporter.log("===Browser Session Started===", true);
		driver = WebDriverHelper.createDriver(testConfig.getProperty("browser"));

		driver.get(testConfig.getProperty("baseUrl"));

		Reporter.log("===Application started===", true);

	}


	@AfterMethod

	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {

			CaptureScreenshots.captureScreenshot(driver, result.getName());
		}

		WebDriverHelper.quitDriver(driver);

		Reporter.log("===Browser Session End===", true);
	}

}
