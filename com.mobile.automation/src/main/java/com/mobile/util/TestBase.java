package com.mobile.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.ios.IOSDriver;

public class TestBase {

	protected IOSDriver driver;

	@BeforeMethod
	public void beforeMethod() throws FileNotFoundException, IOException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "iPhone 6s");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "10.3");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "safari");
		driver = new IOSDriver(new URL("http://127.0.01:4723/wd/hub"), capabilities);

		driver.get("http://www.wholefoodsmarket.com/");
		Thread.sleep(2000);

		Reporter.log("===Application started===", true);

	}



	
}
