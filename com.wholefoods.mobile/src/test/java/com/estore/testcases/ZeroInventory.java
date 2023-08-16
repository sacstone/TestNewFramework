package com.estore.testcases;
import org.testng.annotations.Test;

import com.estore.pages.ProductDetailsPage;
import com.estore.pages.StoreHomePage;
//import com.estore.pages.Cart;
//import com.estore.pages.CategoryPage;
//import com.estore.pages.CheckOutStepOne;
//import com.estore.pages.CheckOutStepTwo;
//import com.estore.pages.CheckOutStepThree;
//import com.estore.pages.OrderConfirmation;
//import com.estore.pages.PageBase;
//import com.estore.pages.ProductDetailsPage;
//import com.estore.pages.StoreHomePage;
//import com.estore.util.StringHandling;
import com.estore.util.TestBase;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;


public class ZeroInventory extends TestBase {

	private float subTotalOnReviewPage;
	private float taxOnReviewPage;
	private float eTotalOnReviewPage;
	private float taxOnConfirmationPage;



	@Test(description = "ZeroInventory")
	public void zeroInventory()
			throws ParseException, InterruptedException, MalformedURLException, IOException {


		
	StoreHomePage shp = new StoreHomePage(driver);

		swipe11(100, 465, 100, 700, 2000);
		Thread.sleep(2000);
		//shp.ca
		shp.clickCategory("Catalog I").selectProduct("IN-0");
		
		Thread.sleep(2000);

		ProductDetailsPage sp = new ProductDetailsPage(driver);

		String devliveryMessage = "Delivery options are available for this item.";

		// step3

		Assert.assertTrue(sp.addToCartButton().getText().contentEquals("SOLD OUT ONLINE"));


		Assert.assertTrue(sp.callStoreMessage().contains("Please call the store at 5125551234 to check availability."));

		Assert.assertTrue(sp.delivryOptionsMessage().equals(devliveryMessage), "Did not find message");

	}
	
	public void swipe11(int swipe_start_x, int swipe_start_y, int swipe_end_x, int swipe_end_y, int duration) {
		int x = swipe_start_x;
		int y = swipe_start_y;
		int x_travel = swipe_end_x - swipe_start_x;
		int y_travel = swipe_end_y - swipe_start_y;
		TouchAction action1 = new TouchAction((MobileDriver) driver).press(x, y).waitAction(duration)
				.moveTo(x_travel, y_travel).release();
		action1.perform();
	}

}
