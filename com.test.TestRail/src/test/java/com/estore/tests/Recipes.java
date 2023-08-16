package com.estore.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Recipes {

		@Test
		public void testq(){
		  System.setProperty("webdriver.chrome.driver",
					"/Users/rameshdhanekula/Downloads/chromedriver");
		  
		  WebDriver d = new ChromeDriver();
		  d.get("https://www.wholefoodsmarket.com");
	

		}

}
