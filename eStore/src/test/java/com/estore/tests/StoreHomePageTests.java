package com.estore.tests;

import org.testng.annotations.Test;

import com.estore.pages.StoreHomePage;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class StoreHomePageTests {
	
	private WebDriver driver;

  @BeforeMethod
  public void beforeMethod() 
  {
	  
	  	//System.setProperty("webdriver.chrome.driver", "/Users/rameshdhanekula/Downloads/chromedriver");
	  	System.setProperty("webdriver.chrome.driver", "/Users/rameshdhanekula/Downloads/chromedriver");
		
	  	driver = new ChromeDriver();
	//	driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://stage.wholefoodsmarket.com/shop/xox");  
	  
  }
  
//  @Test
//  public void testCategory() 
//  {
//	  
//	  StoreHomePage store = new StoreHomePage(driver);
//	  
//	  store.clickCategory()
//	     .clickItem()
//	     .addToCart()
//	     .clickCheckout();
//	  
//	  
//  }
//  
  @Test
  public void bottmNav()
  {
	  StoreHomePage store = new StoreHomePage(driver);
	  
	  String healthyEating = store.healthEatingLink();
	  
	  Assert.assertTrue(healthyEating.contains("Healthy Eating"), "Link Text is not right");
	  
  }
  
  
  @Test
  public void testCategory() 
  {
	  
	  /*StoreHomePage store = new StoreHomePage(driver);
	  store.clickCategory()
	  		.clickItem()
	  		.addToCart()
	  		.clickCheckout()
	  		.proceedToCheckout()
	  		.clickOnContinue();*/
	  		
		  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  
  }

}
