package com.estore.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

//import com.spicev3.RegressionSuite.util.Constants;
//import com.spicev3.RegressionSuite.util.Xls_Reader;

public class Utility {
	/*
public static Object[][] getData(String testCase,Xls_Reader xls){


	
		//find the row num for the test
		int testCaseRowNum=1;			

		while(!(xls.getCellData(Constants.TESTDATA_SHEET, 0, testCaseRowNum).trim().toLowerCase().equals(testCase.toLowerCase()))){	

			testCaseRowNum++;
		}
		//System.out.println("PRINTING the testcase name in the check process after While when matched  "+xls.getCellData(Constants.TESTDATA_SHEET, 0, testCaseRowNum).trim());			
		//System.out.println("PRINTING the testcase name received after While When Matched "+testCase.trim());
		
		//System.out.println("TestCaseName  Identified at Row Number "+testCaseRowNum);
		int colStartRowNum=testCaseRowNum+1;
		int dataStartRowNum=testCaseRowNum+2;
		int rows=0;
		//find total rows of data for a testcase
		while(!(xls.getCellData(Constants.TESTDATA_SHEET, 0, dataStartRowNum+rows).trim().toLowerCase().equals(""))){
			rows++;
		}
		//System.out.println("No: of data rows identified for testcase  "+testCase+ " is " +rows);
		//Total number of columns
		int cols=0;
		while(!(xls.getCellData(Constants.TESTDATA_SHEET, cols, colStartRowNum).trim().equals(""))){
			cols++;
		}
		//System.out.println("Total Columns identified is  :"+cols);
		//Print the data
		Object[][] testData=new Object[rows][1];
		int i=0;
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++){
			Hashtable<String,String> table=new Hashtable<String,String>();
			for(int cNum=0;cNum<cols;cNum++)
			{
				//value for the map ---the cell data
				String data=xls.getCellData(Constants.TESTDATA_SHEET, cNum, rNum);
				
				//key for the map---the colname
				String colName=xls.getCellData(Constants.TESTDATA_SHEET, cNum, colStartRowNum);

				table.put(colName, data);
				
			}
			System.out.println("Hashtable-->"+table);

			testData[i][0]=table;
			System.out.println("2D-->"+testData[i][0]);

			i++;
		}

	return testData;

}
*/
	
	public static Object[][] getData(String testDataSheet,String testCase,Xls_Reader xls){


		
		//find the row num for the test
		int testCaseRowNum=1;			

		//while(!(xls.getCellData(Constants.TESTDATA_SHEET, 0, testCaseRowNum).trim().toLowerCase().equals(testCase.toLowerCase()))){	
		while(!(xls.getCellData(testDataSheet, 0, testCaseRowNum).trim().toLowerCase().equals(testCase.toLowerCase()))){	

			testCaseRowNum++;
		}
		//System.out.println("PRINTING the testcase name in the check process after While when matched  "+xls.getCellData(Constants.TESTDATA_SHEET, 0, testCaseRowNum).trim());			
		//System.out.println("PRINTING the testcase name received after While When Matched "+testCase.trim());
		
		//System.out.println("TestCaseName  Identified at Row Number "+testCaseRowNum);
		int colStartRowNum=testCaseRowNum+1;
		int dataStartRowNum=testCaseRowNum+2;
		int rows=0;
		//find total rows of data for a testcase
		while(!(xls.getCellData(testDataSheet, 0, dataStartRowNum+rows).trim().toLowerCase().equals(""))){
			rows++;
		}
		//System.out.println("No: of data rows identified for testcase  "+testCase+ " is " +rows);
		//Total number of columns
		int cols=0;
		while(!(xls.getCellData(testDataSheet, cols, colStartRowNum).trim().equals(""))){
			cols++;
		}
		//System.out.println("Total Columns identified is  :"+cols);
		//Print the data
		Object[][] testData=new Object[rows][1];
		int i=0;
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++){
			Hashtable<String,String> table=new Hashtable<String,String>();
			for(int cNum=0;cNum<cols;cNum++)
			{
				//value for the map ---the cell data
				String data=xls.getCellData(testDataSheet, cNum, rNum);
				
				//key for the map---the colname
				String colName=xls.getCellData(testDataSheet, cNum, colStartRowNum);

				table.put(colName, data);
				
			}
			System.out.println("Hashtable-->"+table);

			testData[i][0]=table;
			System.out.println("2D-->"+testData[i][0]);

			i++;
		}

	return testData;

} static Logger initLogs(Class clazz,String append){
	FileAppender appender=new FileAppender();
	appender.setFile(System.getProperty("user.dir")+"\\executioninfo\\logs\\"+append+".log");
	//appender.setLayout(new PatternLayout("%d %-5p [%c{1} %m%n]"));
	appender.setLayout(new PatternLayout("%d{dd/MM/yyyy HH:mm:ss} %c %m%n"));
	appender.setAppend(false);
	appender.activateOptions();
	Logger APPLICATION_LOGGER=Logger.getLogger(clazz.getName()+"_"+append);
	APPLICATION_LOGGER.setLevel(Level.DEBUG);
	APPLICATION_LOGGER.addAppender(appender);
	return APPLICATION_LOGGER;
	
	
	
}

public static int convertToEpoch(String strDate) throws ParseException
{
	SimpleDateFormat format=new SimpleDateFormat("MM/dd/yy");	
	Date formattedCreate_ts=format.parse(strDate);
	long EpochTime=formattedCreate_ts.getTime();
	int EpochTimeInt=(int) (EpochTime/1000);
	
	return EpochTimeInt;

}

public static void runExternalProgram(String extProgram,String execPath) throws InterruptedException
{

	
	try {
		
		System.out.println("TRIGEERING EXTERNAL PROCESS ---->"+extProgram);
		ProcessBuilder pb = new ProcessBuilder("/bin/bash","-c",extProgram); 
		Map<String, String> env = pb.environment();
		String path = env.get("PATH");
		path = "/usr/local/bin:" + path;
		env.put("PATH", path);
			
		path = env.get("PATH");
		//System.out.println(path);
		//Constants.SPICE_ROOT
		pb.directory(new File(execPath));
		Process p= pb.start();
		p.waitFor();
		   BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		   String str = null;
		   while ((str = br.readLine()) != null) 
		    {
		        System.out.println(str);
		    }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}					
    
		//TimeUnit.MINUTES.sleep(2);
		TimeUnit.SECONDS.sleep(10);

}

public static boolean isTestCaseRunnable(String testcaseName,Xls_Reader xls) {
	int rows=xls.getRowCount(Constants.TESTCASES_SHEET);
	for(int rowNum=2;rowNum<=rows;rowNum++){
		String testCaseName=xls.getCellData(Constants.TESTCASES_SHEET, Constants.TESTCASENAME_COL, rowNum);
		if(testCaseName.toLowerCase().equals(testcaseName.toLowerCase())){
			String runMode=xls.getCellData(Constants.TESTCASES_SHEET, Constants.RUNMODE_COL, rowNum);
			if(runMode.equals(Constants.RUNMODE_YES))
				return true;
			else
				return false;
		}
		
	}
	return false;
	// TODO Auto-generated method stub
	
}











	
}
