package testng;

import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;

public class Piyal {
	
	public static void main(String args[]) throws InterruptedException{
		
		
		
		
		String homePage = "http://www.qa5.thermofisher.com/order/genome-database/?pearUXVerSuffix=pearUX2&elcanoForm=true";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/rameshdhanekula/git/wfm365_automation/Browser_Drivers/chromedriverRamesh2.35");
		
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
	//	d.get("http://www.365bywholefoods.com");
		
		Thread.sleep(2000);
		d.get(homePage);
		//d.get("http://www.qa5.thermofisher.com/order/genome-database/?pearUXVerSuffix=pearUX2&elcanoForm=true");
		
		Thread.sleep(3000);
		d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/section/app-elcano-main/div[3]/div[1]/div[2]/div/div/div/app-search-form/div/div[2]/div[1]/app-simple-select/div/div[1]/div[1]")).click();
		Thread.sleep(1000);
		d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/section/app-elcano-main/div[3]/div[1]/div[2]/div/div/div/app-search-form/div/div[2]/div[1]/app-simple-select/div/div[2]/label[2]")).click();
		//Select s = new Select(d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/section/app-elcano-main/div[3]/div[1]/div[2]/div/div/div/app-search-form/div/div[2]/div[1]/app-simple-select/div/div[1]/div[1]")));
		//Select s = new Select(d.findElement(By.xpath("//div[@class='select-box active']")));
		//s.selectByVisibleText("Gene Expression");
		Thread.sleep(2000);
		
		d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/section/app-elcano-main/div[3]/div[1]/div[2]/div/div/div/app-search-form/div/div[2]/div[2]/div/div[2]/div[1]/button")).click();
		
		Thread.sleep(5000);
		
		
		WebElement menu = d.findElement(By.xpath("//div[@class='pd-r-15']/ul"));
		List<WebElement> menuList = menu.findElements(By.tagName("li"));

		for (WebElement list : menuList) {

			if (list.getText().contains("Pathways")) {
				list.click();
				break;

			}
		}
		
		
		
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) d;
		((JavascriptExecutor) d).executeScript("window.scrollBy(0,175)", "");
		Thread.sleep(2000);
		WebElement element = d
				.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/section/app-elcano-main/div[3]/div[4]/app-pathways-list/div/div/div/div/a[3]"));
		Wait<WebDriver> wait_element = new WebDriverWait(d, 10);
		wait_element.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

//		boolean reachedbottom = Boolean.parseBoolean(
//				js.executeScript("return $(document)" + ".height() == ($(window).height() + $(window).scrollTop());")
//						.toString());
//		while (!reachedbottom) {
//			((JavascriptExecutor) d).executeScript("window.scrollBy(0,175)", "");
//			Thread.sleep(2000);
//			try {
//				reachedbottom = Boolean.parseBoolean(js
//						.executeScript(
//								"return $(document).height() " + "== ($(window).height() + $(window).scrollTop());")
//						.toString());
//				WebElement element = d
//						.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/section/app-elcano-main/div[3]/div[4]/app-pathways-list/div/div/div/div/a[3]"));
//				Wait<WebDriver> wait_element = new WebDriverWait(d, 10);
//				wait_element.until(ExpectedConditions.elementToBeClickable(element));
//				element.click();
//				break;
//			} catch (Exception ex) {
//				Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//				System.out.println(ex.getMessage());
//			}
//		}
//		
		
		
		
		Thread.sleep(20000);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//	
//	//	/html/body/div[2]/div/div/div/div/div/section/app-elcano-main/div[3]/div[5]/div[2]/div/pathways-details-page/div/div[2]/p
//		
//	//	d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/section/app-elcano-main/div[3]/div[2]/div/div[1]/div[1]/div/div[3]/app-toggle-links/div/div/ul/li[3]/span")).click();
//		
//		Thread.sleep(5000);
//		
//		
//	d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/section/app-elcano-main/div[3]/div[4]/app-pathways-list/div/div/div/div/a[3]")).click();
//
//		
//	Thread.sleep(5000);
//		WebElement menu1 = d.findElement(By.xpath("//div[@class='pathways-list-container']/div"));
//		List<WebElement> menuList1 = menu1.findElements(By.tagName("a"));
//
//		for (WebElement list1 : menuList1) {
//			
////			if(list1.getText().equals("Glycine, Serine and Threonine Metabolism in M. loti")) {
////				
////				list1.click();
////			}
//
//			System.out.println(list1.getText());
////			if (list1.getText().contains("Pathways")) {
////				list1.click();
////				break;
////
////			}
//		}
//		/*			
//		Thread.sleep(2000);
//		
//		String s = d.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/section/app-elcano-main/div[3]/div[5]/div[2]/div/pathways-details-page/div/div[1]")).getText();
//		System.out.println(s);
//		
//		
//		//working above code..............
//		
//		for (WebElement list : menuList) {
//
//			if (list.getText().contains("Pathways")) {
//				list.click();
//				break;
//
//			}
//		}
//		
//		
//		
//		
//*/		
//		
//		Thread.sleep(2000);
//		
//List<WebElement> links = d.findElements(By.tagName("a"));
////        
//       Iterator<WebElement> it = menuList1.iterator();
////        
//        while(it.hasNext()){
//////            
//           url = it.next().getAttribute("href");
//////            
//           System.out.println(url);
//		
//		
//		
//		
//		
//		
//		
//		
//		
		
 //       }
		
		
		
		
		
		System.out.println("Test complete");
		d.close();
		
	}

}
