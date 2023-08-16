package com.estore.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutStepThree {

	private WebDriver driver;

	public CheckOutStepThree(WebDriver driver) {

		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();

	}
	
	public WebElement itemCount() {
		
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return element = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//div[@class = 'order_summary']"))));
		//element.click();
		//return new OrderConfirmation(driver);
		
		//return driver.findElement(By.xpath("//p[contains(text(), 'ready to submit.')]"));
		//return driver.findElement(By.xpath("//div[@class = 'order_summary']"));
	}
	

	public String storePickUpAddresss() {
		
		
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//p[contains(text(), 'Location')]"))));
		element.click();
		return element.getText();
				//return driver.findElement(By.xpath("//p[contains(text(), 'Location')]")).getText();
	}
		
	public String storePickUpDateTime() {
		
		
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//p[contains(text(), 'Time:')]"))));
		element.click();
		return element.getText();

		//return driver.findElement(By.xpath("//p[contains(text(), 'Time:')]")).getText();
			
	}
		
/*	public WebElement storePickUpDateTime1() {
		
		return driver.findElement(By.xpath("//div[@class = 'bill-info'][1]"));
		
	}*/
	
	public WebElement itemTotals(){
		
		return driver.findElement(By.xpath("//ul[@class = 'list cart']"));
	}
	
	public void estimatePriceMessage() {

		driver.findElement(By.xpath("//li[@class = 'note']"));
	}

	
	public String estimateOnlyMessage() {
		
		return driver.findElement(By.xpath("//li[@class = 'note']")).getText();
		
	}
	
		

	public OrderConfirmation placeOrder() {

		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//button[@ng-click='submitOrder()']"))));
		element.click();
		return new OrderConfirmation(driver);

	}

	// Store homepage on Bread crumbs
	public StoreHomePage storeHome() {

		driver.findElement(By.xpath("//a[contains(text(), 'TEST STORE xox')]")).click();
		return new StoreHomePage(driver);
	}
}
