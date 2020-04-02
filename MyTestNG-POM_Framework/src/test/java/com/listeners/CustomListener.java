package com.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListener implements ITestListener {

	// When Test case get failed, this method is called.
	// @Override
	public void onTestFailure(ITestResult Result) {
		
		BaseTest.extentTest.log(LogStatus.FAIL,
				BaseTest.extentTest.addScreenCapture(BaseTest.capture()) + "Test Failed");
	}

//
//  // When Test case get Skipped, this method is called.		
//  @Override		
//  public void onTestSkipped(ITestResult Result)					
//  {		
//  System.out.println("The name of the testcase Skipped is :"+Result.getName());					
//  }		
//
//  // When Test case get Started, this method is called.		
//  @Override		
//  public void onTestStart(ITestResult Result)					
//  {		
//  System.out.println(Result.getName()+" test case started");					
//  }		
//
	// When Test case get passed, this method is called.
	// @Override
	public void onTestSuccess(ITestResult Result) 
	{
		BaseTest.extentTest.log(LogStatus.PASS, "TC passed");
	}

}
