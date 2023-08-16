package com.estore.pages;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {
	
	private WebDriver driver;
	static String categoryUrl;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() 
	{
		return driver.getTitle();
		
	}
	
	//Item Price:
		
	public float getItemPrice() throws ParseException
	{	
		float actualPrice;
		String priceString = driver.findElement(By.xpath("//span[@ng-bind='displayprice']")).getText();
		DecimalFormat decimalFormat = new DecimalFormat("$");
		return actualPrice = decimalFormat.parse(priceString).floatValue();

	}
	
	public ProductDetailsPage addToCart()
	{
		driver.findElement(By.xpath("//span[contains(text(), 'Add to Cart')]")).click();
		
	//	ADD TO CART
		return new ProductDetailsPage(driver);
		
	}
	
	
	public WebElement addToCartButton()
	{
		return  driver.findElement(By.id("addToCart_btn"));
		
		
	}
	

	public Cart clickCheckout(){
		
		driver.findElement(By.xpath("//button//a[contains(text(), 'Checkout')]")).click();
		return new Cart(driver);

	}
	
	
	
	public CategoryPage continueShopping(){
		
		driver.findElement(By.xpath("//a[contains(text(), 'Continue shopping')]")).click();
		
		String catergoryUrl = driver.getCurrentUrl();
		return new CategoryPage(driver, catergoryUrl);
		
	}
	
	
	
	public CategoryPageOne continueShoppingOne(){
		
		driver.findElement(By.xpath("//a[contains(text(), 'Continue shopping')]")).click();
		
		String catergoryUrl = driver.getCurrentUrl();
		return new CategoryPageOne(driver);
		
	}
	
	
	
	public ProductDetailsPage selectOption(int index)
	{
		Select selectOption = new Select(driver.findElement(By.name("itemOption[]")));
		selectOption.selectByIndex(index);;
		
		
		return new ProductDetailsPage(driver);
		
	}
	
	public WebElement itemQuantity()
	{
		
		return driver.findElement(By.ByCssSelector.cssSelector("#qty"));
		
		
	}
	
	public String itemQuantity1()
	{
		String theTextIWant= null;	
		List<WebElement> values1 = driver.findElements(By.xpath("//input[@id = 'qty']"));
	for(WebElement el : values1)
	{
	  theTextIWant = el.getAttribute("value");
	 // System.out.println(theTextIWant);
	}

	return theTextIWant;
		
	}
	
	
	public WebElement itemPrice(){
		
		return driver.findElement(By.xpath("//span[@class='price ng-binding']"));
		
		
	}
	
	public WebElement breadCrum(String category){
		
		return driver.findElement(By.xpath("//a[contains(text()," + "'" + category + "'" + ")]"));
	//	return driver.findElement(By.xpath("//a[contains(text(), 'Catalog A')]"));
		
		
	}
	
	public WebElement quantityInPopup(){
		
		return driver.findElement(By.xpath("//p[@class = 'price_quant ng-binding']"));
	}
	
	public boolean soldOutMessage()
	{
		
		return driver.findElement(By.xpath("//button[contains(text(), 'SOLD OUT ONLINE')]")).isDisplayed();
	}
	
	public String delivryOptionsMessage()
	{
		
		return driver.findElement(By.xpath("//p[contains(text(), 'Delivery options')]")).getText();
	}
	
	public String callStoreMessage()
	{
		
		return driver.findElement(By.xpath("//p[contains(text(), 'Please call the store')]")).getText();
	}
	
	
	public String pickupInstoreMessage()
	{
		
		return driver.findElement(By.xpath("//p[contains(text(), 'NOTE')]")).getText();
	}
	
	public WebElement nutrifactsInfo(){
		
		return driver.findElement(By.xpath("//section[@class = 'product_description']"));
	
		
	}
	
	public void decreaseQty()
	{
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		
	}
	
	public void increaseQty()
	{
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		
	}
	

	
	
	//Store homepage on Bread crumbs
	public StoreHomePage storeHome(){
		
		driver.findElement(By.xpath("//a[contains(text(), 'TEST STORE xox')]")).click();
		return new StoreHomePage(driver);
	}
	
	//decreaase qty
	//		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
	//increase qty
	//		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	
	public String itemAdded(){
		
		return driver.findElement(By.xpath("//h3[@ng-bind]")).getText();
		
	}
	
}
