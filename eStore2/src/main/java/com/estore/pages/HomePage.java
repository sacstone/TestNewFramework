package com.estore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();

	}
	
	
	public WebElement shopOnline(){
		
		return driver.findElement(By.xpath("//a[@href='/online-ordering']"));
	}
	
	

}
