package com.utils;

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

}
