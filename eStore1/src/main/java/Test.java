import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Test {

	public static void main(String[] args) throws FindFailed {
		
		
		Screen sc = new Screen();
		
		Pattern image1 = new Pattern("/Users/rameshdhanekula/Documents/sikuli-1.png");
		 
		Pattern image2 = new Pattern("/Users/rameshdhanekula/Documents/s2.png");
		 
		Pattern image3 = new Pattern("/Users/rameshdhanekula/Documents/sikuli-6.png");
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/rameshdhanekula/Downloads/chromedriver");
		WebDriver d = new ChromeDriver();
		d.get("https://integration.365bywfm.com");
		d.manage().window().maximize();
		//WebDriverWait wait = new WebDriverWait(d, 30);
		//Alert a = wait.until(ExpectedConditions.alertIsPresent());
		
	//	Alert a =	d.switchTo().alert().authenticateUsing("aa","aa");
			//	.authenticateUsing(new UserAndPassword("uname", "Password"));
		// = d.switchTo().alert(); 
		
		
	//	a.authenticateUsing(new UserAndPassword("wfm","wfm"));
	//	a.accept();
		
///		sc.wait(2.0);
		
	sc.type(image1, "wfm");
	sc.type(image2, "365wfm2016");
	sc.click(image3);

		
		
	d.quit();

	}

}
