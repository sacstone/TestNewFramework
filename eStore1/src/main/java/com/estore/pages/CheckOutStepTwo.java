package com.estore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckOutStepTwo {

	private WebDriver driver;

	public CheckOutStepTwo(WebDriver driver) {

		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();

	}

	// email
	public void email() {

		driver.findElement(By.id("email")).sendKeys("EstoreAutoTest@wholefoods.com");
	}

	// pickupdate
	public String pickupDate() {

		Select selectDate = new Select(driver.findElement(By.xpath("//select[@ng-model='pickup.day']")));
		selectDate.selectByIndex(0);
		return selectDate.getFirstSelectedOption().getText();
	}

	// pickuptime
	public String pickupTime() {

		Select selectTime = new Select(driver.findElement(By.name("pickup_time")));
		selectTime.selectByIndex(0);
		return selectTime.getFirstSelectedOption().getText();
	}

	// Shipping FirstName
	public void shippingFname(String fname) {

		driver.findElement(By.id("shipping_firstname")).sendKeys(fname);
	}

	// Shipping LastName
	public void shippingLname(String lname) {

		driver.findElement(By.id("shipping_lastname")).sendKeys(lname);
	}

	// Shipping Street1
	public void shippingStreet1(String shippingAddress1) {

		driver.findElement(By.id("shipping_street1")).sendKeys(shippingAddress1);
	}

	// Shipping Street2
	public void shippingStreet2(String shippingAddress2) {

		driver.findElement(By.id("shipping_street2")).sendKeys(shippingAddress2);
	}

	// Shipping City
	public void shippingCity(String city) {

		driver.findElement(By.id("shipping_city")).sendKeys(city);
	}

	// Shipping State
	public void shippingState(String sstate) {

		Select state = new Select(driver.findElement(By.id("state")));
		state.selectByVisibleText(sstate);
	}

	// Zip
	public void shippingZip(String zipCode) {

		driver.findElement(By.name("shipping_zip")).sendKeys(zipCode);
	}

	// Frame: selectFrame : vantiv-payframe
	// Credit Card

	// Account Number
	public void accountNumber(String ccNumber) {

		driver.findElement(By.id("accountNumber")).sendKeys(ccNumber);
	}

	// expMonth
	public void expMonth(String exMonth) {

		Select month = new Select(driver.findElement(By.id("expMonth")));
		month.selectByVisibleText(exMonth);
	}

	// expYear

	public void expYear(String expYear) {

		Select year = new Select(driver.findElement(By.id("expYear")));
		year.selectByVisibleText(expYear);
	}

	// Cvv
	public void cvv(String cvv) {

		driver.findElement(By.id("cvv")).sendKeys(cvv);
	}

	// Tooltip
	public void cvvWhatIsThis() {

		driver.findElement(By.id("tooltipText")).click();
		driver.findElement(By.id("tooltipText")).click();
	}

	// BillingSameAsShippingCheckbox

	public void sameAs() {

		driver.findElement(By.id("clone")).click();

	}

	// FirstName
	public void fName(String fname) {

		driver.findElement(By.name("firstname")).sendKeys(fname);
	}

	// LastName
	public void lName(String lname) {

		driver.findElement(By.name("lastname")).sendKeys(lname);
	}

	// StreetAddress1
	public void streetAddress1(String address1) {

		driver.findElement(By.name("street1")).sendKeys(address1);
	}

	// StreetAddress2
	public void streetAddress2(String address2) {

		driver.findElement(By.name("street2")).sendKeys(address2);
	}

	// City
	public void city(String city) {

		driver.findElement(By.name("city")).sendKeys(city);
	}

/*	// Country
	public void country(String countryname) {

		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByVisibleText(countryname);
	}*/
	// Country
	public String country() {

		Select country = new Select(driver.findElement(By.name("country")));
		return country.getFirstSelectedOption().getText();
	}
	// State
	public void state(String stateName) {

		Select state = new Select(driver.findElement(By.name("state")));
		state.selectByVisibleText(stateName);
	}

	// Zip
	public void zip(String zipCode) {

		driver.findElement(By.name("zip")).sendKeys(zipCode);
	}

	// Phone
	public void phone(String number) {

		driver.findElement(By.name("phone1")).sendKeys(number);
	}

	// PhoneExt
	public void phoneExt(String number) {

		driver.findElement(By.name("phone1ext")).sendKeys(number);
	}
	
	// Messages

	public String payInStoreMessage() {

		return driver.findElement(By.xpath("//fieldset[@id = 'payInStoreMsg']")).getText();
	}

	
	public String scheduleDeliveryMessage() {

		return driver.findElement(By.xpath("//h3[contains(text(), 'Schedule Delivery')]")).getText();
	}

	public String shippingAddressMessage() {

		return driver.findElement(By.xpath("//h3[contains(text(), 'Shipping Address')]")).getText();
	}

	public String billingInformationMessage() {

		return driver.findElement(By.xpath("//h3[contains(text(), 'Billing Information')]")).getText();
	}

	public String billingAddressMessage() {

		return driver.findElement(By.xpath("//h3[contains(text(), 'Billing Address')]")).getText();
	}
	// ReviewOrder
	public CheckOutStepThree reviewOrder() {

		driver.findElement(By.id("reviewOrder")).click();
		return new CheckOutStepThree(driver);
	}
	
	//Store homepage on Bread crumbs
		public StoreHomePage storeHome(){
			
			driver.findElement(By.xpath("//a[contains(text(), 'TEST STORE xox')]")).click();
			return new StoreHomePage(driver);
		}

}
