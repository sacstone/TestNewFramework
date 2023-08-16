package com.estore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;



public class HomePage {
	
	//private WebDriver driver;
	private IOSDriver driver;

	public HomePage(IOSDriver driver) 
	{
		
		this.driver = driver;
	}
	
	
	public WebElement email(){
	
	return driver.findElement(By.xpath("//input[@name='email-address']"));
	}

	public WebElement password(){
		
	return driver.findElement(By.xpath("//input[@name='password']"));
	}
	
	public WebElement signInButton(){
		
	return driver.findElement(By.xpath("//input[@type='submit']"));
	}
	
	
	
	public Coupons signIn (String userName, String Password) throws InterruptedException{
		
		driver.findElement(By.xpath("//input[@name='email-address']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		
		return new Coupons(driver);
		
		//return Coupons(driver);
		
	}
	
	public void signIn1 (String userName, String Password) throws InterruptedException{
		
		driver.findElement(By.xpath("//input[@name='email-address']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

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
