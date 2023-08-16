package com.estore.testcases;

import org.testng.annotations.Test;

import com.estore.util.TestBase;
import com.estore.pages.Coupons;
import com.estore.pages.HomePage;

public class Login extends TestBase {
	
	@Test
	
	public void signIn() throws InterruptedException{
		
		HomePage home = new HomePage(driver);
		
		home.email().sendKeys("ramesh@d8testing.com");
		home.password().sendKeys("D8Testing");
		home.signInButton().click();
		
		Coupons c = new Coupons(driver);
		Thread.sleep(3000);
		c.signOut().click();;
		
		
	}

}
