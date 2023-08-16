package com.estore.tests;

import org.testng.annotations.Test;

import com.estore.pages.Cart;
import com.estore.pages.CategoryPage;
import com.estore.pages.CheckOutStepOne;
import com.estore.pages.CheckOutStepTwo;
import com.estore.pages.CheckOutStepThree;
import com.estore.pages.OrderConfirmation;
import com.estore.pages.PageBase;
import com.estore.pages.ProductDetailsPage;
import com.estore.pages.StoreHomePage;
import com.estore.util.StringHandling;
import com.estore.util.TestBase;

import org.testng.annotations.BeforeMethod;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
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

	@Test(description = "Zero Inventory")
	public void zeroInventory() throws ParseException, InterruptedException {

		StoreHomePage shp = new StoreHomePage(driver);

		shp.clickCategory("Browse All Catalog I").selectProduct("IN-0");

	ProductDetailsPage sp = new ProductDetailsPage(driver);

		String devliveryMessage = "Delivery options are available for this item.";

		// step3
		Assert.assertTrue(sp.delivryOptionsMessage().equals(devliveryMessage), "Did not find message");

//	int qtyOnDetailsPageMF = StringHandling.extractInt(sp.itemQuantity().getAttribute("value"));
	
	//Assert.assertTrue(!sp.addToCartButton().isDisplayed());
	Assert.assertTrue(sp.callStoreMessage().contains("Please call the store at 5125551234 to check availability."));
	Assert.assertTrue(sp.soldOutMessage().isDisplayed());

	}
	


}
