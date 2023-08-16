package com.estore.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;

public class Cart {
	
	//private WebDriver driver;
	private IOSDriver driver;

	public Cart(IOSDriver driver) 
	{
		
		this.driver = driver;
	}
	
	public String getTitle() 
	{
		return driver.getTitle();
		
	}
	
	public String itemQuantity()
	{
		String quantity= null;	
		List<WebElement> values1 = driver.findElements(By.xpath("//input[@name = 'quantity']"));
	for(WebElement el : values1)
	{
		quantity = el.getAttribute("value");
	 // System.out.println(theTextIWant);
	}

	return quantity;
		
	}
	
	//Line Item SubTotal
	public String lineItemSubTotal(){
		
		//String sub = driver.findElement(By.xpath("//div[@class = 'subtotal tablet_only']")).getText();
	return driver.findElement(By.xpath("//div[@class = 'subtotal tablet_only']")).getText();
		//return Float.parseFloat(sub);
	}
	
	public void decreaseQty()
	{
		driver.findElement(By.xpath("//button[@class = 'decrease_qty']")).click();
		
	}
	public WebElement updateQuantity(){
		
		return driver.findElement(By.xpath("//input[@name = 'quantity']"));
	}
	
	public void inreaseQty()
	{
		driver.findElement(By.xpath("//button[@class = 'increase_qty']")).click();
		
	}
	
	
	//secure checkout message
	public String secureCheckOutMessage()
	{
		
		return driver.findElement(By.xpath("//span[contains(text(), 'SECURE CHECKOUT')]")).getText();
	}
	//Remove Button
	public void remove()
	{
		
		driver.findElement(By.xpath("//button[contains(text(), 'Remove')]")).click();
	}
	
	//Discount code
	public WebElement setDiscountCode()
	{
		
		return driver.findElement(By.name("discount_code"));
	}
	//Apply Discout Button
	public WebElement applyDiscount()
	{
		
		return driver.findElement(By.xpath("//input[@value='Apply']"));
	}
	
	//Apply Discout Button
	public WebElement discountAppliedMessage()
	{
		
		return driver.findElement(By.xpath("//div[@class = 'alert_message']"));
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
	//Proceed to CheckOut with Delivery Option
	public CheckOutStepOne proceedToCheckout() 
	{
		driver.findElement(By.xpath("//a[contains(text(), 'Proceed to Checkout')]")).click();
		return new CheckOutStepOne(driver);
		
	}
	
	//Proceed to without Delivery option
	public CheckOutStepTwo proceedToCheckoutPickupOnly() 
	{
		driver.findElement(By.xpath("//a[contains(text(), 'Proceed to Checkout')]")).click();
		return new CheckOutStepTwo(driver);
		
	}
	
	//Estimate only message in the cart
	public WebElement estimateOnlyMessage() {
		
		return driver.findElement(By.xpath("//li[contains(text(), 'Total displayed here is an estimate')]"));
	}
	
	//Continue Shopping
	
	public StoreHomePage continueShopping()
	{
		
		driver.findElement(By.xpath("//a[contains(text(), 'continue shopping')]")).click();
		return new StoreHomePage(driver);
	}
	
	//Store homepage on Bread crumbs
	public StoreHomePage storeHome(){
		
		driver.findElement(By.xpath("//a[contains(text(), 'TEST STORE xox')]")).click();
		return new StoreHomePage(driver);
	}
	
}
