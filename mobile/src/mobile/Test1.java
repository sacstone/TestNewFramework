package mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import io.appium.java_client.ios.IOSDriver;

public class Test1 {
	
//	WebDriver wd;
	IOSDriver wd1;


	@Test
	public void f() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "iPhone 6s");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "10.3");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "safari");
		wd1 = new IOSDriver(new URL("http://127.0.01:4723/wd/hub"), capabilities);
		
		
		
		
		
		
		//wd1.
		wd1.get("http://www.wholefoodsmarket.com/shop/xox");
		Thread.sleep(2000);
		
		//swipe11(400, 325, 400, 54, 2000);
		
		
	//	MobileElement mk = (MobileElement) wd1.findElementByIosUIAutomation(using)
	//	wd1.swipe(startx, starty, endx, endy, duration);
	//	wd1.swipe(100, 465, 100, 700, 2000);
		swipe11(100, 465, 100, 700, 2000);
		wd1.findElement(By.xpath("//a[contains(text(), 'Catalog I')]")).click();
		Thread.sleep(2000);
		wd1.findElement(By.xpath("//a[contains(text(), 'IN-0')]")).click();
		
		
		System.out.println(wd1.getTitle());
	}
	
	public void swipe11(int swipe_start_x, int swipe_start_y, int swipe_end_x, int swipe_end_y, int duration) {
		int x = swipe_start_x;
		int y = swipe_start_y;
		int x_travel = swipe_end_x - swipe_start_x;
		int y_travel = swipe_end_y - swipe_start_y;
		TouchAction action1 = new TouchAction((MobileDriver) wd1).press(x, y).waitAction(duration)
				.moveTo(x_travel, y_travel).release();
		action1.perform();
	}

}


