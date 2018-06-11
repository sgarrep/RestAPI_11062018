package com.RestAPI.Automation.Zycus.Testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.RestAPI.Automation.Zycus.MockAPI;
import com.RestAPI.Automation.Zycus.Testcases.Base.BaseTest;
import com.RestAPI.Automation.Zycus.util.ZYCUSConstants;
import com.RestAPI.Automation.Zycus.util.DataUtil;
import com.relevantcodes.extentreports.LogStatus;

public class APIPostGetRequestTests extends BaseTest{
	
	String testCaseName="APIPostGetRequestTests";
	
	@Test(dataProvider="getData")
	@Parameters("testCaseName")
	public void VerifyAPIResponse(Hashtable<String,String> data) throws Throwable, ClientProtocolException,  IOException, JSONException {
		test = extent.startTest("Editing .." + testCaseName +".. Test");
		
		if(!DataUtil.isTestExecutable(xls, testCaseName) ||  data.get(ZYCUSConstants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as Rnumode is N");
			throw new SkipException("Skipping the test as Rnumode is N");
		}
				
		test.log(LogStatus.INFO, "Starting .." + testCaseName +".. test");
		
		MockAPI apiResponse = new MockAPI();
		String APIResponse =apiResponse.GetResponse(data.get("UrlWithInputData"),data.get("RequestType"));
				
		String actualResult="";
		
		
		if(APIResponse.contains("Failed"))
			{		
				reportFailure("API Test failed for Test case: "+testCaseName);
				actualResult = "Failed";
				test.log(LogStatus.FAIL, "API Test Failed for Test case: "+testCaseName);
			}
		else
			{
				
				actualResult = "Passed";
				test.log(LogStatus.PASS, "API Test Passed for Test case: "+testCaseName);
			}
		
		Assert.assertEquals(actualResult, "Passed", "API Test Failed for Test case: "+testCaseName);
	}
	
	
	
	@DataProvider
	public Object[][] getData(){
		return DataUtil.getData(xls, testCaseName);
	}
	

}
