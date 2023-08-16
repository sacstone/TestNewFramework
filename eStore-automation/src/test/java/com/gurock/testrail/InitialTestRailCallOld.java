package com.gurock.testrail;

//ipackage wfm.appium.APItest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

//import wfm.appium.testcases.CreateAccounttest;
//import wfm.appium.testcases.FacebookAccountCreationTest;
//import wfm.appium.testcases.GmailAccountCreationTest;

public class InitialTestRailCallOld {
	
	long getTestRunIdRail;
	
	static int caseto[] = {100308,118860,118862};
	
	
	public void testRailInitialcall(int caseid) throws MalformedURLException, IOException, APIException, InterruptedException{
		System.out.println("At Before Suite Call TestRail and FetchRunId"+ caseid);
		
		
		String callerClassName = new Exception().getStackTrace()[1].getClassName();
		System.out.println( "ClassName is " + callerClassName);
		
APIClient client = new APIClient("https://wholefoodsmarket.testrail.com/");
		
		client.setUser("qawfm2014@gmail.com");
		client.setPassword("Wholefoods2016");
		
	//	for (Object cases : caseto){
			
			
			
		
		ArrayList casenumber =  new ArrayList();
	//Adding all test cases	
		for (int i = 0; i < 3; i++)	{
			casenumber.add(caseto[i]);
			System.out.println("Printed" + caseto[i]);
			}
		
		//casenumber.add(caseid);
	//	casenumber.add(100308,118860,118862);
	
		Map data = new HashMap();
		data.put("suite_id",344 );
		
		if (callerClassName =="wfm.appium.testcases.CreateAccounttest"){
			data.put("name", "Appium Test Create Native Account!,Device :iphone 6s ");
			data.put("description", "Appium Test Create Native Account!,Device :iphone 6s");
		}else 
			if (callerClassName =="wfm.appium.testcases.GmailAccountCreationTest"){
				data.put("name", "Appium Test Gmail Account, Device :iphone 7");
				data.put("description", "Appium Test Gmail Account ,Device :iphone 7");
			}
			else 
				if (callerClassName =="wfm.appium.testcases.FacebookAccountCreationTest"){
					data.put("name", "Appium Test Facebook Account,Device :iphone 6");
					data.put("description", "Appium Test Facebook Account,Device :iphone 6");
				}
			
		
	//	data.put("name", "Test JAVA APPIUM facebook Test!");
	//	data.put("description", "Test JAVA facebook Test!");
		data.put("milestone_id", 2);
		data.put("include_all", false);
	data.put("case_ids", casenumber);
	
	
	
	
	
	//if (caseid ==118862){
	
	JSONObject createAndGetTestRunID = (JSONObject) client.sendPost("add_run/22",data);	
	
	JSONObject r = (JSONObject) client.sendPost("add_run/22",data);
	
	//	JSONObject p = (JSONObject) client.sendGet("add_run/2");
	//	System.out.println(r.get("id")); 
	
	Object TesTrunid =  r.get("id");
	System.out.println("Test Run Id is: "+TesTrunid);
	
	if(TesTrunid != null ){
		JSONObject p = (JSONObject) client.sendPost("get_runs/22",data);
		System.out.println("The Project runs are " + p );
	}
	
	getTestRunIdRail =  (Long) TesTrunid;
	System.out.println("GetRail id is" +getTestRunIdRail);
	
	//for (Object cases : casenumber){
	//	System.out.println("cases fetched" + casenumber );
		
		
		

		
	
			
	
//	} /*If Statement end */

	
		//}/*FOR Statement END* /	
	
	
	
		
	}

}
