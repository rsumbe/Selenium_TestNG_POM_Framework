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

	public static WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	 //*********Web Elements by using Page Factory*********
    @FindBy(how = How.ID, using = "txtUsername")
    public static WebElement username;
 
    @FindBy(how = How.ID, using = "txtPassword")
    public static WebElement password;
 
    @FindBy(how = How.ID, using = "btnLogin")
    public static WebElement loginButton;
	
	
//	WebElement usernameq = driver.findElement(By.id("txtUsername"));
//	WebElement password = driver.findElement(By.id("txtPassword"));
//	WebElement loginButton =  driver.findElement(By.id("btnLogin"));
	
	
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
