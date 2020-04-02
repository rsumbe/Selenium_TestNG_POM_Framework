package com.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.*;

//@Listeners(com.listeners.CustomListener.class)
public class Test_001 extends BaseTest {
	LoginPage login;
	LogOut logout;

	@Test(description = "test to verify page title")
	public void test_login() throws Exception {
//		 driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		 driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		 driver.findElement(By.id("btnLogin")).click();

		login = page.GetInstance(LoginPage.class);
		logout = page.GetInstance(LogOut.class);

		login.EnterUsername("Admin");
		login.EnterPassword("admin123");
		login.ClickLoginBtn();

		login.verifyTitle("OrangeHRM");
		login.verifyTitle("OrangeHRM");
		logout.logoutFromApplication();

	}

	@Test(description = "test1 to verify page title")
	public void test_login1() throws Exception {
		login = page.GetInstance(LoginPage.class);
		logout = page.GetInstance(LogOut.class);
		login.EnterUsername("Admin");
		login.verifyTitle("titlevalue");
		//Assert.assertEquals(true, false);

	}

}
