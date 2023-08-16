package com.estore.tests;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Raa2 {
	
	@Test
	public void raaaa() throws InterruptedException{
		
		  System.setProperty("webdriver.chrome.driver",
					"/Users/rameshdhanekula/Downloads/chromedriver");
		  
		  WebDriver d = new ChromeDriver();
		  d.get("https://www.wholefoodsmarket.com");
		  d.manage().window().maximize();
		  Thread.sleep(1000);
			WebElement menu= d.findElement(By.xpath("//div[@class = 'block-inner clearfix']/ul"));
			List<WebElement> menuList=menu.findElements(By.tagName("li"));
			
			// Iterator<WebElement> itrS = menuList.iterator();
			
			//while(itrS.hasNext()){
			for(WebElement list: menuList)	{
			//	String values = itrS.next().getText();
				if (list.getText().equals("RECIPIES")){
					
					list.click();
				}
			
			}
	//		for(WebElement li : menuList)
				//if(li.getText().equals("RECIPES")){
	//			System.out.println(li.getText());
					//li.click();
				//}
		//	System.out.println(d.getCurrentUrl());
			
		//	Thread.sleep(1000);
			
		//	System.out.println(d.getCurrentUrl());
			
			/*
			WebElement countryUL= driver.findElement(By.xpath("//[@id='country_id']/ul"));
			List<WebElement> countriesList=countryUL.findElements(By.tagName("li"));
			for (WebElement li : countriesList) {
			if (li.getText().equals("India (+91")) {
			     li.click();
			   }
			}
		*/
		
	}

}
