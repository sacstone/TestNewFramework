package com.estore.tests;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.estore.util.CaptureScreenshots;
//import com.test1.pages.HomePage;
import com.estore.util.DataDrivenHelper;
import com.estore.util.WebDriverHelper;

public class TestBase 
{
	  protected WebDriver driver;
	//  protected HomePage homePage;
	  protected Properties testConfig;
	  
	  @BeforeSuite
	  public void beforeSuite() throws FileNotFoundException, IOException
	  {
		  testConfig = new Properties();
		  testConfig.load(new FileInputStream("TestConfig.properties"));
	  }

	  @BeforeMethod
	  public void beforeMethod() 
	  {
			
		  driver = WebDriverHelper.createDriver(testConfig.getProperty("browser"));
		 
		  driver.get(testConfig.getProperty("baseUrl"));
		  
		//  homePage = new HomePage(driver);
	  }
	  

	  @DataProvider
	  public Object[][] dataProvider(Method method)
	  {
		DataDrivenHelper ddh = new DataDrivenHelper(testConfig.getProperty("mastertestdatafile"));
			
		Object[][] testData= ddh.getTestCaseDataSets(testConfig.getProperty("testdatasheet"), method.getName());
		
		return testData;
			
	  }
	  
/*	  @AfterMethod
	  public void afterMethod() 
	  {
		  WebDriverHelper.quitDriver(driver);
	  }*/
	  
	  @AfterMethod
	  public void tearDown(ITestResult result) 
	  {
		  if(ITestResult.FAILURE == result.getStatus()){
			  
			  CaptureScreenshots.captureScreenshot(driver, result.getName());
		  }
		  
		  WebDriverHelper.quitDriver(driver);
	  }
}
