package firefoxgecko;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class F {

	public static void main(String[] args) {
		
		System.setProperty("WebDriver.gecko.driver", "/Users/rameshdhanekula/Downloads/geckodriver 4");
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities);
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://www.yahoo.com");
		driver.quit();
		
		
		// TODO Auto-generated method stub

	}

}
