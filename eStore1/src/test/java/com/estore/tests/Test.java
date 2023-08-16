package com.estore.tests;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

public class Test {

	public static void main(String[] args) throws ParseException {
		
		
		
		
		
		
		String s = "5 X $1.01";
		String s1 = "$26.99";
		//System.out.println(s1.replaceAll("[^0-9]", ""));;
		System.out.println(extractFloat(s));;
		
		System.out.println(extractFloat(s1));;
		
/*		
		String regex="([0-9]+[.][0-9]+)";
	//	String regex="([0-9]+[.])";
		String input= "4 X $100.00";

		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(input);

		while(matcher.find())
		{
		    System.out.println(matcher.group());
		}
	
*/		
		

	}
	
	
	  public static int extractInt(String str) {
	      Matcher matcher = Pattern.compile("\\d+").matcher(str);

	        if (!matcher.find())
	            throw new NumberFormatException("For input string [" + str + "]");

	        return Integer.parseInt(matcher.group());
	       // return Float.parseFloat(matcher.group());
	    }

		public static float getItemPrice(String str) throws ParseException
		{	
			//float actualPrice;
			//String priceString = driver.findElement(By.xpath("//span[@ng-bind='displayprice']")).getText();
			DecimalFormat decimalFormat = new DecimalFormat("$");
			return decimalFormat.parse(str).floatValue();

		}
		 
	  public static Float extractFloat(String str) {
		  
	
				Matcher matcher = Pattern.compile("([0-9]+[.][0-9]+)").matcher(str);

				if (!matcher.find())
		            throw new NumberFormatException("For input string [" + str + "]");

		        return Float.parseFloat(matcher.group());
	    }


}
