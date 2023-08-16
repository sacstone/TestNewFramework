package com.estore.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//import io.appium.java_client.ios.IOSDriver;

public class CaptureScreen {
	
	String folder_name;
	DateFormat df;
	
 //static WebDriver driver;
 protected static WebDriver driver;
	
	 public void captureScreenShots(String file_name) throws IOException {
	        folder_name="/Users/raameshdhanekula/Desktop/Results";
	        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        //create dir with given folder name
	        new File(folder_name).mkdir();
	        //Setting file name
	     //   file_name=df.format(new Date())+".jpg";
	        //coppy screenshot file into screenshot folder.
	        FileUtils.copyFile(f,new File(folder_name + "/" + file_name));
	    }

}
