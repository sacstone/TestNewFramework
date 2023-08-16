import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Tc1 {
	
	
	

	public static void main(String[] args) 
	
	{
		// TODO Auto-generated method stub
		
	//	System.setProperty("webdriver.gecko.driver", "/Users/rameshdhanekula/Downloads/geckodriver");
	//	System.setProperty("webdriver.firefox.marionette", "/Users/rameshdhanekula/Downloads/geckodriver");
	//	WebDriver d = new SafariDriver();
		WebDriver d = new FirefoxDriver();
		d.get("http://www.wholefoodsmarket.com");
		System.out.println(d.getCurrentUrl());
		System.out.println(d.getTitle());
		d.quit();

	}

}
