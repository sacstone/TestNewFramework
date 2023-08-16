package com.estore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckOutStepTwo {
	
	private WebDriver driver;

	public CheckOutStepTwo (WebDriver driver) 
	{
		
		this.driver = driver;
	}
	
	public String getTitle() 
	{
		return driver.getTitle();
		
	}
	//email
	public void email()
	{
		
		driver.findElement(By.id("email")).sendKeys("test@testemail.com");
	}
	//pickupdate
	public void pickupDate()
	{
		
		Select selectDate = new Select(driver.findElement(By.xpath("//select[@ng-model='pickup.day']")));
		selectDate.selectByIndex(4);
		//selectDate.selectByVisibleText(date);
	}
	//pickuptime
	public void pickupTime()
	{
		
		Select selectTime = new Select(driver.findElement(By.name("pickup_time")));
		selectTime.selectByIndex(4);
		//selectTime.selectByVisibleText(time);
	}
	
	//Shipping FirstName
	public void shippingFname()
	{
		
		driver.findElement(By.id("shipping_firstname")).sendKeys("");
	}
	
	
	//Shipping LastName
	public void shippingLname()
	{
		
		driver.findElement(By.id("shipping_lastname")).sendKeys("");
	}
	
	//Shipping Street1
	public void shippingStreet1()
	{
		
		driver.findElement(By.id("shipping_street1")).sendKeys("");
	}
	
	//Shipping Street2
	public void shippingStreet2()
	{
		
		driver.findElement(By.id("shipping_street2")).sendKeys("");
	}
	
	//Shipping City
	public void shippingCity()
	{
		
		driver.findElement(By.id("shipping_city")).sendKeys("");
	}
		
	//Shipping State
	public void shippingState()
	{
		
		Select state = new Select(driver.findElement(By.id("state")));
		state.selectByVisibleText("");
	}
	
	//Frame: selectFrame : vantiv-payframe
	//Credit Card
	
	//Account Number
	public void accountNumber(String ccNumber)
	{
		
		driver.findElement(By.id("accountNumber")).sendKeys(ccNumber);
	}
	//expMonth
	public void expMonth(String exMonth)
	{
		
		Select month = new Select(driver.findElement(By.id("expMonth")));
		month.selectByVisibleText(exMonth);
	}
	
	//expYear
	
	public void expYear(String expYear)
	{
		
		Select year = new Select(driver.findElement(By.id("expYear")));
		year.selectByVisibleText(expYear);
	}
	//Cvv
	public void cvv(String cvv)
	{
		
		driver.findElement(By.id("cvv")).sendKeys(cvv);
	}
	
	//Tooltip
	public void cvvWhatIsThis()
	{
		
		driver.findElement(By.id("tooltipText")).click();
		driver.findElement(By.id("tooltipText")).click();
	}
	
	
	//BillingSameAsShippingCheckbox
	
	public void sameAs()
	{
		
		driver.findElement(By.id("clone")).click();
		
	}
	
	
	
	
	//FirstName
	public void fName(String fname)
	{
		
		driver.findElement(By.name("firstname")).sendKeys(fname);
	}
	//LastName
	public void lName(String lname)
	{
		
		driver.findElement(By.name("lastname")).sendKeys(lname);
	}
	//StreetAddress1
	public void streetAddress1(String address1)
	{
		
		driver.findElement(By.name("street1")).sendKeys(address1);
	}
	//StreetAddress2
	public void streetAddress2(String address2)
	{
		
		driver.findElement(By.name("street2")).sendKeys(address2);
	}
	//City
	public void city(String city)
	{
		
		driver.findElement(By.name("city")).sendKeys(city);
	}
	//Country
	public void country(String countryname)
	{
		
		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByVisibleText(countryname);
	}
	//State
	public void state(String stateName)
	{
		
		Select state = new Select(driver.findElement(By.name("state")));
		state.selectByVisibleText(stateName);
	}

	//Zip
	public void zip(String zipCode)
	{
		
		driver.findElement(By.name("zip")).sendKeys(zipCode);
	}
	
	//Phone
	public void phone(String number)
	{
		
		driver.findElement(By.name("phone1")).sendKeys(number);
	}

	//PhoneExt
	public void phoneExt(String number)
	{
		
		driver.findElement(By.name("phone1ext")).sendKeys(number);
	}
	//ReviewOrder
	public CheckOutStepThree reviewOrder()
	{
		
		driver.findElement(By.id("reviewOrder")).click();
		return new CheckOutStepThree(driver);
	}

}
