package com.estore.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
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
import com.gurock.testrail.APIAfterTestCall;
import com.gurock.testrail.APIException;
import com.gurock.testrail.InitialTestRailCall;
import com.gurock.testrail.InitialTestRailCallOld;

//import wfm.appium.APItest.APIAfterTestCall;

//import wfm.appium.APItest.InitialTestRailCall;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class DeliveryOnlyTestRailM2 extends TestBase {

	private float subTotal;
	private float tax;
	private float eTotal;
	private String estimateMessage = "Total displayed here is an estimate. Pay the final calculated total at the time of pickup.";

	//Murali Code
	
	
	public int publish;
	public int TestRunIdRail;
	public String TestComment;
	public int caseid =164204;
	String folder_name;
	DateFormat df;
	
	//End murali code
	//Murali Code
	//@BeforeClass
	public void testRailInitialcall() throws MalformedURLException, IOException, APIException, InterruptedException{
	
		InitialTestRailCallOld ApiSuiteCall = new InitialTestRailCallOld();
		ApiSuiteCall.testRailInitialcall(caseid);


	}	
	
	//End murali code
	
	
	@Test
	public void deliveryOnly() throws ParseException, InterruptedException, MalformedURLException, IOException, APIException {
		try{
			//Murali Code:
			
		

			StoreHomePage shp = new StoreHomePage(driver);

			shp.clickCategory("Browse All Catalog A").selectProduct("MF-1");

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



			Assert.assertTrue(c.secureCheckOutMessage().contains("SECURE CHECKOUT"),
					"Secure checkout message not displayed");

			c.proceedToCheckout();

			CheckOutStepOne ckone = new CheckOutStepOne(driver);

			Assert.assertTrue(ckone.selectDeliveryOptions().isDisplayed(), "No Deliery option is displayed");
			Assert.assertTrue(ckone.selectDeliveryOptions().isSelected(), "Default Deliery option is not selected");
			Assert.assertTrue(ckone.selectPickupOptions().isDisplayed(), "No Pickup option is displayed");
			Assert.assertTrue(!ckone.selectPickupOptions().isSelected(), "Pickup option is selected by defualt");

			ckone.selectDeliveryOptions().click();
			ckone.clickOnContinue();
			
			String expectedURL = "https://stage.wholefoodsmarket.com/shop/xox/checkout";

			Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Not in the checkout page");
			

			CheckOutStepTwo cktwo = new CheckOutStepTwo(driver);

			Assert.assertTrue(cktwo.scheduleDeliveryMessage().contains("SCHEDULE DELIVERY"),
					"Schedule Delivery not displayed");
			Assert.assertTrue(cktwo.shippingAddressMessage().contains("SHIPPING ADDRESS"),
					"Shipping Address not displayed");
			Assert.assertTrue(cktwo.billingInformationMessage().contains("BILLING INFORMATION"),
					"Billing Information not displayed");
			Assert.assertTrue(cktwo.billingAddressMessage().contains("BILLING ADDRESS"), "Billing Address not displayed");

			cktwo.email();

			String pickupDate = cktwo.pickupDate();

			System.out.println(pickupDate);

			// cktwo.pickupDate();

			String pickupTime = cktwo.pickupTime();

			System.out.println(pickupTime);
			
			
			cktwo.shippingFname("Mike");
			cktwo.shippingLname("Hammer");
			cktwo.shippingStreet1("2 Main St");
			cktwo.streetAddress2("Apt 222");
			cktwo.shippingCity("Riverside");
			Assert.assertTrue(cktwo.country().equals("USA"), "Default County is not USA");
			cktwo.shippingState("Rhode Island");
			cktwo.shippingZip("02915");
			//Visa
			//cktwo.accountNumber("4457010000000009");
	/*		cktwo.accountNumber("4111111111111111");
			cktwo.expMonth("April");
			cktwo.expYear("2024");
			cktwo.cvv("349");
			cktwo.cvvWhatIsThis();
			cktwo.sameAs().click();
	*/		
			//Master
			//cktwo.accountNumber("4457010000000009");
			cktwo.accountNumber("5112010000000003");
			cktwo.expMonth("April");
			cktwo.expYear("2024");
			cktwo.cvv("261");
			cktwo.cvvWhatIsThis();
			cktwo.sameAs().click();
			
		
			
			Assert.assertTrue(cktwo.pricingHeader().isDisplayed(), "Do not see pricing information on bottom nav Legal info");
			Assert.assertTrue(cktwo.shopWithConfidenceHeader().isDisplayed(), "Do not see shop with confidence information on bottom nav Legal info");
			Assert.assertTrue(cktwo.privacyHeader().isDisplayed(), "Do not see privacy information on bottom nav Legal info");
			
			String pricingMessage = "The prices displayed are our regular prices for the items shown. If you complete and process your purchase online, you may be charged more than what the item is currently available for at a store location. If your payment is processed in the store, you will be charged the price in effect at that location on the date of payment. Items that are priced by weight must be processed in the store.";
			
			Assert.assertEquals(cktwo.pricingContent().getText(), pricingMessage, "Pricing content changed, please check with Legal");
			
			String pricingByWeight = "Items by sold by weight: The total on your order may vary slightly based on the actual weight of items you have purchased. You will be charged only for the amount of product you actually receive.";
			
			Assert.assertEquals(cktwo.pricingByWeight().getText(), pricingByWeight, "Pricing By weight content changed, please contact Legal");
			
			String pricingOnline = "Online reservation totals: When reserve your order online, you will receive an “estimated total.” The final order total will differ to accurately reflect items sold by weight, items requested that are not found online, items currently on sale at the location the order is processed, and to adjust for any substitutions that are made to your order.";
			
			Assert.assertEquals(cktwo.pricingOnline().getText(), pricingOnline, "Pricing online reservations content changed, Please check wtih Legal");
			
			
			
			
			
			String shopWithConfidenceMessage = "All information is encrypted and transmitted without risk using a Secure Sockets Layer (SSL) protocol.";
			
			Assert.assertEquals(cktwo.shopWithConfidenceContent().getText(), shopWithConfidenceMessage, "Content changed, please check with legal");
			
			String privacyMessage = "We respect your privacy. Your personal information will not be sold or distributed.";
			
			Assert.assertEquals(cktwo.privacyContent().getText(), privacyMessage, "Privacy content changed, please check with legal");
			
			cktwo.phone("5124774455");
			
			String phoneNote = "*Phone numbers are for customer service only";
			
			Assert.assertEquals(cktwo.phoneNote(), phoneNote,  "Phone number for customer service only is not correct");

			cktwo.reviewOrder();
			
			
			Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Not in the checkout page");
			
				

			CheckOutStepThree ckthree = new CheckOutStepThree(driver);
			// Assert.assertTrue(ckthree.storePickUpAddresss().contains(shp.storeAddress()),
			// "Pickup Store address is different ");
			//Assert.assertTrue(ckthree.storePickUpDateTime().contains(pickupDate), "Pickup Date is different ");
		//	Assert.assertTrue(ckthree.storePickUpDateTime().contains(pickupTime), "Pickup Time is different ");
			
			Thread.sleep(5000);
			String countString = ckthree.itemCount().getText();
			
			int count = Integer.parseInt(countString.replaceAll("[^0-9]", ""));		
			
			Assert.assertTrue(count == qtyOnPopUpMF, "");
			

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


			Assert.assertEquals(eTotal, subTotal + tax, "Total is not correct");

		//	ckthree.placeOrder();

		//	System.out.println(new OrderConfirmation(driver).getOrderNumber());
			
			if(eTotal == subTotal+tax)
			{
				publish =1 ;
				System.out.println("Delivery Testcase Successfull");
				TestComment = "Success";
			}
			else
			{
				publish =5 ;
				System.out.println("Delivery Testcase Failed");
				TestComment = "Failed";
			}
		//	capturefinalscreen(TestComment);
		//	System.out.println("The Amazon URL IS" + getAmazonURL());
			publishresults(publish,TestComment,caseid);
			
		} 
		
		catch(Exception e) {
			
			System.out.println(e);
		}


	}
	
	public void publishresults (int publish2, String Comment, long getTestRunIdRail) throws MalformedURLException, IOException, APIException, InterruptedException{
		
		
		
		APIAfterTestCall steps = new APIAfterTestCall();
		steps.InitializeTestRail(publish,caseid,TestComment,getTestRunIdRail) ;


		
	}


}
