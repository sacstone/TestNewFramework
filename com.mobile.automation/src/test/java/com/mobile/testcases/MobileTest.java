package com.mobile.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.mobile.pages.HomePage;
import com.mobile.util.TestBase;

import io.appium.java_client.ios.IOSDriver;

public class MobileTest extends TestBase {
	
	//IOSDriver driver;
	
	@Test
	
	public void test1() throws InterruptedException, MalformedURLException{
		
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(2000);
		HomePage hp = new HomePage(driver);
		
		//hp.signIn();
	//	hp.stores();
		hp.search();
		
		
		System.out.println(driver.getCurrentUrl());
		
		
		
		
	}

}
