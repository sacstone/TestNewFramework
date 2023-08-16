package com.estore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepOne {
	
	private WebDriver driver;

	public CheckOutStepOne(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String getTitle() 
	{
		return driver.getTitle();
		
	}
	
	public void selectDeliveryOptions()
	{
		try {
			driver.findElement(By.xpath("//input[@id='delivery']")).click();
			//xpath: delivery: //input[@id='delivery']
			//xpath: pickup: //input[@id='pickup']
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
	
	}
	public void selectPickupOptions()
	{
		
		
		try {
			driver.findElement(By.xpath("//input[@id='pickup']")).click();
			//xpath: delivery: //input[@id='delivery']
			//xpath: pickup: //input[@id='pickup']
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	public void clickOnContinue(){
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	

}
