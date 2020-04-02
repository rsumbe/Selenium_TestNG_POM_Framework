package com.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.helper.ReadConfigProperty;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.CommonMethods;

public class BaseTest

{
	public static WebDriver driver = null;
	public PageGenerator page;
	public CommonMethods common;

	public static ExtentTest extentTest;

	static ExtentReports extentReport;

	@BeforeSuite
	public void setUp() throws Exception {
		ReadConfigProperty file = new ReadConfigProperty();

		if ("chrome".equalsIgnoreCase(file.getValue("browser"))) {
			// System.setProperty("webdriver.chrome.driver",StartWebDriver.class.getClassLoader().getResource("resources/chromedriver.exe").getPath());

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\P10500071\\eclipse-workspace\\MyTestNGFramework\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if ("firefox".equalsIgnoreCase(file.getValue("browser"))) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("invalid browser");
		}

		driver.get(file.getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		// Instantiate the Page Class
		page = new PageGenerator(driver);

		// Instantiate the CommonMethods Class
		common = new CommonMethods(driver);

		//
		extentReport = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html", true);
		// extentTest = extentReport.startTest("Flipkart search functionality");

	}

	@AfterSuite
	public void tearDown() {
		try {
			driver.close();
			driver.quit();
			if (driver != null)
				driver = null;
		} catch (Exception e) {

			e.printStackTrace();
		}

		extentReport.endTest(extentTest);
		extentReport.flush();
	}

	@BeforeClass
	public void beforeClass() {
		// extentReport = new ExtentReports(System.getProperty("user.dir") +
		// "\\ExtentReportResults.html", true);
		// extentTest = extentReport.startTest("Flipkart search functionality");

	}

	@BeforeMethod()
	public void beforeMethod(Method method) {
		// extentTest.log(LogStatus.INFO, extentTest.getTest().getName() + " started");
		extentTest = extentReport.startTest(method.getName());

		extentTest.log(LogStatus.INFO, method.getAnnotation(Test.class).description() + " ***started***");

		// extentTest.log(LogStatus.INFO, method.getName() + "started");

	}

	@AfterMethod()
	public void afterMethod(Method method) {
		// extentTest.log(LogStatus.INFO, extentTest.getTest().getName() + " started");

		extentTest.log(LogStatus.INFO, method.getAnnotation(Test.class).description() + "***End*** ");

	}

	public static String capture() {

		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()

					+ ".png");

			String errflpath = Dest.getAbsolutePath();

			FileUtils.copyFile(scrFile, Dest);

			return errflpath;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}

	@AfterClass
	public void afterClass() {
//		driver.close();
//		extentReport.endTest(extentTest);
//		extentReport.flush();
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
