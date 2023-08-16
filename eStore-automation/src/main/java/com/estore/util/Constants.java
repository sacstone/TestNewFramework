package com.estore.util;

public class Constants {

//Path of xls files
	//public static final String SUITEA_XLS_PATH =System.getProperty("user.dir")+"\\executioninfo\\input-data\\AvailabilityRegressionSuite.xlsx";
	//public static final String SUITEB_XLS_PATH = System.getProperty("user.dir")+"\\executioninfo\\input-data\\SuiteB.xlsx";
	//public static final String TESTSUITE_XLS_PATH = System.getProperty("user.dir")+"\\executioninfo\\input-data\\TestSuite.xlsx";
	public static final String SUITE_AVAILABILITY_WITHOUTOVERWRITE_XLS_PATH = System.getProperty("user.dir")+"/executioninfo/RegressionSuite.xlsx";
	public static final String POSTGRES_JDBC_DRIVER = "org.postgresql.Driver";

//Sheet names
	public static final String TESTDATA_SHEET_MOVEMENT = "TestData-movement";
	public static final String TESTDATA_SHEET_AVAILABILITY_OVERWRITE = "TestData-availabilityOverwrite";
	public static final String TESTDATA_SHEET_STORES = "TestData_stores";


	public static final String TESTSUITE_SHEET = "TestSuite";
	public static final String TESTCASES_SHEET = "TestCases";
	

//Column name
	public static final String SUITENAME_COL = "SuiteName";
	public static final String RUNMODE_COL = "Runmode";
	public static final String TESTCASENAME_COL = "TestCaseName";
	public static final Object ITERATION_COL = "Iteration";
	public static final String TESTRAIL_ID = "TestRailID";
	
//RunMode
	public static final Object RUNMODE_YES = "Y";
	public static final Object RUNMODE_NO = "N";
	
//COnstants
	public static final String PASS = "Pass";
	public static final String FAIL= "Fail";
	
//Postgres DB info
	public static final String DB_URL = "jdbc:postgresql://192.168.56.103:5432/spice";
	public static final String DB_User = "postgres";
	public static final String DB_pwd = "";
	//public static final String POSTGRES_JDBC_DRIVER= "org.postgresql.Driver";
	
//movement sheet column names
	public static final Object IDENTIFIER_COL = "NatUPC";
	public static final Object BU_COL = "Store";
	public static final Object SUBTEAM_COL = "SubTeam";
	public static final Object TRANSACTIONCOUNT_COL = "ItemTransactionCount";
	public static final Object SALECOUNT_COL = "UnitSales";
	public static final Object CREATE_TS = "CreateDate";
	public static final String EXPECTED_AVAILABILITYRESULT = "ExpectedTestResult";
	
//Availability table  names
	public static final String TABLE_MOVEMENT = "movement";
	public static final String TABLE_MOVEMENT_IDENTIFIER_BU = "movement_identifier_bu";
	public static final String TABLE_AVAILABILITY = "availability";
	public static final String TABLE_AVAILABILITY_OVERWRITE = "availability_overwrite";
	public static final String TABLE_STORES = "stores";

	
//Stores sheet column names	
	public static final Object STORES_BU_COL = "bu";
	public static final Object STORES_TLC_COL = "tlc";
	public static final Object STORES_REGION_COL = "region";
	public static final Object STORES_STATUS_COL = "status";
		
//movement_identifier_bu table column names  
	public static final String TABLE_MOV_IDENT_BU_COL_MESSAGE = "message";

//Stores table column names  
	public static final String TABLE_STORES_COL_STATUS = "status";
//	public static final String TABLE_STORES_COL_BU = "bu";

	
//Availability Table column names
	public static final String TABLE_AVAILABILITY_COL_AVAILABLE_DEFAULT = "available_default";


//TestRail 
	public static final String TESTRAIL_URL = "https://wholefoodsmarket.testrail.com/";
	public static final String TESTRAIL_USERNAME = "qawfm2014@gmail.com";
	public static final String TESTRAIL_PWD = "Wholefoods2016";

//TestRail-CREATE TESRUN INFO
	public static final String TESTRAIL_SUITE_ID = "344"; //344, 564
	public static final String TESTRAIL_TESTRUN_NAME = "eStore Functional Test run";
	public static final String TESTRAIL_TESTRUN_DESC = "eStore health check";
	public static final String TESTRAIL_MILSTONE_ID = "2";

//TestRail-Update TestRun 
	public static final boolean TESTRAIL_INCLUDE_ALL = false; // false original
	public static final String TESTRAIL_BUILD = "v1.0";


//SPICE V3 COMMANDS
	public static final String BUILD_QUEUE_COMMAND = "bin/console movement:buildQueue pdoMq --env=dev -vvv";
	public static final String AVAILABILITY_CALCULATION_COMMAND = "bin/console availability:calculation --client=Default --env=dev -vvv";
	public static final String STORE_GETALL_COMMAND = "bin/console stores:getAll --env=dev -vvv";
	public static final String SPICEV3AVAILABILITYOVERWRITE_CSV_PATH = "/Users/remasreedharakurup/Sites/spice-v3/var/cache";
	public static final String AVAILABILITYOVERWRITE_IMPORT_COMMAND ="bin/console availability_overwrite:import --csv="+SPICEV3AVAILABILITYOVERWRITE_CSV_PATH+"/availOverwriteTestData.csv --env=dev";
	public static final String SPICE_ROOT = "/Users/remasreedharakurup/Sites/spice-v3";
	public static final String AVAILABILITYOVERWRITE_FILE_COPYCOMMAND = "cp -f /Users/remasreedharakurup/Sites/spicev3AutomationFramework/spicev3-availability/executioninfo/input-data/RegressionData/Movement/availOverwriteTestData.csv .";
   
	public static final String AVAILABILITYOVERWRITE_FILE_REMOVE_COMMAND = "rm -rf availOverwriteTestData.csv";




	
	
	








	
	
	
	
	
	

}
