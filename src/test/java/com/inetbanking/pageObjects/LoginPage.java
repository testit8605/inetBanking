package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{

	WebDriver ldriver;


	public LoginPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@name='uid']")
	WebElement textUserName; 

	@FindBy(xpath = "//input[@name='password']")
	WebElement textPassword; 

	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement btnLogin; 
	
	@FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement btnLogout;



	public void setUserName(String umane)
	{
		textUserName.sendKeys(umane);
	}

	public void setPassword(String pwd)
	{
		textPassword.sendKeys(pwd);
	}

	public void clickSubmit()
	{
		btnLogin.click();
	}

	
	public void clickLogout()
	{
		btnLogout.click();
	}
	
	public void loginToDemoGuruApplication(String umane, String pwd)
	{
		textUserName.sendKeys(umane);
		textPassword.sendKeys(pwd);
		btnLogin.click();
	}
	



}
