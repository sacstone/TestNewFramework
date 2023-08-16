package com.estore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StoreHomePage 
{
	
	private WebDriver driver;
	
	public StoreHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() 
	{
		return driver.getTitle();
		
	}
	
	public CategoryPage clickCategory() throws InterruptedException
	{
		
		String categoryUrl = driver.findElement(By.xpath("//a[contains(text(), 'Automation Test for Pick Up or Delivery (8-Noon)')]")).getAttribute("href");
		driver.findElement(By.xpath("//a[contains(text(), 'Automation Test for Pick Up or Delivery (8-Noon)')]")).click();
		Thread.sleep(2000);
		return new CategoryPage(driver, categoryUrl);
		
		//String categoryUrl = driver.getCurrentUrl();
		
		
		
	//	driver.findElement(By.xpath("//a[contains(text(), 'Pick Up Only')]")).click();
		
		//return new CategoryPage(driver, categoryUrl);
		
	//return new CategoryPage(driver);
		
		
		
	}
	
	//Top Nav
	public String storeName()
	{
		return driver.findElement(By.xpath("//h1[contains(text(), 'Whole Foods Market')]")).getText();
				
	}
	public boolean siteLogo()
	{
		return driver.findElement(By.id("site-logo")).isDisplayed();
				
	}
	public boolean shoppingCart()
	{
		return driver.findElement(By.xpath("//a[@class='cart_icon']")).isDisplayed();
				
	}
	
	
	//Bottom Nav
	public boolean bottomNavLogo()
	{
		return driver.findElement(By.xpath("//a[@title='Whole Foods Market homepage']")).isDisplayed();
				
	}
	
	public String healthEatingLink()
	{
		return driver.findElement(By.xpath("//a[@href = '/healthy-eating']")).getText();
				
	}
	public String aboutOurProducts()
	{
		return driver.findElement(By.xpath("//a[@href = '/about-our-products']")).getText();
				
	}
	public String missionAndValues()
	{
		return driver.findElement(By.xpath("//a[@href = '/mission-values']")).getText();
				
	}
	
	public String Recipes()
	{
		return driver.findElement(By.xpath("//a[@href = '/recipes']")).getText();
				
	}
	public String Blog()
	{
		return driver.findElement(By.xpath("//a[@href = '/blog/whole-story']")).getText();
				
	}
	public String storeLocations()
	{
		return driver.findElement(By.xpath("//a[@href = '/stores/list']")).getText();
				
	}
	
	public String customerService()
	{
		return driver.findElement(By.xpath("//a[contains(text(), 'Customer Service')]")).getText();
				
	}
	public String careers()
	{
		return driver.findElement(By.xpath("//a[@href = '/careers']")).getText();
				
	}
	public String storeDepartments()
	{
		return driver.findElement(By.xpath("//a[@href = '/store-departments']")).getText();
				
	}
	
	public boolean faceBook()
	{
		return driver.findElement(By.xpath("//a[@href = 'https://www.facebook.com/wholefoods']")).isDisplayed();
				
	}
	public boolean google()
	{
		return driver.findElement(By.xpath("//a[@href = 'https://plus.google.com/+wholefoods/posts']")).isDisplayed();
				
	}
	public boolean twitter()
	{
		return driver.findElement(By.xpath("//a[@href = 'https://twitter.com/wholefoods']")).isDisplayed();
				
	}
	
	public boolean youTube()
	{
		return driver.findElement(By.xpath("//a[@href = 'https://www.youtube.com/wholefoods']")).isDisplayed();
				
	}
	
	public boolean pinterest()
	{
		return driver.findElement(By.xpath("//a[@href = 'http://www.pinterest.com/wholefoods/']")).isDisplayed();
				
	}
	public boolean instagram()
	{
		return driver.findElement(By.xpath("//a[@href = 'http://instagram.com/wholefoodsmarket']")).isDisplayed();
				
	}
	public boolean disclosure()
	{
		return driver.findElement(By.xpath("//a[@href = 'https://www.wholefoodsmarket.com/sites/default/files/media/California_Transparency_in_Supply_Chains_Act_Disclosure.pdf']")).isDisplayed();
				
	}
	public boolean copyRight()
	{
		return driver.findElement(By.xpath("//p[@class='copy']")).isDisplayed();
				
	}
	public boolean termsOfUse()
	{
		return driver.findElement(By.xpath("//a[@href = '/terms-use']")).isDisplayed();
				
	}
	
	public boolean privacyPolicy()
	{
		return driver.findElement(By.xpath("//a[@href = '/privacy-policy']")).isDisplayed();
				
	}
	public boolean siteMap()
	{
		return driver.findElement(By.xpath("//a[@href = '/site-map']")).isDisplayed();
				
	}


}
