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
import java.text.DecimalFormat;
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

public class ImpliedDiscount20Percent extends TestBase {

	private float subTotal;
	private float tax;
	private float eTotal;
	private float discount;

	private String estimateMessage = "Total displayed here is an estimate. Pay the final calculated total at the time of pickup.";

	String testCaseID = "164204";
	long getTestRunIdRail3;
	String testResult;

	@Test(description = "Test case for 20% Implied Discount")

	public void impliedDiscount20Percent()
			throws ParseException, InterruptedException, MalformedURLException, IOException, APIException {

		StoreHomePage shp = new StoreHomePage(driver);

		shp.browseCategory("Browse All Catalog K");

		CategoryPageOne cgp1 = new CategoryPageOne(driver);

		cgp1.selectProduct("DC-2");

		ProductDetailsPage pdp1 = new ProductDetailsPage(driver);

		Thread.sleep(2000);

		pdp1.itemQuantity().clear();

		pdp1.itemQuantity().sendKeys("6");

		int quantityOnDetailsPage = StringHandling.extractInt(pdp1.itemQuantity1());

		// System.out.println(quantityOnDetailsPage);

		// Assert.assertTrue(pdp1.delivryOptionsMessage().contentEquals("Delivery
		// options are available for this item."),
		// "Do not See devliry options available for this item message");

		pdp1.addToCartButton().click();

		ProductDetailsPage pdp2 = new ProductDetailsPage(driver);

		Thread.sleep(2000);

		Assert.assertEquals(StringHandling.extractInt(pdp2.quantityInPopup().getText()), quantityOnDetailsPage,
				"Quantity do not match on detials page and pop up");

		pdp2.clickCheckout();

		Cart c = new Cart(driver);

		Assert.assertEquals(StringHandling.extractInt(c.itemQuantity()), quantityOnDetailsPage, "Quantity is NOT same");

		Assert.assertTrue(StringHandling.extractFloat(c.lineItemSubTotal()) == 60.00, "Item Subtotal is not correct");
		Assert.assertTrue(c.discountAmount() == 12.00, "Discount is not correct");

		Assert.assertTrue(c.subTotal() == 48.00, "Suntotal is not correct");

		// System.out.println(StringHandling.extractFloat(c.lineItemSubTotal()));
		// System.out.println(c.discountAmount());;
		// System.out.println(c.subTotal());

		c.decreaseQty();

		c.storeHome();
		StoreHomePage shp1 = new StoreHomePage(driver);
		shp1.shoppingCart();

		// driver.findElement(By.xpath("//a[@class = 'cart_icon']")).click();

		Cart c22 = new Cart(driver);

		// System.out.println(c22.subTotal());;

		Assert.assertTrue(c22.subTotal() == 50.00);
		c.remove();
		c.continueShopping();

		StoreHomePage shp12 = new StoreHomePage(driver);

		shp12.browseCategory("Browse All Catalog K");

		CategoryPageOne cgp2 = new CategoryPageOne(driver);

		cgp2.selectProduct("DC-2");

		ProductDetailsPage pdp3 = new ProductDetailsPage(driver);

		pdp3.itemQuantity().clear();

		pdp3.itemQuantity().sendKeys("12");

		int quantityOnDetailsPage1 = StringHandling.extractInt(pdp1.itemQuantity1());

		pdp3.addToCartButton().click();
		;

		ProductDetailsPage pdp4 = new ProductDetailsPage(driver);

		Thread.sleep(3000);

		Assert.assertEquals(StringHandling.extractInt(pdp4.quantityInPopup().getText()), quantityOnDetailsPage1,
				"Quantity do not match on detials page and pop up");

		pdp4.clickCheckout();

		Cart c23 = new Cart(driver);

		Assert.assertEquals(StringHandling.extractInt(c23.itemQuantity()), quantityOnDetailsPage1,
				"Quantity is NOT same");

		Assert.assertTrue(StringHandling.extractFloat(c23.lineItemSubTotal()) == 120.00,
				"Item Subtotal is not correct");
		Assert.assertTrue(c23.discountAmount() == 24.00, "Discount is not correct");

		Assert.assertTrue(c23.subTotal() == 96.00, "Suntotal is not correct");

		c23.proceedToCheckout();

		CheckOutStepTwo cktwo1 = new CheckOutStepTwo(driver);

		cktwo1.storeHome();

		StoreHomePage shp3 = new StoreHomePage(driver);

		shp3.browseCategory("Browse All Catalog A");

		CategoryPageOne cgp3 = new CategoryPageOne(driver);
		cgp3.selectProduct("BM-1");

		ProductDetailsPage pdp5 = new ProductDetailsPage(driver);

		pdp5.itemQuantity().clear();
		pdp5.itemQuantity().sendKeys("100");

		int itemQuantityDetailsPage = StringHandling.extractInt(pdp1.itemQuantity1());

		pdp5.addToCartButton().click();

		ProductDetailsPage pdp6 = new ProductDetailsPage(driver);

		Thread.sleep(3000);

		pdp6.clickCheckout();

		Cart c24 = new Cart(driver);

		Assert.assertTrue(c24.discountAmount() == 24.00, "Discount is not correct");

		c24.remove();
		c24.storeHome().shoppingCart();

		Cart c25 = new Cart(driver);

		Assert.assertTrue(c25.subTotal() == 100.00, "Suntotal is not correct:   " + c25.subTotal());

		c25.remove();
		c25.continueShopping();

		StoreHomePage shp4 = new StoreHomePage(driver);

		shp4.searchHome().sendKeys("DC-2");

		shp4.clickSearhButton().click();

		CategoryPageOne cgp4 = new CategoryPageOne(driver);
		cgp3.selectProduct("DC-2");

		ProductDetailsPage pdp7 = new ProductDetailsPage(driver);

		pdp7.addToCartButton().click();

		ProductDetailsPage pdp8 = new ProductDetailsPage(driver);

		pdp8.clickCheckout();

		Cart c26 = new Cart(driver);

		c26.updateQuantity().clear();
		c26.updateQuantity().sendKeys("6");
		c26.inreaseQty();

		Cart c27 = new Cart(driver);

		Assert.assertTrue(c27.itemQuantity().equals("6"), "Quantity is not right");

		Assert.assertTrue(c27.discountAmount() == 12.00, "Discount is not correct");

		c27.proceedToCheckout();

		// *****************************************************

		CheckOutStepTwo cktwo = new CheckOutStepTwo(driver);

		cktwo.email();

		String pickupDate = cktwo.pickupDate();

		String pickupTime = cktwo.pickupTime();

		// Assert.assertTrue(cktwo.payInStoreMessage().contains("PAY IN
		// STORE"));

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

		// Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Not in the
		// checkout page");

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

		List<WebElement> disc = ckthree.itemTotals().findElements(By.tagName("li"));

		Iterator<WebElement> itrD = disc.iterator();
		// float subTotal;
		while (itrD.hasNext()) {

			String values = itrD.next().getText();

			if (values.contains("DISCOUNT")) {

				float discountf = StringHandling.extractFloat(values);
				discount = discountf;
			}
		}
		System.out.println(discount);

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

		System.out.println(subTotal);
		System.out.println(eTotal);
		System.out.println(tax);

		Assert.assertEquals(eTotal, subTotal - discount + tax, "Total is not correct");

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
