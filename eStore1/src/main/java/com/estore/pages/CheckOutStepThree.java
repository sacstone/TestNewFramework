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
		
	public WebElement storePickUpDateTime1() {
		
		return driver.findElement(By.xpath("//div[@class = 'bill-info'][1]"));
		
	}
	
	public WebElement itemTotals(){
		
		return driver.findElement(By.xpath("//ul[@class = 'list cart']"));
	}
	
	public void estimatePriceMessage() {

		driver.findElement(By.xpath("//li[@class = 'note']"));
	}
/*
	public WebElement subTotal() {

		// return
		// driver.findElement(By.xpath("html/body/div[1]/div/div/div[1]/div/div[1]/form[2]/div[2]/ul/li[2]/span/span/text()"));
		return driver.findElement(By.xpath(".//*[@id='checkoutForm']/div[2]/ul/li[2]/span/span"));
	}

	public String subTotal1() {

		return driver
				.findElement(
						By.xpath("html/body/div[1]/div/div/div[1]/div/div[1]/form[2]/div[2]/ul/li[2]/span/span/text()"))
				.getText();
	}

	public WebElement tax() {

		return driver.findElement(By.xpath(".//*[@id='checkoutForm']/div[2]/ul/li[3]/span/span"));
	}

	public WebElement estimatedTotal() {

		return driver.findElement(By.xpath(".//*[@id='checkoutForm']/div[2]/ul/li[3]/span/span"));
	}
	
	*/
	public void estimateOnlyMessage() {
		
		driver.findElement(By.xpath("//li[@class = 'note']")).getText();
		
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
