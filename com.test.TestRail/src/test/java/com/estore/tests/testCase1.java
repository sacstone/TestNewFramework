package com.estore.tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gurock.testrail.APIException;
import com.gurock.testrail.TestRailCall;




public class testCase1 {
	
	String testCaseID = "164204";
	long getTestRunIdRail3;
	String testResult;
	@BeforeTest
	public void testrail() throws MalformedURLException, IOException, APIException{
		  
		  TestRailCall tc = new TestRailCall();
		  tc.testRailInitialCall();
		  
		//  System.out.println(TesTrunid);
		
	}

	
  @Test
  public void f() throws MalformedURLException, IOException, APIException {
	  
	  System.setProperty("webdriver.chrome.driver",
				"/Users/rameshdhanekula/Downloads/chromedriver");
	  WebDriver d = new ChromeDriver();
	  d.get("http://www.wholefoodsmarket.com");
	  String homepage = "Whole Foods Market";
      String title = d.getTitle();
      System.out.println(title);
	  if (title.equals(homepage)){
		  testResult = "PASSED"; 
		  
	  } else {
		  
		  testResult = "FAILED";
	  }
	  
	  TestRailCall tc = new TestRailCall();
	 System.out.println(getTestRunIdRail3);
	  System.out.println(testCaseID);
	  System.out.println(testResult);
	 tc.addTestResultToTestrail(getTestRunIdRail3, testCaseID, testResult);
	 
	 d.quit();

	  
	  
	  
  }
  
 
}
