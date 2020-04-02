package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class LogOut extends BasePage {

	WebDriver driver;
	
	public LogOut(WebDriver driver)
	{
		super(driver);
		this.driver =driver;
	}
	
	@FindBy(id="welcome")
	WebElement welcomeText;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutButton;
	
	public void logoutFromApplication()
	{
		welcomeText.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
		//logoutButton.click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
	
	
}