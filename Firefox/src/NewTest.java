import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() throws InterruptedException {
	  
	  
		System.setProperty("webdriver.chromedriver", "/Users/rameshdhanekula/Downloads/chromedriver");
	//	WebDriver d = new SafariDriver();
		WebDriver d = new FirefoxDriver();
		d.get("http://365bywholefoods.com/");
		
	//	d.manage().window().maximize();
		
		d.findElement(By.xpath("//a[contains(text(),'Catalog G')]")).click();
		Thread.sleep(2000);
		
		
		WebElement menu= d.findElement(By.xpath("//div[@class='body_inner']/ul"));
		List<WebElement> menuList = menu.findElements(By.tagName("li"));
		
		for (WebElement list : menuList) {
			
			if (list.getText().contains("GC - 4")) {
				list.click();
				break;

			}
		}
		
		
	//	d.switchTo().activeElement().
//		d.findElement(By.xpath("//li[@data-product-name='TC-1']")).click();
		
		
		//System.out.println(d.getCurrentUrl());
	//	d.quit();
	//	d.close();

  }
}
