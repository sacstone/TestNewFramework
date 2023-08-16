package com.estore.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.junit.AfterClass;
//import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.ios.IOSDriver;

	public class AbstractTest {
		protected static WebDriver driver;
		String homeDir=System.getProperty("user.home");
		private static String amazonsURL;
	 
	public String getAmazonURL() { 
	    System.out.println("abstarct amazon url is "+  this.amazonsURL);
	    return this.amazonsURL; }
	
	public void setAmazonURL(final String amazonsURL) { this.amazonsURL = amazonsURL; }

	//======================================================================================================
	//Capabilities for iPhone 6s Simulator
	//======================================================================================================
/*	
   // @BeforeTest
    public void deviceone() throws Exception {
    	Resetall.main(null);
    	DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("appium-version", "1.6.3");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("deviceName", "iPhone 6s");
		capabilities.setCapability("platformVersion", "10.2");
		System.out.println("Home directory is" + homeDir);
		capabilities.setCapability("app", homeDir+"/Desktop/simbuild/WholeFoodsMarket.app");
		driver = new IOSDriver(new URL("http://127.0.01:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);   
    }

	//======================================================================================================
	//Capabilities for iPhone 6 Simulator
	//======================================================================================================
    
    public void devicetwo() throws Exception {
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	Resetall.main(null);
    	capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("appium-version", "1.6.3");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("deviceName", "iPhone 6");
		capabilities.setCapability("platformVersion", "10.2");
		System.out.println("Home directory is" + homeDir);
		capabilities.setCapability("app", homeDir+"/Desktop/simbuild/WholeFoodsMarket.app");
		driver = new IOSDriver(new URL("http://127.0.01:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
    }
   
	//======================================================================================================
	//Capabilities for iPhone7 Simulator
	//======================================================================================================

    public void devicethree() throws Exception {
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	Resetall.main(null);
    	capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("appium-version", "1.6.3");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("deviceName", "iPhone 7");
		capabilities.setCapability("platformVersion", "10.2");
		System.out.println("Home directory is" + homeDir);
		capabilities.setCapability("app", homeDir+"/Desktop/simbuild/WholeFoodsMarket.app");
		driver = new IOSDriver(new URL("http://127.0.01:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }
*/
	//======================================================================================================
	//Folder Creation 
	//======================================================================================================
    
    public void Foldercreation(){	
    	 DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		 //get current date time with Date()
		 Date date = new Date(0);
		 System.out.println(dateFormat.format(date));
		 //get current date time with Calendar()
		 Calendar cal = Calendar.getInstance();
		 System.out.println(dateFormat.format(cal.getTime()));
		 //   String testRundata = "TestRun"+(dateFormat.format(cal.getTime()));
		 String homeDir=System.getProperty("user.home");
	     String testRundata = "TestRun"+(dateFormat.format(cal.getTime()));
	     String callerMethodName = new Exception().getStackTrace()[2].getMethodName();
	     Path path = Paths.get(homeDir+"/Documents/iOSTestResults/"+testRundata+ "/iPhone6s/../iPhone7/../iPhone6");
		 //      Path path2 = Paths.get(homeDir+"/Documents/iOSTestResults/TestRun"+(dateFormat.format(cal.getTime())) + "/iPhone7../Earrings/../Etc");
		 //      Path path3 = Paths.get(homeDir+"/Documents/iOSTestResults/TestRun"+(dateFormat.format(cal.getTime())) + "/iPhone6../Earrings/../Etc");
	     try {
	    	 Files.createDirectories(path);
		     System.out.println("Directories Created");
		     //   Files.createDirectories(path2);
		     //  Files.createDirectories(path3);
		     }
	     catch (IOException e) {
	    	 System.err.println("Cannot create directories - " + e);
	    	 }
    }

	//======================================================================================================
	//Capture Screenshots
	//======================================================================================================
    
    public static void capturefinalscreen(String file_name) throws IOException{
    	DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		//get current date time with Date()
		Date date = new Date(0);
		System.out.println(dateFormat.format(date));
		//get current date time with Calendar()
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		//   String testRundata = "TestRun"+(dateFormat.format(cal.getTime()));
		
		String homeDir=System.getProperty("user.home");
		String callerMethodName = new Exception().getStackTrace()[2].getMethodName();
		String callerMethodName1 = new Exception().getStackTrace()[1].getMethodName();
		System.out.println("Caller method in Abstract is "+ callerMethodName);
		System.out.println("Caller method in Abstract1 is "+ callerMethodName1);
    	File folder = new File(homeDir+"/Documents/iOSTestResults/");
        File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
              if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
              } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
                if(listOfFiles[i].getName().contains("TestRun")){
                	
                	if(callerMethodName =="deviceonetest"){
                		
                		File iphone6sFolder = new File(homeDir+"/Documents/iOSTestResults/" +listOfFiles[i].getName()+"/iPhone6s/");
                		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    					FileUtils.copyFile(f,new File(iphone6sFolder + "/" + file_name + dateFormat.format(cal.getTime())));
    					amazonsURL = "https://s3.amazonaws.com/wfm-mobile-test/iostestresults/" + listOfFiles[i].getName()+"/iPhone6s/" + file_name + dateFormat.format(cal.getTime());
    					AmazonInfo(amazonsURL);
                	}
                	if(callerMethodName =="devicetwotest"){
                		File iphone6Folder = new File(homeDir+"/Documents/iOSTestResults/" +listOfFiles[i].getName()+"/iPhone6/");
                		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    					FileUtils.copyFile(f,new File(iphone6Folder + "/" + file_name + dateFormat.format(cal.getTime())));
    					System.out.println("https://s3.amazonaws.com/wfm-mobile-test/iostestresults/" + iphone6Folder + "/" + file_name + dateFormat.format(cal.getTime()));
                	}
                	if(callerMethodName =="devicethreetest"){
                		File  iphone7Folder = new File(homeDir+"/Documents/iOSTestResults/" +listOfFiles[i].getName()+"/iPhone7/");
                		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    					FileUtils.copyFile(f,new File(iphone7Folder + "/" + file_name + dateFormat.format(cal.getTime())));
    					System.out.println("https://s3.amazonaws.com/wfm-mobile-test/iostestresults/" + iphone7Folder + "/" + file_name + dateFormat.format(cal.getTime()));
                	}   	
                }
              }
            }
    }
    

	//======================================================================================================
	//Amazon URL
	//======================================================================================================
    
    public static String AmazonInfo(String amazonsURL){
    	System.out.println(amazonsURL);
    	return amazonsURL;
    }
    
    //======================================================================================================
  	//Check Notifications
  	//======================================================================================================
      

    public void handleNotificationAlert(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("STAY IN THE KNOW")));
			click(By.name("Not Now"));
		}
		catch(NoSuchElementException e){
			System.out.println("Stay in the Know Page not getting Displayed");
		}
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("GET STARTED")));
			click(By.name("AGREE & CONTINUE"));
		}
		catch(NoSuchElementException e){
			System.out.println("Get Started Screen not getting displayed");
		}
	}
    
	//======================================================================================================
	//TearDown
	//======================================================================================================
    
    private void click(By name) {
		// TODO Auto-generated method stub
		
	}

	@AfterTest
	public static void tearEnvironment(){
		System.out.println("Tearing after tests");
		driver.quit();
	}
}
