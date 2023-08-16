package com.estore.pages;

import java.text.DecimalFormat;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {
	
	private WebDriver driver;
	static String categoryUrl;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() 
	{
		return driver.getTitle();
		
	}
	
	//Item Price:
		
	public float getItemPrice() throws ParseException
	{	
		float actualPrice;
		String priceString = driver.findElement(By.xpath("//span[@ng-bind='displayprice']")).getText();
		DecimalFormat decimalFormat = new DecimalFormat("$");
		return actualPrice = decimalFormat.parse(priceString).floatValue();

	}
	
	public ProductDetailsPage addToCart()
	{
		driver.findElement(By.xpath("//span[contains(text(), 'Add to Cart')]")).click();
		return new ProductDetailsPage(driver);
		
	}
	public WebElement addToCartButton()
	{
		return  driver.findElement(By.xpath("//span[contains(text(), 'Add to Cart')]"));
		
		
	}
	

	public Cart clickCheckout(){
		
		driver.findElement(By.xpath("//button//a[contains(text(), 'Checkout')]")).click();
		return new Cart(driver);

	}
	
	
	
	public CategoryPage continueShopping(){
		
		driver.findElement(By.xpath("//a[contains(text(), 'Continue shopping')]")).click();
		
		String catergoryUrl = driver.getCurrentUrl();
		return new CategoryPage(driver, catergoryUrl);
		
	}
	
	public ProductDetailsPage selectOption(String selectDropdownOption)
	{
		Select selectOption = new Select(driver.findElement(By.name("itemOption[]")));
		selectOption.selectByVisibleText(selectDropdownOption);
		
		return new ProductDetailsPage(driver);
		
	}
	
	public WebElement itemQuantity()
	{
		
		return driver.findElement(By.id("qty"));
	}
	
	public WebElement itemPrice(){
		
		return driver.findElement(By.xpath("//span[@class='price ng-binding']"));
		
		
	}
	
	public WebElement quantityInPopup(){
		
		return driver.findElement(By.xpath("//p[@class = 'price_quant ng-binding']"));
	}
	
	public WebElement soldOutMessage()
	{
		
		return driver.findElement(By.xpath("//button[contains(text(), 'SOLD OUT ONLINE')]"));
	}
	
	public String delivryOptionsMessage()
	{
		
		return driver.findElement(By.xpath("//p[contains(text(), 'Delivery options')]")).getText();
	}
	
	public String callStoreMessage()
	{
		
		return driver.findElement(By.xpath("//p[contains(text(), 'Please call the store')]")).getText();
	}
	
	
	public String pickupInstoreMessage()
	{
		
		return driver.findElement(By.xpath("//p[contains(text(), 'NOTE')]")).getText();
	}
	
	//decreaase qty
	//		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
	//increase qty
	//		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	
}
