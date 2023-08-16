package com.estore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBase {
	
	private WebDriver driver;
	
	public PageBase(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() 
	{
		return driver.getTitle();
		
	}
	
//	public void healthEatingLink()
//	{
//		driver.findElement(By.xpath("//a[@href = '/healthy-eating']"));
//		
//	}
//	
//	public void aboutOurProductsLink()
//	{
//		driver.findElement(By.xpath("//a[@href = '/about-our-products']"));
//		
//	}
//	public void missionAndValuesLink()
//	{
//		driver.findElement(By.xpath("//a[@href = '/mission-values']"));
//		
//	}
}
