package com.estore.tests;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.estore.pages.StoreHomePage;

public class t {

	public static void main(String[] args) {
		
//	 	System.setProperty("webdriver.chrome.driver", "/Users/rameshdhanekula/Downloads/chromedriver");
		
//	  	WebDriver driver = new ChromeDriver();
 	WebDriver driver = new FirefoxDriver();
	//	driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://stage.wholefoodsmarket.com/shop/xox");
		
	//	System.out.println(driver.findElement(By.xpath("//a[contains(text(), 'Automation Test for Pick Up or Delivery (8-Noon)')]")).getAttribute("href"));;
	//	driver.findElement(By.xpath("//a[contains(text(), 'Automation Test for Pick Up or Delivery (8-Noon)')]")).click();
		
		StoreHomePage sh = new StoreHomePage(driver);
		//sh.clickCategory();
		System.out.println(driver.findElement(By.xpath("//a[contains(text(), 'Automation Test for Pick Up or Delivery (8-Noon)')]")).getAttribute("href"));;
		driver.findElement(By.xpath("//a[contains(text(), 'Automation Test for Pick Up or Delivery (8-Noon)')]")).click();;
		driver.findElement(By.xpath("//li[@data-product-name='$100 item']")).click();
/*	
		
		
		
		
		
		
//		driver.findElement(By.xpath("//span[contains(text(), 'Add to Cart')]")).click();
		
//		driver.findElement(By.linkText("Continue shopping")).click();
		
		
   To get the text of sold out item		
		//Select Dropdown option
		Select selectOption = new Select(driver.findElement(By.name("itemOption[]")));
		selectOption.selectByVisibleText("10-12 pounds / Serves 18-21");
		
		System.out.println(driver.findElement(By.xpath("//button[contains(text(), 'SOLD OUT ONLINE')]")).getText());
		

		
		

		
	//	String priceItemTest1 = driver
	//			.findElement(By.xpath(".//*[@id='page']/div[2]/div[2]/section[1]/form/section[1]/div/p/span"))
	//			.getText();
	//	double itemPrice = 0;
//		String a = driver.findElement(By.xpath("//span[@ng-bind='displayprice']")).getText();
//		int q = 2;
//		DecimalFormat decimalFormat = new DecimalFormat("$");
//		try {
//			float itemPrice = decimalFormat.parse(a).floatValue();
//			//double itemPrice = Math.round(decimalFormat.parse(a).doubleValue());
//			System.out.println("Price of item : " +  q * itemPrice);
//		} catch (ParseException e) {
//			System.out.println( " is not a valid number.");
//		}
		
		
//		System.out.println("done");
//		
		//instruction about the item quantity
		System.out.println(driver.findElement(By.xpath("//form/section[2]/p")).getText());
		
		
		//WebElement wb = driver.findElement(By.className("ng-dirty ng-valid ng-valid-number"));
		String price = driver.findElement(By.id("qty")).getAttribute("value");
		System.out.println(price);
		driver.findElement(By.id("qty")).clear();
		driver.findElement(By.id("qty")).sendKeys("2");
		//Minimum Quantity Alert box;
		try {
			Alert minQty = driver.switchTo().alert();
			System.out.println(minQty.getText());
			minQty.accept();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println(driver.findElement(By.id("qty")).getAttribute("value"));
		driver.findElement(By.id("qty")).sendKeys("1000");
		
		try {
			Alert minQty = driver.switchTo().alert();
			System.out.println(minQty.getText());
			minQty.accept();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}

		
		System.out.println(driver.findElement(By.id("qty")).getAttribute("value"));
		//decreaase qty
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		System.out.println(driver.findElement(By.id("qty")).getAttribute("value"));
		driver.findElement(By.xpath("//button[@type='button']")).click();
		System.out.println(driver.findElement(By.id("qty")).getAttribute("value"));
		//increase qty
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		
		System.out.println(driver.findElement(By.id("qty")).getAttribute("value"));
		//contains text()
		
		System.out.println(driver.findElement(By.xpath("//form/section[2]/p")).getText());
		//System.out.println(driver.switchTo().defaultContent().getWindowHandle());
	//	driver.findElement(By.xpath("//span[contains(text(), 'Add to Cart')]")).click();
		//System.out.println(driver.getCurrentUrl());
	//	driver.switchTo().defaultContent();
		//System.out.println(isElementPresent(By.xpath("//button[@ng-click='clickHref($event)']")));
	//	driver.findElement(By.xpath("//button[@ng-click='clickHref($event)']")).click();
		
		//span[@ng-bind='displayprice']
	
		
		
		//section//
		
		
		
		
	*/	
		
		
	}

}
