package com.estore.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeSuite;

import com.estore.util.AbstractTest;
import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

public class AllTestSuites extends AbstractTest {
	
	String homeDir=System.getProperty("user.home");
	long getTestRunIdRail3;
	static int caseto[] = {164204};
	
	public void testRailsamplecall(int contents) throws MalformedURLException, IOException, APIException{
		
		
		System.out.println("At Before Suite Call TestRail and FetchRunId"+ contents);
		
		
		//======================================================================================================
		// Fetch the method and classname to determine which calls are made
		//======================================================================================================
		
		String callerClassName = new Exception().getStackTrace()[1].getClassName();
		String callerMethodName = new Exception().getStackTrace()[1].getMethodName();
		String callerMethodName2 = new Exception().getStackTrace()[2].getMethodName();
		String callerMethodName3 = new Exception().getStackTrace()[3].getMethodName();
		System.out.println( "ClassName is " + callerClassName);
		System.out.println( "MethodName 1 is " + callerMethodName);
		System.out.println( "MethodName 2 is " + callerMethodName2);
		System.out.println( "MethodName 3 is " + callerMethodName3);
		
		
		
		//====================================================================================================== 
		// Code to Read The Build version text file and pass that Build version value to 
		// Test Rail and update the top comment section 
		//======================================================================================================
		
		 String BuildVersion = "";
		 String file = homeDir+"/Desktop/simbuild/buildid.txt";
		 
		//======================================================================================================
		// Reading
		//======================================================================================================
		
		 try{
			 InputStream ips = new FileInputStream(file);
	         InputStreamReader ipsr = new InputStreamReader(ips);
	         BufferedReader br = new BufferedReader(ipsr);
	         String line;
	         while ((line = br.readLine()) != null){
	        	 BuildVersion += line + "/";
	        	 System.out.println("iOS Build Version/Number " + BuildVersion);
	        	 }
	            br.close();
	        }
	        catch (Exception e){
	            System.out.println(e.toString());
	        }
		 
		//======================================================================================================
		// Date & Time Implementation in Test Run
		//======================================================================================================
		 
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		 Date dateN = new Date();
		 String date= dateFormat.format(dateN);

		 
			//======================================================================================================
	        // Beginning of Test Rail Code 
	        // TestRail API call code
			//======================================================================================================
	         
			 APIClient client = new APIClient("https://wholefoodsmarket.testrail.com/");
			 client.setUser("qawfm2014@gmail.com");
			 client.setPassword("Wholefoods2016");
			 ArrayList casenumber =  new ArrayList();
			 int len = caseto.length;
			 for (int i = 0; i < len; i++)	{
				casenumber.add(caseto[i]);
				System.out.println("Printed" + caseto[i]);
				}

			 Map data = new HashMap();
			 data.put("suite_id", 344);
			 data.put("milestone_id", 2);
			 data.put("include_all", false);
			 data.put("case_ids", casenumber);
			 data.put("name", "eStore funtiona testing, Build Version/Number " + BuildVersion+" "+ date);
			 data.put("description", "eStore funtiona testing, Build Version/Number " + BuildVersion +" "+ date);
		
		 System.out.println("Before if statement " + casenumber);
		
		
		JSONObject r = (JSONObject) client.sendPost("add_run/22",data);
		Object TesTrunid =  r.get("id");
		System.out.println(TesTrunid);
		getTestRunIdRail3 =  (Long) TesTrunid;
		System.out.println("GetRail id is" +getTestRunIdRail3);
	
		
		
		
		}
	
	@BeforeSuite
	public void NewDirectory(){
		try{
			File folder = new File(homeDir+"/Documents/eStoreResults/");
			File[] listOfFiles = folder.listFiles();
			int i = 0;
			System.out.println("the list is" + listOfFiles);
			if(listOfFiles[i].getName().contains("TestRun")){
				System.out.println("Test Run directory exist");
				}
			else{
				Foldercreation();
				System.out.println("Begin directory creation");
        }
		}catch(Exception e){
			e.printStackTrace();
		}		
		
	}
	
	
	
	
	

		
}

