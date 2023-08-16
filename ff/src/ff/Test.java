package ff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	public static void main(String[] args) {
	//	System.setProperty("webdriver.firefox.driver", "/usr/local/bin/geckodriver");
		
	//	/usr/local/bin
		WebDriver d = new FirefoxDriver();
		d.get("http://www.wholefoodsmarket.com");
		System.out.println(d.getTitle());
		d.quit();
		
		// TODO Auto-generated method stub

	}

}
