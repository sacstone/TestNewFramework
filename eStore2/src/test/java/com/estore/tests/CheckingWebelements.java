package com.estore.tests;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.estore.util.TestBase;

public class CheckingWebelements extends TestBase {
	
	@Test
	
	public void testingweb(){
		
	//	List<WebElement> elements = driver.findElements(By.tagName("a"));
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='block-wfm8-header-wfm8-header']"));
		
	//	System.out.println(Integer.toString(elements.size()));
		
		for(WebElement el:elements){
			
			Assert.assertTrue(el.getText().contains("Find a Store"), "Don't see the link text in the header");
			Assert.assertTrue(el.getText().contains("Sign in"), "Don't see the link text in the header");
			Assert.assertTrue(el.getText().contains("Register"), "Don't see the link text in the header");
			Assert.assertTrue(el.getText().contains("Coupons"), "Don't see the link text in the header");
			Assert.assertTrue(el.getText().contains("Local Sales"), "Don't see the link text in the header");
			Assert.assertTrue(el.getText().contains("Recipes"), "Don't see the link text in the header");
			Assert.assertTrue(el.getText().contains("Shop Online"), "Don't see the link text in the header");
			Assert.assertTrue(el.getText().contains("Customer Service"), "Don't see the link text in the header");
		}
		
		
	}
	
    @Test
    public void testImageComparison() throws IOException, InterruptedException {         
       File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       Thread.sleep(3000);
       FileUtils.copyFile(screenshot, new File("homeOutput.jpg"));

       File fileInput = new File("homeInput.jpg");
       File fileOutPut = new File("homeOutput.jpg");

       BufferedImage bufferfileInput = ImageIO.read(fileInput);
       DataBuffer bufferfileInput1 = bufferfileInput.getData().getDataBuffer();
       int sizefileInput = bufferfileInput1.getSize();                     
       BufferedImage bufferfileOutPut = ImageIO.read(fileOutPut);
       DataBuffer datafileOutPut = bufferfileOutPut.getData().getDataBuffer();
       int sizefileOutPut = datafileOutPut.getSize();
       Boolean matchFlag = true;
       if(sizefileInput == sizefileOutPut) {                         
          for(int i=0; i<sizefileInput; i++) {
                if(bufferfileInput1.getElem(i) != datafileOutPut.getElem(i)) {
                      matchFlag = false;
                      break;
                }
           }
       }
       else {                           
          matchFlag = false;
       Assert.assertTrue(matchFlag, "Images are not same");    
    }
    }

}
