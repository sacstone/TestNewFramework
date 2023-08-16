package com.estore.pages;

import java.text.DecimalFormat;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	
	//Item the item Price:
		
	public float getItemPrice() throws ParseException
	{	
		float actualPrice;
		String priceString = driver.findElement(By.xpath("//span[@ng-bind='displayprice']")).getText();
		DecimalFormat decimalFormat = new DecimalFormat("$");
		return actualPrice = decimalFormat.parse(priceString).floatValue();
//		try {
//		return actualPrice = decimalFormat.parse(priceString).floatValue();
//			//double itemPrice = Math.round(decimalFormat.parse(a).doubleValue());
//			//System.out.println("Price of item : " +  q * itemPrice);
//		
//		} catch (ParseException e) {
//			System.out.println( " is not a valid number.");
//		}
		//return actualPrice;
	}
	
	public ProductDetailsPage addToCart()
	{
		driver.findElement(By.xpath("//span[contains(text(), 'Add to Cart')]")).click();
		return new ProductDetailsPage(driver);
		
	}
	

	public Cart clickCheckout(){
		
		//driver.findElement(By.xpath("//button[@ng-click='clickHref($event')]")).click();
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
	
	public String soldOutMessage()
	{
		
		return driver.findElement(By.xpath("//button[contains(text(), 'SOLD OUT ONLINE')]")).getText();
	}
	////button[contains(text(), 'SOLD OUT ONLINE')]

}
