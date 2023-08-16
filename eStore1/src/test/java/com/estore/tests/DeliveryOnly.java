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

import org.testng.annotations.BeforeMethod;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DeliveryOnly extends TestBase
{


	@Test
	public void deliveryOnly() throws ParseException, InterruptedException {

		StoreHomePage shp = new StoreHomePage(driver);

		shp.clickCategory("Browse All Catalog A").deliveryOrPickup();

		ProductDetailsPage sp = new ProductDetailsPage(driver);

		float itemP = sp.getItemPrice();
		System.out.println(itemP);

		sp.addToCart();
		Thread.sleep(2000);
		sp.clickCheckout();

		Cart c = new Cart(driver);

		Assert.assertEquals(itemP, c.subTotal());

		c.proceedToCheckout();

		CheckOutStepOne ckone = new CheckOutStepOne(driver);
		Assert.assertTrue(ckone.selectDeliveryOptions().isDisplayed());
		Assert.assertTrue(ckone.selectPickupOptions().isDisplayed());
		Assert.assertTrue(ckone.selectDeliveryOptions().isSelected());
		
		ckone.selectDeliveryOptions().click();
		ckone.clickOnContinue1();

		CheckOutStepTwo cktwo = new CheckOutStepTwo(driver);
		cktwo.email();
		cktwo.pickupDate();
		cktwo.pickupTime();
		
		cktwo.shippingFname("SRamesh");
		cktwo.shippingLname("SDee");
		cktwo.shippingStreet1("Sstreet1");;
		cktwo.shippingStreet2("Sstreet2");
		cktwo.shippingCity("California");
		cktwo.shippingState("California");
		cktwo.shippingZip("94598");

		driver.switchTo().frame(0);

		cktwo.accountNumber("4111111111111111");
		cktwo.expMonth("October");
		cktwo.expYear("2018");

		cktwo.cvv("333");
		cktwo.cvvWhatIsThis();

		driver.switchTo().defaultContent();
		
		cktwo.sameAs();
		
/*
		cktwo.fName("Ramesh");
		cktwo.lName("Dee");
		cktwo.streetAddress1("234 street 1");
		cktwo.streetAddress1("sutie 1");
		cktwo.city("Austin");
		cktwo.country("USA");
		cktwo.state("Texas");
		cktwo.zip("87222");*/
		
		cktwo.phone("3427894545");
		cktwo.phoneExt("333");
		cktwo.reviewOrder();
		
		Thread.sleep(2000);
		
		CheckOutStepThree ckthree = new CheckOutStepThree(driver);
		Thread.sleep(2000);
		ckthree.placeOrder();
		Thread.sleep(2000);

		System.out.println(new OrderConfirmation(driver).getOrderNumber());
	

	}


}
