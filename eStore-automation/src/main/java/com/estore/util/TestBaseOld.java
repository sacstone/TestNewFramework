package com.estore.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
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
import com.gurock.testrail.APIException;
import com.gurock.testrail.TestRailManager;

public class TestBaseOld {

	protected WebDriver driver;

	protected static Properties testConfig;

	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException {
		
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

	@DataProvider
	public Object[][] dataProvider(Method method) {
		DataDrivenHelper ddh = new DataDrivenHelper(testConfig.getProperty("mastertestdatafile"));

		Object[][] testData = ddh.getTestCaseDataSets(testConfig.getProperty("testdatasheet"), method.getName());

		return testData;

	}

	@AfterMethod

	public void tearDown(ITestResult result) throws MalformedURLException, IOException, APIException {
		if (ITestResult.FAILURE == result.getStatus()) {

			CaptureScreenshots.captureScreenshot(driver, result.getName());
	
			
		}
		
	
		WebDriverHelper.quitDriver(driver);

		Reporter.log("===Browser Session End===", true);
	}

}
