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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class GroupedItemCommonSetUp extends TestBase {

	private float subTotal;
	private float tax;
	private float eTotal;

	private String estimateMessage = "Total displayed here is an estimate. Pay the final calculated total at the time of pickup.";

	String testCaseID = "164204";
	long getTestRunIdRail3;
	String testResult;

	/*
	 * @BeforeTest public void testrail() throws MalformedURLException,
	 * IOException, APIException{
	 * 
	 * TestRailCall tc = new TestRailCall(); tc.testRailInitialCall();
	 * 
	 * // System.out.println(TesTrunid);
	 * 
	 * }
	 */

	@Test(description = "Test case for Grouped Item Common Setup")

	public void GroupedItemCommon()
			throws ParseException, InterruptedException, MalformedURLException, IOException, APIException {

		StoreHomePage shp = new StoreHomePage(driver);

		String gc4 = shp.clickCategory("Browse All Catalog A").itemPrice("GC - 4");

		Assert.assertTrue(gc4.equals("$4.00"));

		ProductDetailsPage sp1 = new ProductDetailsPage(driver);
		sp1.storeHome();

		String gc5 = new StoreHomePage(driver).clickCategory("Browse All Catalog A").itemPrice("GC - 5");
		Assert.assertTrue(gc5.equals("$5.00"));

		ProductDetailsPage sp2 = new ProductDetailsPage(driver);
		sp2.storeHome();

		String gc6 = new StoreHomePage(driver).clickCategory("Browse All Catalog A").itemPrice("GC - 6");

		Assert.assertTrue(gc6.equals("$6.00"));

		ProductDetailsPage sp3 = new ProductDetailsPage(driver);
		sp3.storeHome();

		String gm2 = new StoreHomePage(driver).clickCategory("Browse All Catalog A").itemPrice("GM-2");

		Assert.assertTrue(gm2.equals("Starting at"));

		// System.out.println(gm2);

		ProductDetailsPage sp4 = new ProductDetailsPage(driver);
		sp3.storeHome();
		new StoreHomePage(driver).clickCategory("Browse All Catalog A").selectProduct("GM-2");

		ProductDetailsPage sp = new ProductDetailsPage(driver);

		// checking items in drop down

		Select selectOption = new Select(driver.findElement(By.name("itemOption[]")));

		List<WebElement> options1 = selectOption.getOptions();

		Assert.assertTrue(options1.size() == 4, "More than three options");

		Iterator<WebElement> itrT1 = options1.iterator();
		// float Tax;
		while (itrT1.hasNext()) {

			String values = itrT1.next().getText();

			if (values.contains("GC - 4")) {

				Assert.assertTrue(values.contains("GC - 4"), "Do not see item GC - 4 in the drop down");

			}

		}

		Iterator<WebElement> itrT2 = options1.iterator();

		while (itrT2.hasNext()) {

			String values = itrT2.next().getText();

			if (values.contains("GC - 5")) {

				Assert.assertTrue(values.contains("GC - 5"), "Do not see item GC - 5 in the drop down");

			}

		}

		Iterator<WebElement> itrT3 = options1.iterator();
		while (itrT3.hasNext()) {

			String values = itrT3.next().getText();

			if (values.contains("GC - 6")) {

				Assert.assertTrue(values.contains("GC - 6"), "Do not see item GC - 6 in the drop down");

			}

		}

		sp.selectOption(1);

		Assert.assertEquals(gc4, driver.findElement(By.xpath("//span[@ng-bind]")).getText(), "Item price is not right");

		String devliveryMessage = "Delivery options are available for this item.";

		// GC - 5 ($5.00)

		// step3
		Assert.assertTrue(sp.delivryOptionsMessage().equals(devliveryMessage), "Did not find message");

		int qtyOnDetailsPageGM2GC4 = StringHandling.extractInt(sp.itemQuantity().getAttribute("value"));

		sp.addToCartButton().click();

		Thread.sleep(2000);

		int qtyOnPopUpGM2GC4 = StringHandling.extractInt(sp.quantityInPopup().getText());

		// Check quantity on details page same as quantity on popup

		Assert.assertTrue(qtyOnDetailsPageGM2GC4 == qtyOnPopUpGM2GC4, "Quantity is different");

		Assert.assertTrue(sp.itemAdded().equals("1 ITEM HAS BEEN ADDED TO YOUR CART"),
				"No of items added to the cart are different");

		sp.continueShopping();

		CategoryPageOne cp = new CategoryPageOne(driver);

		cp.selectProduct("GM-2");

		ProductDetailsPage pd1 = new ProductDetailsPage(driver);

		sp.selectOption(2);
		int qtyOnDetailsPageGM2GC5 = StringHandling.extractInt(sp.itemQuantity().getAttribute("value"));

		sp.addToCartButton().click();

		Thread.sleep(2000);
		int qtyOnPopUpGM2GC5 = StringHandling.extractInt(sp.quantityInPopup().getText());

		// Check quantity on details page same as quantity on popup

		Assert.assertTrue(qtyOnDetailsPageGM2GC5 == qtyOnPopUpGM2GC5, "Quantity is different");

		Assert.assertTrue(sp.itemAdded().equals("1 ITEM HAS BEEN ADDED TO YOUR CART"),
				"No of items added to the cart are different");

		sp.continueShopping();

		CategoryPageOne cp1 = new CategoryPageOne(driver);

		cp.selectProduct("GM-2");

		ProductDetailsPage pd2 = new ProductDetailsPage(driver);

		sp.selectOption(3);
		int qtyOnDetailsPageGM2GC6 = StringHandling.extractInt(sp.itemQuantity().getAttribute("value"));

		sp.addToCartButton().click();

		Thread.sleep(2000);
		int qtyOnPopUpGM2GC6 = StringHandling.extractInt(sp.quantityInPopup().getText());

		// Check quantity on details page same as quantity on popup

		Assert.assertTrue(qtyOnDetailsPageGM2GC6 == qtyOnPopUpGM2GC6, "Quantity is different");

		Assert.assertTrue(sp.itemAdded().equals("1 ITEM HAS BEEN ADDED TO YOUR CART"),
				"No of items added to the cart are different");

		sp.clickCheckout();

		Cart c = new Cart(driver);

		Assert.assertTrue(c.secureCheckOutMessage().contains("SECURE CHECKOUT"),
				"Secure checkout message not displayed");

		Assert.assertTrue(c.subTotal() == 15.00, "Subtotal is not right");

		c.continueShopping();

		// *********************************************

		String gm2gc4 = shp.clickCategory("Browse All Catalog G").itemPrice("GC - 4");

		// System.out.println(gm2gc4);
		Assert.assertTrue(gm2gc4.equals("$4.00"));

		ProductDetailsPage gm2sp1 = new ProductDetailsPage(driver);
		gm2sp1.storeHome();

		String gm2gc5 = new StoreHomePage(driver).clickCategory("Browse All Catalog G").itemPrice("GC - 5");
		Assert.assertTrue(gm2gc5.equals("$5.00"));

		ProductDetailsPage gm2sp2 = new ProductDetailsPage(driver);
		gm2sp2.storeHome();

		String gm2gc6 = new StoreHomePage(driver).clickCategory("Browse All Catalog G").itemPrice("GC - 6");

		Assert.assertTrue(gm2gc6.equals("$6.00"));

		ProductDetailsPage gm2sp3 = new ProductDetailsPage(driver);
		gm2sp3.storeHome();

		String gm2m2 = new StoreHomePage(driver).clickCategory("Browse All Catalog G").itemPrice("GM-2");

		Assert.assertTrue(gm2m2.equals("Starting at"));

		ProductDetailsPage gm2sp4 = new ProductDetailsPage(driver);
		gm2sp4.storeHome();
		new StoreHomePage(driver).clickCategory("Browse All Catalog G").selectProduct("GM-2");

		ProductDetailsPage gm2sp = new ProductDetailsPage(driver);

		Assert.assertEquals(gm2sp.breadCrum("Catalog G").getText(), "Catalog G", "Item is not in Catalog G");

		// checking items in drop down

		Select selectOptiongm = new Select(driver.findElement(By.name("itemOption[]")));

		List<WebElement> optionsgm = selectOptiongm.getOptions();

		Assert.assertTrue(optionsgm.size() == 4, "More than three options");

		Iterator<WebElement> itrgm1 = optionsgm.iterator();
		// float Tax;
		while (itrgm1.hasNext()) {

			String values = itrgm1.next().getText();

			if (values.contains("GC - 4")) {

				Assert.assertTrue(values.contains("GC - 4"), "Do not see item GC - 4 in the drop down");

			}

		}

		Iterator<WebElement> itrgm2 = optionsgm.iterator();

		while (itrgm2.hasNext()) {

			String values = itrgm2.next().getText();

			if (values.contains("GC - 5")) {

				Assert.assertTrue(values.contains("GC - 5"), "Do not see item GC - 5 in the drop down");

			}

		}

		Iterator<WebElement> itrgm3 = optionsgm.iterator();
		while (itrgm3.hasNext()) {

			String values = itrgm3.next().getText();

			if (values.contains("GC - 6")) {

				Assert.assertTrue(values.contains("GC - 6"), "Do not see item GC - 6 in the drop down");

			}

		}

		sp.selectOption(1);

		Assert.assertEquals(gm2gc4, driver.findElement(By.xpath("//span[@ng-bind]")).getText(),
				"Item price is not right");

		String devliveryMessagegm2 = "Delivery options are available for this item.";

		// step3
		Assert.assertTrue(sp.delivryOptionsMessage().equals(devliveryMessagegm2), "Did not find message");

		int qtyOnDetailsPageGM21GC4 = StringHandling.extractInt(sp.itemQuantity().getAttribute("value"));

		sp.addToCartButton().click();

		Thread.sleep(2000);

		int qtyOnPopUpGM21GC4 = StringHandling.extractInt(sp.quantityInPopup().getText());

		// Check quantity on details page same as quantity on popup

		Assert.assertTrue(qtyOnDetailsPageGM21GC4 == qtyOnPopUpGM21GC4, "Quantity is different");

		Assert.assertTrue(sp.itemAdded().equals("1 ITEM HAS BEEN ADDED TO YOUR CART"),
				"No of items added to the cart are different");

		sp.continueShopping();

		CategoryPageOne cpgm2 = new CategoryPageOne(driver);

		cpgm2.selectProduct("GM-2");

		ProductDetailsPage pd = new ProductDetailsPage(driver);

		sp.selectOption(2);
		int qtyOnDetailsPageGM21GC5 = StringHandling.extractInt(sp.itemQuantity().getAttribute("value"));

		sp.addToCartButton().click();

		Thread.sleep(2000);
		int qtyOnPopUpGM21GC5 = StringHandling.extractInt(sp.quantityInPopup().getText());

		// Check quantity on details page same as quantity on popup

		Assert.assertTrue(qtyOnDetailsPageGM21GC5 == qtyOnPopUpGM21GC5, "Quantity is different");

		// System.out.println(sp.itemAdded());

		Assert.assertTrue(sp.itemAdded().equals("1 ITEM HAS BEEN ADDED TO YOUR CART"),
				"No of items added to the cart are different");

		sp.continueShopping();

		CategoryPageOne cpgm = new CategoryPageOne(driver);

		cpgm.selectProduct("GM-2");

		ProductDetailsPage pdgm = new ProductDetailsPage(driver);

		sp.selectOption(3);
		int qtyOnDetailsPageGM21GC6 = StringHandling.extractInt(sp.itemQuantity().getAttribute("value"));

		sp.addToCartButton().click();

		Thread.sleep(2000);
		int qtyOnPopUpGM21GC6 = StringHandling.extractInt(sp.quantityInPopup().getText());

		// Check quantity on details page same as quantity on popup

		Assert.assertTrue(qtyOnDetailsPageGM21GC6 == qtyOnPopUpGM21GC6, "Quantity is different");

		Assert.assertTrue(sp.itemAdded().equals("1 ITEM HAS BEEN ADDED TO YOUR CART"),
				"No of items added to the cart are different");

		sp.clickCheckout();

		Cart c1 = new Cart(driver);
		Thread.sleep(3000);

		Assert.assertTrue(c1.secureCheckOutMessage().contains("SECURE CHECKOUT"),
				"Secure checkout message not displayed");

		Assert.assertTrue(c1.subTotal() == 30.00, "Subtotal is not right");
		c.continueShopping();

		// *********************************************
		shp.clickCategory("Browse All Catalog A").selectProduct("GC - 4");

		ProductDetailsPage pdgm1 = new ProductDetailsPage(driver).addToCart();
		pdgm1.continueShopping();

		CategoryPageOne cp2 = new CategoryPageOne(driver);
		cp2.selectProduct("GC - 5");

		ProductDetailsPage pdgm2 = new ProductDetailsPage(driver);
		pdgm2.addToCart();
		pdgm2.continueShopping();

		CategoryPageOne cp3 = new CategoryPageOne(driver);
		cp3.selectProduct("GC - 6");

		ProductDetailsPage pdgm3 = new ProductDetailsPage(driver);
		pdgm3.addToCart();

		pdgm3.clickCheckout();

		Cart c2 = new Cart(driver);

		Assert.assertTrue(c2.subTotal() == 45.00, "Subtotal is not right");
		c2.continueShopping();

		new StoreHomePage(driver).clickCategory("Browse All Catalog G").selectProduct("GC - 4");

		ProductDetailsPage pdgm4 = new ProductDetailsPage(driver).addToCart();
		pdgm4.continueShopping();

		CategoryPageOne cp4 = new CategoryPageOne(driver);
		cp4.selectProduct("GC - 5");

		ProductDetailsPage pdgm5 = new ProductDetailsPage(driver).addToCart();
		pdgm5.continueShopping();

		CategoryPageOne cp5 = new CategoryPageOne(driver);
		cp5.selectProduct("GC - 6");

		ProductDetailsPage pdgm6 = new ProductDetailsPage(driver).addToCart();

		pdgm6.clickCheckout();

		Cart c3 = new Cart(driver);

		Assert.assertTrue(c3.subTotal() == 60.00, "Subtotal is not right");
		c3.proceedToCheckout();

		CheckOutStepOne ckone = new CheckOutStepOne(driver);

		Assert.assertTrue(ckone.selectDeliveryOptions().isDisplayed(), "No Deliery option is displayed");
		Assert.assertTrue(ckone.selectDeliveryOptions().isSelected(), "Default Deliery option is not selected");
		Assert.assertTrue(ckone.selectPickupOptions().isDisplayed(), "No Pickup option is displayed");
		Assert.assertTrue(!ckone.selectPickupOptions().isSelected(), "Pickup option is selected by defualt");

		ckone.selectPickupOptions().click();
		ckone.clickOnContinue();

		String expectedURL = "https://stage.wholefoodsmarket.com/shop/xox/checkout";

		Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Not in the checkout page");

		CheckOutStepTwo cktwo = new CheckOutStepTwo(driver);

		cktwo.email();

		String pickupDate = cktwo.pickupDate();

		String pickupTime = cktwo.pickupTime();

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
		Thread.sleep(5000);

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

		System.out.println(subTotal);
		System.out.println(tax);
		System.out.println(eTotal);

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
