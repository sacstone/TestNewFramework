package com.estore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutStepThree {
	
	private WebDriver driver;
	
	public CheckOutStepThree (WebDriver driver) 
	{
		
		this.driver = driver;
	}
	
	public String getTitle() 
	{
		return driver.getTitle();
		
	}
	
	public OrderConfirmation placeOrder()
	{
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@ng-click='submitOrder()']"))));
		element.click();
		return new OrderConfirmation(driver); 
		
		//driver.findElement(By.xpath("//div//button[contains(text(), 'PLACE ORDER')]")).click();
		//driver.findElement(By.xpath("//button[@ng-click='submitOrder()']")).click();
		
	}

}
