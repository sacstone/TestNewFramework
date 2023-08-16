package com.gurock.testrail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.ITestResult;

import com.estore.util.Constants;

//import com.spicev3.RegressionSuite.util.Constants;

public class TestRailManagerold {
	
	//static APIClient testRail = new APIClient("https://wholefoodsmarket.testrail.com/");
	static APIClient testRail = new APIClient(Constants.TESTRAIL_URL);


	public  String createTestRun(ArrayList<String> t ) throws MalformedURLException, IOException, APIException
	{
		Date now = new Date();
		testRail.setUser(Constants.TESTRAIL_USERNAME);
		testRail.setPassword(Constants.TESTRAIL_PWD);

		ArrayList <String> testrailTCID =new ArrayList<String>();		

		for (int i=0;i<t.size();i++) testrailTCID.add(t.get(i).replaceAll(".[0]+$", ""));		
		
		Map data = new HashMap();
		
		//suite_id-->The ID of the test suite for the test run
		//data.put("suite_id", 390 );
		  data.put("suite_id", Constants.TESTRAIL_SUITE_ID);
		
		//The name of the test run
		//data.put("name", "spicev3 Avalability process Automated regression testrun");
		data.put("name",now+" "+Constants.TESTRAIL_TESTRUN_NAME);
		
		//The description of the test run
		data.put("description", Constants.TESTRAIL_TESTRUN_DESC);
		
		//The ID of the milestone to link to the test run
		data.put("milestone_id",Constants.TESTRAIL_MILSTONE_ID);
		
		//True for including all test cases of the test suite and false for a custom case selection (default: true)
		data.put("include_all", Constants.TESTRAIL_INCLUDE_ALL);
		
		//An array of case IDs for the custom case selection
		data.put("case_ids", testrailTCID);
		
		System.out.println(JSONValue.toJSONString(data));

		JSONObject createAndGetTestRunID = (JSONObject) testRail.sendPost("add_run/22",data);		
		
		return (String) createAndGetTestRunID.get("id").toString();			
		
	}
	
	
	public static void addTestResultToTestRail(String testRUNID,String testCaseID,String testResult) throws MalformedURLException, IOException, APIException
	{
		
		String formatTestCaseID=testCaseID.replaceAll(".[0]+$", "");
		String comment;
		testRail.setUser(Constants.TESTRAIL_USERNAME);
		testRail.setPassword(Constants.TESTRAIL_PWD);
		int statusID;
		
		if (testResult=="PASSED") 
			{
			//ID 1 -> Passed
			statusID=1;	
			comment ="Actual vs Expected Matching";
			}
		else 
			{
			//ID 1 -> Failed
			statusID=5;	
			comment ="Actual vs Expected didnot match.First Check whether Create Date Data matches the Threshold config ";

			}
		
		Map data = new HashMap();

		data.put("status_id", statusID );
		data.put("comment", comment);
		data.put("version", Constants.TESTRAIL_BUILD);
		data.put("milestone_id",Constants.TESTRAIL_MILSTONE_ID);
		System.out.println(JSONValue.toJSONString(data));
		
		//POST index.php?/api/v2/add_result_for_case/:run_id/:case_id
		JSONObject logTestResultToCurrentTestRun = (JSONObject) testRail.sendPost("add_result_for_case/"+testRUNID+"/"+formatTestCaseID,data);
		
		
	}
	
	
	public static void DateCurrentTimeStamp()
	{
		Date now = new Date();
	}
	
	
}
