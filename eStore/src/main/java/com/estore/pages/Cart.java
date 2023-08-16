package com.estore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
	
	private WebDriver driver;

	public Cart(WebDriver driver) 
	{
		
		this.driver = driver;
	}
	
	public String getTitle() 
	{
		return driver.getTitle();
		
	}
	

	//Remove Button
	public void remove()
	{
		
		driver.findElement(By.xpath("//button[contains(text(), 'Remove')]")).click();
	}
	//Discount code
	public void setDiscountCode()
	{
		
		driver.findElement(By.name("discount_code")).sendKeys("");
	}
	//Apply Discout Button
	public void applyDiscount()
	{
		
		driver.findElement(By.xpath("//input[@value='Apply']")).click();
	}
	
	//get discount amount
	public float discountAmount(){
		
		String sub = driver.findElement(By.id("discount_amount")).getText();
		return Float.parseFloat(sub);
	}
	
	//Get Subtotal
	public float subTotal(){
		
		String sub = driver.findElement(By.xpath("//span[@ng-bind]")).getText();
		return Float.parseFloat(sub);
	}
	//Proceed to CheckOut
	public CheckOutStepOne proceedToCheckout() 
	{
		driver.findElement(By.xpath("//a[contains(text(), 'Proceed to Checkout')]")).click();
		return new CheckOutStepOne(driver);
		
	}
	public CheckOutStepTwo proceedToCheckoutPickupOnly() 
	{
		driver.findElement(By.xpath("//a[contains(text(), 'Proceed to Checkout')]")).click();
		return new CheckOutStepTwo(driver);
		
	}
	
	//Continue Shopping
	
	public StoreHomePage continueShopping()
	{
		
		driver.findElement(By.xpath("//a[contains(text(), 'continue shopping')]")).click();
		return new StoreHomePage(driver);
	}
	
}
