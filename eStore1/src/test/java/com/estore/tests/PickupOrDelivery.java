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

public class PickupOrDelivery extends TestBase
{

/*	@BeforeMethod
	public void beforeMethod() {

	}
*/
	@Test
	public void pickOrDelivery() throws ParseException, InterruptedException {

/*		System.setProperty("webdriver.chrome.driver.", "/Users/rameshdhanekula/Downloads/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://stage.wholefoodsmarket.com/shop/xox/");
*/

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

		ckone.selectDeliveryOptions();
		ckone.selectPickupOptions();
		ckone.clickOnContinue();

		CheckOutStepTwo cktwo = new CheckOutStepTwo(driver);
		cktwo.email();
		cktwo.pickupDate();
		cktwo.pickupTime();

		driver.switchTo().frame(0);

		cktwo.accountNumber("4111111111111111");
		cktwo.expMonth("October");
		cktwo.expYear("2018");

		cktwo.cvv("333");
		cktwo.cvvWhatIsThis();

		driver.switchTo().defaultContent();

		cktwo.fName("Ramesh");
		cktwo.lName("Dee");
		cktwo.streetAddress1("234 street 1");
		cktwo.streetAddress1("sutie 1");
		cktwo.city("Austin");
		cktwo.country();
		cktwo.state("Texas");
		cktwo.zip("87222");
		cktwo.phone("3427894545");
		cktwo.phoneExt("333");
		cktwo.reviewOrder();
		Thread.sleep(2000);
		CheckOutStepThree ckthree = new CheckOutStepThree(driver);
		Thread.sleep(2000);
		ckthree.placeOrder();
		Thread.sleep(2000);

		System.out.println(new OrderConfirmation(driver).getOrderNumber());
		//driver.quit();

	}
/*	@AfterMethod
	public void afterMethod() {
		// driver.quit();

	}*/

}
