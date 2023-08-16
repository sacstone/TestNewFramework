package com.estore.tests;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import com.estore.util.StringHandling;

public class Raaa {
	WebDriver d;
	

	
	@Test
	
	public void rec() throws InterruptedException{
		
		  System.setProperty("webdriver.chrome.driver",
					"/Users/rameshdhanekula/Downloads/chromedriver");
		  
		  WebDriver d = new ChromeDriver();

		  d.get("https://www.wholefoodsmarket.com");
		  d.manage().window().maximize();
		  
	
		/*  
		  
			WebElement menu= d.findElement(By.xpath("//div[@class = 'block-inner clearfix']/ul"));
			List<WebElement> menuList=menu.findElements(By.tagName("li"));

			for (WebElement li : menuList) 
			{
				if (li.getText().equals("RECIPES")){
					li.click();
					break;
					
				}
			}
			
			Thread.sleep(1000);
			System.out.println(d.getCurrentUrl());
			
			d.quit();
		
		*/	
			
	}
	
public WebElement a(){
		
		WebElement aa = null;
		
		WebElement menu= d.findElement(By.xpath("//div[@class = 'block-inner clearfix']/ul"));
		List<WebElement> menuList=menu.findElements(By.tagName("li"));

		for (WebElement li : menuList) 
		{
			if (li.getText().equals("RECIPES")){
				aa = li;
				break;
				
			}
		}
		
		return aa;
		
		
	}

	
	
	
}


			
/*		 // 
		  
		  WebElement w = d.findElement(By.xpath("//ul[@class = 'menu clearfix']"));
		  List<WebElement> a = w.findElements(By.tagName("li"));
		  
		  
		  
		  
		//  List<WebElement> m = (List<WebElement>) w.findElement(By.tagName("li"));
		  
		//  System.out.println(a);
		  
		  Iterator<WebElement> itrS = a.iterator();
		  
			while (itrS.hasNext()) {

				String values = itrS.next().getText();
				
				System.out.println(values);

				if (values.contains("Recipes")) {
					
					d.findElement(By.xpath("//a[@href='/recipes']")).click();

					//float subTotalf = StringHandling.extractFloat(values);
					//subTotal = subTotalf;
				}
			}
		  
		  
		  /*
		List<WebElement> stotal = ckthree.itemTotals().findElements(By.tagName("li"));
		

		Iterator<WebElement> itrS = stotal.iterator();
		// float subTotal;
		while (itrS.hasNext()) {

			String values = itrS.next().getText();

			if (values.contains("SUBTOTAL")) {

				float subTotalf = StringHandling.extractFloat(values);
				subTotal = subTotalf;
			}
		}

		   */
			
			
			

		
		

