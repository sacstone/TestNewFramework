package com.estore.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.estore.pages.Cart;
import com.estore.pages.CategoryPage;
import com.estore.pages.CategoryPageOne;
import com.estore.pages.CheckOutStepOne;
import com.estore.pages.CheckOutStepTwo;
import com.estore.pages.CheckOutStepThree;
import com.estore.pages.OrderConfirmation;
import com.estore.pages.PageBase;
import com.estore.pages.ProductDetailsPage;
import com.estore.pages.StoreHomePage;
import com.estore.util.StringHandling;
import com.estore.util.TestBase;
import com.gurock.testrail.APIException;
import com.gurock.testrail.TestRailCall;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class MinimumQuantityItem extends TestBase {

	private float subTotal;
	private float tax;
	private float eTotal;

	private String estimateMessage = "Total displayed here is an estimate. Pay the final calculated total at the time of pickup.";

	String testCaseID = "164204";
	long getTestRunIdRail3;
	String testResult;

	@Test(description = "Test case for Minimum Quantity Item")

	public void minimumQtyItem()
			throws ParseException, InterruptedException, MalformedURLException, IOException, APIException {

		StoreHomePage shp = new StoreHomePage(driver);

		shp.browseCategory("Browse All Catalog A");

		// shp.browseCategory("Browse All Catalog A").

		CategoryPageOne cgp1 = new CategoryPageOne(driver);

		cgp1.selectProduct("QTY-1");

		ProductDetailsPage pdp1 = new ProductDetailsPage(driver);

		Thread.sleep(2000);

		int quantityOnDetailsPage = StringHandling.extractInt(pdp1.itemQuantity1());

		Assert.assertTrue(pdp1.pickupInstoreMessage().contentEquals("NOTE: This item has a minimum order of 6"),
				"Do not see minimun quanity required message");
		Assert.assertTrue(pdp1.delivryOptionsMessage().contentEquals("Delivery options are available for this item."),
				"Do not See devliry options available for this item message");

		pdp1.addToCartButton().click();

		ProductDetailsPage pdp2 = new ProductDetailsPage(driver);

		Thread.sleep(2000);

		Assert.assertEquals(StringHandling.extractInt(pdp2.quantityInPopup().getText()), quantityOnDetailsPage,
				"Quantity do not match on detials page and pop up");

		pdp2.clickCheckout();

		Cart c = new Cart(driver);


		Assert.assertEquals(StringHandling.extractInt(c.itemQuantity()), quantityOnDetailsPage, "Quantity is NOT same");

		c.remove();
		c.continueShopping();
		
		StoreHomePage shp1 = new StoreHomePage(driver);
		
		shp1.browseCategory("Browse All Catalog A");
		
		CategoryPageOne cgp2 = new CategoryPageOne(driver);

		cgp2.selectProduct("QTY-1");
		
		ProductDetailsPage pdp3 = new ProductDetailsPage(driver);

		Thread.sleep(2000);

		int quantityOnDetailsPage1 = StringHandling.extractInt(pdp3.itemQuantity1());

		Assert.assertTrue(pdp1.pickupInstoreMessage().contentEquals("NOTE: This item has a minimum order of 6"),
				"Do not see minimun quanity required message");
		Assert.assertTrue(pdp1.delivryOptionsMessage().contentEquals("Delivery options are available for this item."),
				"Do not See devliry options available for this item message");
		
		pdp3.decreaseQty();
		
		pdp3.addToCartButton().click();
		
		Alert alert = driver.switchTo().alert();

		Assert.assertEquals("Sorry, but this item has a minimum quantity required of 6. Your order quantity has been updated.", alert.getText(), "Do not see alert about minimun quantity");
		
		alert.accept();
		
		ProductDetailsPage pdp4 = new ProductDetailsPage(driver);
		Assert.assertEquals(StringHandling.extractInt(pdp4.quantityInPopup().getText()), quantityOnDetailsPage1,
				"Quantity do not match on detials page and pop up");
		
		pdp4.clickCheckout();
		
		Cart c1 = new Cart(driver);
		
		Assert.assertEquals(StringHandling.extractInt(c1.itemQuantity()), quantityOnDetailsPage1, "Quantity is NOT same");
		
		
		c1.decreaseQty();
		
		Alert alert1 = driver.switchTo().alert();
		
		Assert.assertEquals("The minimum required quantity for this item is 6. Your cart will be updated.", alert1.getText(), "Do not see alert about minimun quantity");
		
		
		alert1.accept();
		
		
		
		System.out.println(c1.itemQuantity());
		
		Assert.assertEquals(StringHandling.extractInt(c1.itemQuantity()), quantityOnDetailsPage1, "Quantity is NOT same");
		
		c1.proceedToCheckout();
		
		CheckOutStepOne ckone = new CheckOutStepOne(driver);
		
		Assert.assertTrue(ckone.selectDeliveryOptions().isDisplayed(), "No Deliery option is displayed");
		Assert.assertTrue(ckone.selectDeliveryOptions().isSelected(), "Default Deliery option is not selected");
		Assert.assertTrue(ckone.selectPickupOptions().isDisplayed(), "No Pickup option is displayed");
		Assert.assertTrue(!ckone.selectPickupOptions().isSelected(), "Pickup option is selected by defualt");

		ckone.selectPickupOptions().click();;
		ckone.clickOnContinue();
		
		String expectedURL = "https://stage.wholefoodsmarket.com/shop/xox/checkout";

		Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Not in the checkout page");
		

		
		
		
		
		
		
		
		
		
		
		

		// *****************************************************

		CheckOutStepTwo cktwo = new CheckOutStepTwo(driver);

		cktwo.email();

		String pickupDate = cktwo.pickupDate();

		String pickupTime = cktwo.pickupTime();

//		Assert.assertTrue(cktwo.payInStoreMessage().contains("PAY IN STORE"));
		
		cktwo.accountNumber("4457010000000009");
		cktwo.expMonth("April");
		cktwo.expYear("2024");
		cktwo.cvv("349");
		cktwo.cvvWhatIsThis();

		cktwo.fName("John");
		cktwo.lName("Smith");
		cktwo.streetAddress1("1 Main St.");
		cktwo.city("Burlington");

		Assert.assertTrue(cktwo.country().equals("USA"), "Default County is not USA");

		cktwo.state("Massachusetts");
		cktwo.zip().clear();
		cktwo.zip().sendKeys("01803");

		cktwo.phone("5124774455");
		String phoneNote = "*Phone numbers are for customer service only";

		Assert.assertTrue(cktwo.pricingHeader().isDisplayed(),
				"Do not see pricing information on bottom nav Legal info");
		Assert.assertTrue(cktwo.shopWithConfidenceHeader().isDisplayed(),
				"Do not see shop with confidence information on bottom nav Legal info");
		Assert.assertTrue(cktwo.privacyHeader().isDisplayed(),
				"Do not see privacy information on bottom nav Legal info");

		String pricingMessage = "The prices displayed are our regular prices for the items shown. If you complete and process your purchase online, you may be charged more than what the item is currently available for at a store location. If your payment is processed in the store, you will be charged the price in effect at that location on the date of payment. Items that are priced by weight must be processed in the store.";

		Assert.assertEquals(cktwo.pricingContent().getText(), pricingMessage,
				"Pricing content changed, please check with Legal");

		String pricingByWeight = "Items by sold by weight: The total on your order may vary slightly based on the actual weight of items you have purchased. You will be charged only for the amount of product you actually receive.";

		Assert.assertEquals(cktwo.pricingByWeight().getText(), pricingByWeight,
				"Pricing By weight content changed, please contact Legal");

		String pricingOnline = "Online reservation totals: When reserve your order online, you will receive an “estimated total.” The final order total will differ to accurately reflect items sold by weight, items requested that are not found online, items currently on sale at the location the order is processed, and to adjust for any substitutions that are made to your order.";

		Assert.assertEquals(cktwo.pricingOnline().getText(), pricingOnline,
				"Pricing online reservations content changed, Please check wtih Legal");

		String shopWithConfidenceMessage = "All information is encrypted and transmitted without risk using a Secure Sockets Layer (SSL) protocol.";

		Assert.assertEquals(cktwo.shopWithConfidenceContent().getText(), shopWithConfidenceMessage,
				"Content changed, please check with legal");

		String privacyMessage = "We respect your privacy. Your personal information will not be sold or distributed.";

		Assert.assertEquals(cktwo.privacyContent().getText(), privacyMessage,
				"Privacy content changed, please check with legal");

		Assert.assertEquals(cktwo.phoneNote(), phoneNote, "Phone number for customer service only is not correct");

		cktwo.reviewOrder();

		Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Not in the checkout page");

		CheckOutStepThree ckthree = new CheckOutStepThree(driver);
		Thread.sleep(5000);

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

				float taxf = Float.parseFloat(values.replaceAll("[^0-9]", ""));
				;
				tax = taxf;
			}
		}

		List<WebElement> eTot = ckthree.itemTotals().findElements(By.tagName("li"));

		Iterator<WebElement> itrE = eTot.iterator();
		// Estimated Total Tax;
		while (itrE.hasNext()) {

			String values = itrE.next().getText();

			if (values.contains("TOTAL")) {

				float eTotalf = StringHandling.extractFloat(values);
				eTotal = eTotalf;
			}
		}

		Thread.sleep(2000);

		Assert.assertEquals(eTotal, subTotal + tax, "Total is not correct");

		ckthree.placeOrder();

		// Added for TestRail

		System.out.println(new OrderConfirmation(driver).getOrderNumber());

		/*
		 * String ord = new OrderConfirmation(driver).getOrderNumber();
		 * 
		 * if (ord != null) {
		 * 
		 * testResult = "PASSED";
		 * 
		 * } else {
		 * 
		 * testResult = "FAILED"; }
		 * 
		 * TestRailCall tc = new TestRailCall();
		 * System.out.println(getTestRunIdRail3);
		 * System.out.println(testCaseID); System.out.println(testResult);
		 * tc.addTestResultToTestrail(getTestRunIdRail3, testCaseID,
		 * testResult);
		 */
	}

}
