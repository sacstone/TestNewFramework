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

public class TaxedItem extends TestBase {

	private float subTotalOnReviewPage;
	private float taxOnReviewPage;
	private float eTotalOnReviewPage;
	private float taxOnConfirmationPage;

	@Test(description = "Test case for Taxed Item")
	public void taxedItem() throws ParseException, InterruptedException {

		StoreHomePage shp = new StoreHomePage(driver);

		shp.clickCategory("Browse All Catalog A").selectProduct("TC-1");

		ProductDetailsPage sp = new ProductDetailsPage(driver);

		String devliveryMessage = "Delivery options are available for this item.";

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
		Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Not in the cart page");

		Assert.assertTrue(c.secureCheckOutMessage().contains("SECURE CHECKOUT"),
				"Secure checkout message not displayed");

		c.proceedToCheckout();

		CheckOutStepOne ckone = new CheckOutStepOne(driver);

		Assert.assertTrue(ckone.selectDeliveryOptions().isDisplayed(), "No Deliery option is displayed");
		Assert.assertTrue(ckone.selectDeliveryOptions().isSelected(), "Default Deliery option is not selected");
		Assert.assertTrue(ckone.selectPickupOptions().isDisplayed(), "No Pickup option is displayed");
		Assert.assertTrue(!ckone.selectPickupOptions().isSelected(), "Pickup option is selected by defualt");
		
		ckone.selectPickupOptions().click();
		ckone.clickOnContinue();

		CheckOutStepTwo cktwo = new CheckOutStepTwo(driver);

	
		cktwo.email();

		String pickupDate = cktwo.pickupDate();
		System.out.println(pickupDate);

		// cktwo.pickupDate();

		String pickupTime = cktwo.pickupTime();
		
		System.out.println(pickupTime);
		//Visa
	//	cktwo.accountNumber("4457010000000009");
		cktwo.accountNumber("4000000000000001");
		//cktwo.accountNumber("4111111111111111");
		cktwo.expMonth("January");
		cktwo.expYear("2018");
		//cktwo.cvv("349");
		cktwo.cvv("555");
		cktwo.cvvWhatIsThis();
		cktwo.fName("John");
		cktwo.lName("Smith");
		cktwo.streetAddress1("1 Main St.");
		cktwo.city("Burlington");

		Assert.assertTrue(cktwo.country().equals("USA"), "Default County is not USA");

		cktwo.state("Massachusetts");
		cktwo.zip("01803");

		cktwo.phone("5124774455");

		cktwo.reviewOrder();

		CheckOutStepThree ckthree = new CheckOutStepThree(driver);
		Thread.sleep(4000);
		
		// Assert.assertTrue(ckthree.storePickUpAddresss().contains(shp.storeAddress()),
		// "Pickup Store address is different ");
		System.out.println(ckthree.storePickUpDateTime());
		System.out.println(ckthree.storePickUpDateTime());
		//Assert.assertTrue(ckthree.storePickUpDateTime().contains(pickupDate), "Pickup Date is different ");
		Assert.assertTrue(ckthree.storePickUpDateTime().contains(pickupTime), "Pickup Time is different ");

		List<WebElement> stotal = ckthree.itemTotals().findElements(By.tagName("li"));

		Iterator<WebElement> itrS = stotal.iterator();
		// float subTotal;
		while (itrS.hasNext()) {

			String values = itrS.next().getText();

			if (values.contains("SUBTOTAL")) {

				float subTotalf = StringHandling.extractFloat(values);
				subTotalOnReviewPage = subTotalf;
			}
		}

		System.out.println(subTotalOnReviewPage);

		List<WebElement> sTax = ckthree.itemTotals().findElements(By.tagName("li"));

		Iterator<WebElement> itrT = sTax.iterator();
		// float Tax;
		while (itrT.hasNext()) {

			String values = itrT.next().getText();

			if (values.contains("TAX")) {

				float taxf = StringHandling.extractFloat(values);
				taxOnReviewPage = taxf;
			}
		}

		System.out.println(taxOnReviewPage);

		List<WebElement> eTot = ckthree.itemTotals().findElements(By.tagName("li"));

		Iterator<WebElement> itrE = eTot.iterator();
		// Estimated Total Tax;
		while (itrE.hasNext()) {

			String values = itrE.next().getText();

			if (values.contains("TOTAL")) {

				float eTotalf = StringHandling.extractFloat(values);
				eTotalOnReviewPage = eTotalf;
			}
		}

		System.out.println(eTotalOnReviewPage);

		Assert.assertEquals(eTotalOnReviewPage, subTotalOnReviewPage + taxOnReviewPage, "Total is not correct");

		ckthree.placeOrder();

		OrderConfirmation confirm = new OrderConfirmation(driver);

		System.out.println(confirm.getOrderNumber());

		System.out.println(confirm.timeDetails());


		 List<WebElement> cTot = confirm.itemTax().findElements(By.tagName("li"));
		 
		 Iterator<WebElement> itrC = cTot.iterator();
		 
		while(itrC.hasNext()) {
			
			String v = itrC.next().getText();
			if (v.contains("Tax")) {
				
				float taxOnConfirmPage = StringHandling.extractFloat(v);
				taxOnConfirmationPage = taxOnConfirmPage;
			}
		}
		
		Assert.assertTrue(taxOnReviewPage == taxOnConfirmationPage, "Tax is different on Review and Confirmation pages");


	}
	


}
