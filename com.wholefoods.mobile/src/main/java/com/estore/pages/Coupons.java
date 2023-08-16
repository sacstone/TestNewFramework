package com.estore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;

public class Coupons {
	
	
	//private WebDriver driver;
	private IOSDriver driver;

	public Coupons (IOSDriver driver) 
	{
		
		this.driver = driver;
	}
	
	public WebElement digitalCoupon(){
		
		return driver.findElement(By.xpath("//h1[@class='digital-coupons__title']"));
		
	}
	
	public WebElement signOut(){
	
		WebElement menuOption = null;
		
		WebElement menu = driver.findElement(By.xpath("//a[@id='my_account']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(menu).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 5); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Out')]")));
		return menuOption = driver.findElement(By.xpath("//a[contains(text(),'Out')]"));
		
		
	}
	

}
