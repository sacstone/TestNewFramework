package com.estore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;

public class CheckOutStepOne {
	
	//private WebDriver driver;
	private IOSDriver driver;

	public CheckOutStepOne(IOSDriver driver) {
		
		this.driver = driver;
	}
	
	public String getTitle() 
	{
		return driver.getTitle();
		
	}
	
	public void selectDeliveryOptions1()
	{
		try {
			driver.findElement(By.xpath("//input[@id='delivery']"));

		} catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
	
	}
	
	public WebElement selectDeliveryOptions()
	{
		return driver.findElement(By.xpath("//input[@id='delivery']"));
	}
	
	public void selectPickupOptions1()
	{
		
		
		try {
			driver.findElement(By.xpath("//input[@id='pickup']"));
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public WebElement selectPickupOptions()
	{
		
		return driver.findElement(By.xpath("//input[@id='pickup']"));
		
		
	}
	
	
	public void clickOnContinue(){
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	
	public CheckOutStepTwo clickOnContinue1(){
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		return new CheckOutStepTwo(driver);
	}
	
	//Store homepage on Bread crumbs
		public StoreHomePage storeHome(){
			
			driver.findElement(By.xpath("//a[contains(text(), 'TEST STORE xox')]")).click();
			return new StoreHomePage(driver);
		}
	

}
