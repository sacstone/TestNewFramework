package com.estore.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase2 {

	public static void main(String[] args) {
		
		
	System.setProperty("webdriver.firefox.Marionette", "/Users/rameshdhanekula/Downloads/geckodriver");
		System.setProperty("webdriver.gecko.driver", "/Users/rameshdhanekula/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("https://www.wholefoodsmarket.com");
		System.out.println(driver.getTitle());
	}

}
