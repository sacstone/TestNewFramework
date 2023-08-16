package com.estore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmation {

	private WebDriver driver;

	public OrderConfirmation (WebDriver driver) 
	{
		
		this.driver = driver;
	}
	
	public String getTitle() 
	{
		return driver.getTitle();
		
	}
	
	public String getOrderNumber()
	{
		
		return driver.findElement(By.xpath("//a[contains(text(), '#')]")).getText();
		
	}
}
