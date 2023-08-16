package com.estore.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.ios.IOSDriver;

public class CategoryPage {
	
	private IOSDriver driver;
	private String categoryUrl;
	
	public CategoryPage(IOSDriver driver, String categoryUrl) {
		
		this.driver = driver;
		this.categoryUrl = categoryUrl;
	}
	

	public String getTitle() 
	{
		return driver.getTitle();
		
	}
	

	public ProductDetailsPage selectProduct(String itemName)
	
	{	driver.get(categoryUrl);
	
		driver.findElement(By.xpath("//a[contains(text()," + "'" + itemName + "'" + ")]")).click();
		
		return new ProductDetailsPage(driver);
		
	}
	
	public String itemPrice(String itemName)
	
	{	
		driver.get(categoryUrl);
		return driver.findElement(By.xpath("//a[contains(text()," + "'" + itemName + "'" + ")]"+ "/following::div")).getText();
		
		
	}
	
	//Store homepage on Bread crumbs
			public StoreHomePage storeHome(){
				
				driver.findElement(By.xpath("//a[contains(text(), 'TEST STORE xox')]")).click();
				return new StoreHomePage(driver);
			}
	
	

	

}
