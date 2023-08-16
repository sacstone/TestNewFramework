package com.estore.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TC3 {

	public static void main(String[] args) {

		  System.setProperty("webdriver.chrome.driver",
					"/Users/rameshdhanekula/Downloads/chromedriver");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wholefoodsmarket.com");
		System.out.println(driver.getCurrentUrl());
		

	}

}
