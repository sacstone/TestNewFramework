package com.estore.util;

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

import com.estore.util.CaptureScreenshots;
//import com.test1.pages.HomePage;
import com.estore.util.DataDrivenHelper;
import com.estore.util.WebDriverHelper;

public class TestBase1 {

	protected WebDriver driver;

	protected static Properties testConfig1;

	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException {
		
		testConfig1 = new Properties();
		testConfig1.load(new FileInputStream("TestConfig1.properties"));

	}
	
	@BeforeMethod
	public void beforeMethod() throws FileNotFoundException, IOException {

		Reporter.log("===Browser Session Started===", true);
		driver = WebDriverHelper.createDriver(testConfig1.getProperty("browser"));

		driver.get(testConfig1.getProperty("baseUrl"));

		Reporter.log("===Application started===", true);

	}

	@DataProvider
	public Object[][] dataProvider(Method method) {
		DataDrivenHelper ddh = new DataDrivenHelper(testConfig1.getProperty("mastertestdatafile"));

		Object[][] testData = ddh.getTestCaseDataSets(testConfig1.getProperty("testdatasheet"), method.getName());

		return testData;

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
