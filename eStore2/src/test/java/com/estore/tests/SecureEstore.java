package com.estore.tests;

import org.testng.annotations.Test;

import com.estore.pages.HomePage;
import com.estore.util.TestBase;
import com.estore.util.TestBase1;

public class SecureEstore extends TestBase1{
	
	@Test 
	
	public void testSSL()
	{
		//driver.get("http://www.wholefoodsmarket.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		HomePage hp = new HomePage(driver);
		hp.shopOnline().clear();
		
		
		
	}
	

}
