package com.estore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage {
	
	private WebDriver driver;
	private String categoryUrl;
	
	public CategoryPage(WebDriver driver, String categoryUrl) {
		
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
	
	

	

}
