package com.estore.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHandling {

	// Parse String into integer
	public static int extractInt(String str) {
		Matcher matcher = Pattern.compile("\\d+").matcher(str);

		if (!matcher.find())
			throw new NumberFormatException("For input string [" + str + "]");

		return Integer.parseInt(matcher.group());
	}

	// parse string into float
	public static float getItemPrice(String str) throws ParseException {

		DecimalFormat decimalFormat = new DecimalFormat("$");
		return decimalFormat.parse(str).floatValue();

	}
	
	//Extract float from string

	public static Float extractFloat(String str) {

		Matcher matcher = Pattern.compile("([0-9]+[.][0-9]+)").matcher(str);

		if (!matcher.find())
			throw new NumberFormatException("For input string [" + str + "]");

		return Float.parseFloat(matcher.group());
	}

	// to replace all numbers use this
	// String itemQtpPopup = sp.quantityInPopup().getText();

	// System.out.println(StringHandling.extractInt(itemQty));

	// System.out.println(itemQtpPopup.replaceAll("[^0-9]", ""));

}
