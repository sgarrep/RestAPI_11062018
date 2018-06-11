package com.RestAPI.Automation.Zycus.Testcases.Base;

import org.testng.Assert;
import com.RestAPI.Automation.Zycus.util.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	public Xls_Reader xls = new Xls_Reader(ZYCUSConstants.DATA_XLS_PATH);


	public void reportFailure(String failureMessage){
		test.log(LogStatus.FAIL, failureMessage);
		Assert.fail(failureMessage);
		
	}


}
