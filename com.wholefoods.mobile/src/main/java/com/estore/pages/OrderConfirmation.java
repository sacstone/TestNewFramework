package com.estore.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	//	return driver.findElement(By.xpath("//a[contains(text(), 'Confirmation number')]")).getText();
		
	}
	
public WebElement itemTax(){
//	WebElement element = null;
//	WebDriverWait wait = new WebDriverWait(driver, 30);
//	return element = wait.until(ExpectedConditions
//			.elementToBeClickable(driver.findElement(By.xpath("//ul[@class = 'receipt']"))));
	
	//element.click();
	return driver.findElement(By.xpath("//ul[@class = 'receipt']"));
	//Thread.sleep(5000);
///	return new OrderConfirmation(driver);
	
	
	
	
	
		
		//return driver.findElement(By.xpath("//ul[@class = 'receipt']"));
	}

	public String timeDetails(){
		
		return driver.findElement(By.xpath("//p[contains(text(), 'Pickup')]")).getText();
	}
	
	
	
}
