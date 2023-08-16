package com.gurock.testrail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

//import wfm.appium.utils.AbstractPageObject;

public class APIAfterTestCallold {
	
	


	public Long TesTrun;
	
	

	
public boolean InitializeTestRail(int Status, int caseid, String TestComment, long getTestRunIdRail) throws MalformedURLException, IOException, APIException {
		
		System.out.println("The current Test run value is" +getTestRunIdRail);
		
		String callerClassName = new Exception().getStackTrace()[1].getClassName();
		System.out.println( "ClassName is " + callerClassName);
		
		
//	if(TesTrun==null){
			
		
		APIClient client = new APIClient("https://wholefoodsmarket.testrail.com/");
		
		client.setUser("qawfm2014@gmail.com");
		client.setPassword("Wholefoods2016");
		
		//164204,165253,290457
		
		ArrayList casenumber =  new ArrayList();
		casenumber.add(caseid);
	//	casenumber.add(118860);
	
		Map data = new HashMap();
		if(caseid==164204 || caseid==165253 || caseid==290457){
			data.put("suite_id",344);
		}
		else{
			data.put("suite_id", 344);
		}
/*		
		if (callerClassName =="wfm.appium.testcases.CreateAccounttest"){
			data.put("name", "Appium Test Create Native Account!");
			data.put("description", "Appium Test Create Native Account!");
		}else {
			data.put("name", "Appium Test Gmail Account!");
			data.put("description", "Appium Test Gmail Account!");
			
		}
*/			
	//	data.put("name", "Test JAVA APPIUM RUN Test!");
	//	data.put("description", "Test JAVA APPIUM RUN Test!");
		data.put("milestone_id", 2);
		data.put("include_all", false);
	data.put("case_ids", casenumber);
	
	
	
	//JSONObject r = (JSONObject) client.sendPost("add_run/2",data);
	
	//	JSONObject p = (JSONObject) client.sendGet("add_run/2");
	//	System.out.println(r.get("id")); 
	
	//Object TesTrunid =  r.get("id");
	//System.out.println(TesTrunid); 
	//TesTrun = (Long) TesTrunid;
	
	
	
	
	
		//data.put("case_ids",caseidArray);
		//System.out.println(JSONValue.toJSONString(data));
	
	
		
		
		for (Object cases : casenumber){
			
			
			
			//Map data2 = new HashMap();
			data.put("case_id", casenumber);
			data.put("status_id",Status );
		//	data.put("comment",TestComment +"\n"+ amazonUrl);
			System.out.println(data);
		//	System.out.println("The test comment is" +TestComment +"\n"+ amazonUrl);
			System.out.println(getTestRunIdRail);
			System.out.println(casenumber);
			System.out.println(cases);
			
			JSONObject addtest = (JSONObject) client.sendPost("add_result_for_case/"+getTestRunIdRail+"/"+cases,data);
			
		//	JSONObject multipletest = (JSONObject) client.sendPost("add_results_for_cases/"+getTestRunIdRail+"/"+cases,data);
			
			
			//JSONObject addtest2 = (JSONObject) client.sendPost("add_result_for_case/"+TesTrunid+"/118860",data2);
//			int TestRunid = (int) data.get("id");
			//System.out.println(TestRunid);
			
			
//			System.out.println(r);
		//	System.out.println(multipletest);
			
			
			
		}
	/*else {
APIClient client = new APIClient("https://wholefoodsmarket.testrail.com/");
		
		client.setUser("qawfm2014@gmail.com");
		client.setPassword("Wholefoods2016");
		

		
		ArrayList casenumber =  new ArrayList();
		casenumber.add(caseid);
	//	casenumber.add(118860);
	
		Map data = new HashMap();
		data.put("suite_id",2 );
		data.put("name", "Test JAVA APPIUM RUN Test!");
		data.put("description", "Test JAVA APPIUM RUN Test!");
		data.put("milestone_id", 1);
		data.put("include_all", false);
	data.put("case_ids", casenumber);
	
	
	
	//JSONObject r = (JSONObject) client.sendPost("add_run/2",data);
	
	//	JSONObject p = (JSONObject) client.sendGet("add_run/2");
	//	System.out.println(r.get("id")); 
	

	
	
	
	
	
		//data.put("case_ids",caseidArray);
		//System.out.println(JSONValue.toJSONString(data));
	
	
		
		
		for (Object cases : casenumber){
			
			
			
			//Map data2 = new HashMap();
			
			data.put("status_id",Status );
			data.put("comment",TestComment);
			System.out.println(data);
			System.out.println("The test comment is" +TestComment);
			System.out.println(TesTrun);
			System.out.println(casenumber);
			System.out.println(cases);
			
			JSONObject addtest = (JSONObject) client.sendPost("add_result_for_case/"+TesTrun+"/"+cases,data);
			//JSONObject addtest2 = (JSONObject) client.sendPost("add_result_for_case/"+TesTrunid+"/118860",data2);
//			int TestRunid = (int) data.get("id");
			//System.out.println(TestRunid);
			
			
//			System.out.println(r);
			System.out.println(addtest);
			
	}
	
			


}*/
		
		return true;
	}
	




/*public void AfterEachStep(Object tesTrunid2) throws MalformedURLException, IOException, APIException {
	

	APIClient client = new APIClient("https://wholefoodsmarket.testrail.com/");
	
	
	
	client.setUser("qawfm2014@gmail.com");
	client.setPassword("Wholefoods2016");
	
	Map data2 = new HashMap();
	
	data2.put("status_id",tesTrunid2 );
	data2.put("comment",TestComment );
	
	JSONObject addtest = (JSONObject) client.sendPost("add_result_for_case/"+TesTrunid+"/100308",data2);
	JSONObject addtest2 = (JSONObject) client.sendPost("add_result_for_case/"+TesTrunid+"/118860",data2);
//	int TestRunid = (int) data.get("id");
	//System.out.println(TestRunid);
	
	
//	System.out.println(r);
	System.out.println(addtest);
	
}*/

}
