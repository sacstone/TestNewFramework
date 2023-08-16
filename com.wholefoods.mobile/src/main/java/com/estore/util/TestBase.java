package com.estore.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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

/*import com.estore.util.CaptureScreenshots;
//import com.test1.pages.HomePage;
import com.estore.util.DataDrivenHelper;
import com.estore.util.WebDriverHelper;
import com.gurock.testrail.APIException;
import com.gurock.testrail.TestRailCall;*/

import io.appium.java_client.ios.IOSDriver;

public class TestBase {

//	protected WebDriver driver;
	protected IOSDriver driver;

	protected static Properties testConfig;


	
	@BeforeMethod
	public void beforeMethod() throws FileNotFoundException, IOException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "iPhone 6s");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "10.3");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "safari");
		driver = new IOSDriver(new URL("http://127.0.01:4723/wd/hub"), capabilities);

		//driver.get(testConfig.getProperty("baseUrl"));
		//driver.get("http://stage.wholefoodsmarket.com/shop/xox");
		driver.get("http://d.wholefoodsmarket.com/signin");
		Thread.sleep(2000);
		
		//driver.
		//driver.findElement)

		Reporter.log("===Application started===", true);

	}



	
}
