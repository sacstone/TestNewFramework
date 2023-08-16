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
	
/*	public CategoryPage(WebDriver driver) {
		
		this.driver = driver;
		//this.categoryUrl = categoryUrl;
	}
	*/
	
	public String getTitle() 
	{
		return driver.getTitle();
		
	}
	
	public ProductDetailsPage deliveryOrPickup()
	
	{	driver.get(categoryUrl);
		//driver.findElement(By.xpath("//li[@data-product-name='$100 item']")).click();
		driver.findElement(By.xpath("//li[@data-product-name='TC-1']")).click();
		
		return new ProductDetailsPage(driver);
		
	}
	
	public ProductDetailsPage delivery()
	
	{	driver.get(categoryUrl);
		//driver.findElement(By.xpath("//li[@data-product-name='$100 item']")).click();
		driver.findElement(By.xpath("//li[@data-product-name='MF-1']")).click();
		
		return new ProductDetailsPage(driver);
		
	}
	
	public ProductDetailsPage pickupOnly()
	
	{	driver.get(categoryUrl);
		//driver.findElement(By.xpath("//li[@data-product-name='Automation Test - Variable Weight Item']")).click();
		driver.findElement(By.xpath("//li[@data-product-name='VW-1']")).click();
		return new ProductDetailsPage(driver);
		
	}
	

}
