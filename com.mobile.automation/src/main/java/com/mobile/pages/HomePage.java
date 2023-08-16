package com.mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;

public class HomePage {
	
	
	private IOSDriver driver;


	public HomePage(IOSDriver driver) {
		this.driver = driver;
	}

	
	public void signIn(){
		
		driver.findElement(By.xpath("//a[@href ='/signin']")).click();

	}
	
	public void stores(){
		
		driver.findElement(By.xpath("//a[@href ='/stores/list']")).click();
		

		
	}
	public void search(){
		
		driver.findElement(By.xpath("//input[@id = 'edit-submit-56']")).click();

	}
	

}
