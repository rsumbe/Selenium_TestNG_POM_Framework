package com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class CommonMethods {
	public static WebDriver driver;

	public CommonMethods(WebDriver driver) {
		this.driver = driver;
	}

	public static void EnterTxt(WebElement element, String input) {

		element.sendKeys(input);
	}

	public static void Click(WebElement element) {

		element.click();
	}

	public static void VerifyTitle(String title) {

		if (driver.getTitle().equalsIgnoreCase(title)) {
			BaseTest.extentTest.log(LogStatus.PASS, "Title is matching with expected value");
		} else {
			BaseTest.extentTest.log(LogStatus.FAIL, "Title is NOT matched with expected value. Expected - " + title
					+ "  But found " + driver.getTitle());
		}

	}
	
	public static void VerifyTxt(WebElement actual,String expected) 
	{

		if (actual.getText().equalsIgnoreCase(expected))
		{
			BaseTest.extentTest.log(LogStatus.PASS, "Text is matching with expected value");
		} else {
			HighLightElement(actual);
			BaseTest.extentTest.log(LogStatus.FAIL, "Text is NOT matching with expected value. Expected - " + expected
					+ "  But found " + actual.getText() + BaseTest.extentTest.addScreenCapture(BaseTest.capture()));
		}

	}

	public static void HighLightElement(WebElement element)
	{
		System.out.println("HighLightElement called");
//		 JavascriptExecutor js = (JavascriptExecutor)driver;
//	     js.executeScript("arguments[0].style.cssText=border-width:8px;border-style:solid;border-color:red;", element);
		
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	
	     System.out.println("HighLightElement End");
	}
	

}
