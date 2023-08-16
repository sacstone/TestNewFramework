package com.gurock.testrail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;



public class TestRailCall {
	
	static long getTestRunIdRail3;

	static int caseto[] = { 164204, 165253, 290457, 309172 };

	public static void testRailInitialCall() throws MalformedURLException, IOException, APIException {

		Date now = new Date();
		APIClient client = new APIClient("https://wholefoodsmarket.testrail.com/");
		client.setUser("qawfm2014@gmail.com");
		client.setPassword("Wholefoods2016");
		ArrayList casenumber = new ArrayList();
		int len = caseto.length;
		System.out.println("Testcases added to testrun are : ");
		for (int i = 0; i < len; i++) {
			casenumber.add(caseto[i]);
			System.out.println(caseto[i]);
		}

		Map data = new HashMap();
		data.put("suite_id", 344);
		data.put("name", now + " " + "eStore Functional Test run");
		data.put("description", "eStore health check");
		data.put("milestone_id", 2);
		data.put("include_all", false);
		data.put("case_ids", casenumber);

		JSONObject r = (JSONObject) client.sendPost("add_run/22", data);
		Object tesTrunid = r.get("id");
		
		
		getTestRunIdRail3 =  (Long) tesTrunid;
		
		System.out.println(getTestRunIdRail3);
		
	//	return (String) createAndGetTestRunID.get("id").toString();		
	//	System.out.println(TesTrunid);
	//	return (Long) (TesTrunid = (Long) TesTrunid);
		
	//	System.out.println(TesTrunid);

	}

	public static void addTestResultToTestrail(long tesTrunid, String testCaseID, String testResult) throws MalformedURLException, IOException, APIException {
		String comment;
		APIClient client = new APIClient("https://wholefoodsmarket.testrail.com/");
		client.setUser("qawfm2014@gmail.com");
		client.setPassword("Wholefoods2016");
		int statusID;

		if (testResult == "PASSED") {
			// ID 1 -> Passed
			statusID = 1;
			comment = "Actual vs Expected Matched";
		} else {
			// ID 1 -> Failed
			statusID = 5;
			comment = "Actual vs Expected didnot match, Test case failed ";

		}
		
		Map data = new HashMap();
	//	data.put("case_id", casenumber);
		data.put("status_id", statusID );
		data.put("comment", comment);
		//data.put("version", Constants.TESTRAIL_BUILD);
		data.put("milestone_id", 2);
		System.out.println(JSONValue.toJSONString(data));
		JSONObject logTestResultToCurrentTestRun = (JSONObject) client.sendPost("add_result_for_case/"+getTestRunIdRail3+"/"+testCaseID,data);

	}

}
