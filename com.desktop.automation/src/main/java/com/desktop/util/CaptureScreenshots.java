package com.desktop.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class CaptureScreenshots {

	public static void captureScreenshot(WebDriver driver, String screenshotName) {
		try {

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(src, new File("./Screenshots/" + screenshotName + ".png"));
	//		FileUtils.copyFile(src, new File("./Screenshots/" + screenshotName + "_"
		//			+ (new SimpleDateFormat("MMddyyyy").format(new Date())) + ".png"));
			
		//	For screen shots in maven target folder
			FileUtils.copyFile(src, new File("./target/" + screenshotName + "_"
					+ (new SimpleDateFormat("MMddyyyy").format(new Date())) + ".png"));

		} catch (Exception e)

		{

			System.out.println("Error while taking sreenshot " + e.getMessage());

		}

	}

}
