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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class VariableWeightItem extends TestBase {

	private float subTotal;
	private float tax;
	private float eTotal;
	private String estimateMessage = "Total displayed here is an estimate. Pay the final calculated total at the time of pickup.";
	
	@Test(description = "Test case for Variable Weight Item")
	public void variableWeight() throws ParseException, InterruptedException {

		StoreHomePage shp = new StoreHomePage(driver);

		shp.clickCategory("Browse All Catalog A").selectProduct("MF-1");

		ProductDetailsPage sp = new ProductDetailsPage(driver);

		String devliveryMessage = "Delivery options are available for this item.";
		Thread.sleep(5000);

		// step3
		Assert.assertTrue(sp.delivryOptionsMessage().equals(devliveryMessage), "Did not find message");
		

		int qtyOnDetailsPageMF = StringHandling.extractInt(sp.itemQuantity().getAttribute("value"));

		sp.addToCart();
		Thread.sleep(2000);

		int qtyOnPopUpMF = StringHandling.extractInt(sp.quantityInPopup().getText());

		// Check quantity on details page same as quantity on popup

		Assert.assertTrue(qtyOnDetailsPageMF == qtyOnPopUpMF, "Quantity is different");

		sp.clickCheckout();

		Cart c = new Cart(driver);

		String expectedURL = "https://stage.wholefoodsmarket.com/shop/xox/cart";
		//Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Not in the cart page");

	//	Assert.assertTrue(c.secureCheckOutMessage().contains("SECURE CHECKOUT"),
		//		"Secure checkout message not displayed");

		c.proceedToCheckout();

		CheckOutStepOne ckone = new CheckOutStepOne(driver);

		Assert.assertTrue(ckone.selectDeliveryOptions().isDisplayed(), "No Deliery option is displayed");
		Assert.assertTrue(ckone.selectDeliveryOptions().isSelected(), "Default Deliery option is not selected");
		Assert.assertTrue(ckone.selectPickupOptions().isDisplayed(), "No Pickup option is displayed");
		Assert.assertTrue(!ckone.selectPickupOptions().isSelected(), "Pickup option is selected by defualt");

		ckone.selectDeliveryOptions().click();
		ckone.clickOnContinue();

		CheckOutStepTwo cktwo = new CheckOutStepTwo(driver);

		Assert.assertTrue(cktwo.scheduleDeliveryMessage().contains("SCHEDULE DELIVERY"),
				"Schedule Delivery not displayed");
		Assert.assertTrue(cktwo.shippingAddressMessage().contains("SHIPPING ADDRESS"),
				"Shipping Address not displayed");
		Assert.assertTrue(cktwo.billingInformationMessage().contains("BILLING INFORMATION"),
				"Billing Information not displayed");
		Assert.assertTrue(cktwo.billingAddressMessage().contains("BILLING ADDRESS"), "Billing Address not displayed");

		cktwo.storeHome();

		// Variable weight item
		shp.clickCategory("Browse All Catalog A").selectProduct("VW-1");

		int qtyOnDetailsPageVW = StringHandling.extractInt(sp.itemQuantity().getAttribute("value"));

		String pickupyMessage = "NOTE: This item must be paid for in-store.";
		Assert.assertTrue(sp.pickupInstoreMessage().equals(pickupyMessage), "Do not see message");

		sp.addToCart();
		Thread.sleep(2000);

		int qtyOnPopUpVW = StringHandling.extractInt(sp.quantityInPopup().getText());

		// Check quantity on details page same as quantity on popup

		Assert.assertTrue(qtyOnDetailsPageVW == qtyOnPopUpVW, "Quantity is different");

		sp.clickCheckout();

		c.proceedToCheckout();

		String checkOutUrl = "https://stage.wholefoodsmarket.com/shop/xox/checkout";

	//	Assert.assertEquals(checkOutUrl, driver.getCurrentUrl());

		cktwo.email();

		String pickupDate = cktwo.pickupDate();
		// System.out.println(pickupDate);

		// cktwo.pickupDate();

		String pickupTime = cktwo.pickupTime();

		// System.out.println(pickupTime);

		Assert.assertTrue(cktwo.payInStoreMessage().contains("PAY IN STORE"), "Don't see pay in store message");

		cktwo.fName("Estore");
		cktwo.lName("AutoTest");
		cktwo.streetAddress1("550 Bowie");
		cktwo.city("Austin");

		Assert.assertTrue(cktwo.country().equals("USA"), "Default County is not USA");

		cktwo.state("Texas");
		cktwo.zip().sendKeys("78703");

		cktwo.phone("5124774455");

		cktwo.reviewOrder();

		CheckOutStepThree ckthree = new CheckOutStepThree(driver);
		// Assert.assertTrue(ckthree.storePickUpAddresss().contains(shp.storeAddress()),
		// "Pickup Store address is different ");
	//	Assert.assertTrue(ckthree.storePickUpDateTime().contains(pickupDate), "Pickup Date is different ");
		Assert.assertTrue(ckthree.storePickUpDateTime().contains(pickupTime), "Pickup Time is different ");


		List<WebElement> stotal = ckthree.itemTotals().findElements(By.tagName("li"));

		Iterator<WebElement> itrS = stotal.iterator();
		// float subTotal;
		while (itrS.hasNext()) {
			
			String values = itrS.next().getText();

			if (values.contains("SUBTOTAL")) {

				float subTotalf = StringHandling.extractFloat(values);
				subTotal = subTotalf;
			}
		}
		
		List<WebElement> sTax = ckthree.itemTotals().findElements(By.tagName("li"));

		Iterator<WebElement> itrT = sTax.iterator();
		// float Tax;
		while (itrT.hasNext()) {
			
			String values = itrT.next().getText();

			if (values.contains("TAX")) {

				float taxf = Float.parseFloat(values.replaceAll("[^0-9]", ""));;
				tax = taxf;
			}
		}
		
		List<WebElement> eTot = ckthree.itemTotals().findElements(By.tagName("li"));

		Iterator<WebElement> itrE = eTot.iterator();
		// Estimated Total Tax;
		while (itrE.hasNext()) {
			
			String values = itrE.next().getText();

			if (values.contains("ESTIMATED TOTAL")) {

				float eTotalf = StringHandling.extractFloat(values);
				eTotal = eTotalf;
			}
		}
		
		Assert.assertEquals(ckthree.estimateOnlyMessage(), estimateMessage, "There is no message");
		System.out.println(ckthree.estimateOnlyMessage());
		
		
		Assert.assertEquals(eTotal, subTotal + tax, "Total is not correct");
		
		
		ckthree.placeOrder();

		System.out.println(new OrderConfirmation(driver).getOrderNumber());

	}

}
