package testng;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	
	public static void main(String args[]) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/rameshdhanekula/git/wfm365_automation/Browser_Drivers/chromedriverRamesh2.35");
		
		WebDriver d = new ChromeDriver();
		d.get("http://www.365bywholefoods.com");
		
		Thread.sleep(2000);
		
		d.switchTo().activeElement();
		
		d.findElement(By.xpath("//div[@data-smoke-id='ModalCloseButtonId']")).click();
		
		Thread.sleep(1000);
		
		d.findElement(By.xpath("//button[@data-smoke-id='HeaderHamburgerId']")).click();
		Thread.sleep(10000);
		
		d.switchTo().defaultContent().findElement(By.xpath("//A[@data-event-category='SecondaryNavList'][text()='On Sale']")).click();
		
		Thread.sleep(3000);
		
		System.out.println(d.findElement(By.xpath("//*[@id='react-view']/div/div/div/div/div[5]/div/div[3]/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div/a/div[1]")).getText());
	
		d.findElement(By.xpath("//*[@id='react-view']/div/div/div/div/div[5]/div/div[3]/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div/a/div[1]")).click();
		
		Thread.sleep(10000);
		
		System.out.println(d.switchTo().defaultContent().findElement(By.xpath("//*[@id='react-view']/div/div/div/div/div[5]/div/div[1]/div[2]/div/div/div[1]/div")).getText());
		

	}
}
