package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.base.BaseTest;
import com.utils.CommonMethods;

public class LoginPage extends BasePage
{

	public  WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	 //*********Web Elements by using Page Factory*********
    @FindBy(how = How.ID, using = "txtUsername")
    public WebElement username;
 
    @FindBy(how = How.ID, using = "txtPassword")
    public WebElement password;
 
    @FindBy(how = How.ID, using = "btnLogin")
    public WebElement loginButton;
	
	
//	WebElement user = driver.findElement(By.id("txtUsername"));
//	WebElement pass = driver.findElement(By.id("txtPassword"));
//	WebElement button =  driver.findElement(By.id("btnLogin"));
	
	
	public void EnterUsername(String un)
	{
		//user.sendKeys(un);
		CommonMethods.EnterTxt(username, un);
	}
	public void EnterPassword(String pw)
	{
		CommonMethods.EnterTxt(password, pw);
	}
	public LogOut ClickLoginBtn() throws Exception
	{
		//button.click();
		CommonMethods.Click(loginButton);
		
	   //return  PageFactory.initElements(driver,LogOut.class);
		
		return GetInstance(LogOut.class);
	}
	
	public void verifyTitle(String title)
	{
		CommonMethods.VerifyTitle(title);
	}
}
