package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer 
{
	WebDriver ldriver;


	public AddCustomer(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how= How.XPATH, using ="//a[normalize-space()='New Customer']")
	WebElement linkAddNewCustomer;
	
	@FindBy(how= How.XPATH, using ="//input[@name='name']")
	WebElement txtCustomerName;
	
	@FindBy(how= How.XPATH, using ="//input[@value='m']")
	WebElement custGender;
	
	@FindBy(how= How.XPATH, using ="//input[@id='dob']")
	WebElement txtDOB;
	
	@FindBy(how= How.XPATH, using ="//textarea[@name='addr']")
	WebElement txtAddress;
	
	@FindBy(how= How.XPATH, using ="//input[@name='city']")
	WebElement txtCity;
	
	@FindBy(how= How.XPATH, using ="//input[@name='state']")
	WebElement txtState;
	
	@FindBy(how= How.XPATH, using ="//input[@name='pinno']")
	WebElement txtPinno;

	@FindBy(how= How.XPATH, using ="//input[@name='telephoneno']")
	WebElement txtTelephone;
	
	@FindBy(how= How.XPATH, using ="//input[@name='emailid']")
	WebElement txtEmail;
	
	@FindBy(how= How.XPATH, using ="//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(how= How.XPATH, using ="//input[@name='sub']")
	WebElement btnSubmit;
	
	
	public void clickAddNewCustomer()
	{
		linkAddNewCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender()
	{
		custGender.click();
	}
	
	public void custDob(String dob)
	{
		txtDOB.sendKeys(dob);
	}
	
	public void custAddress(String caddress)
	{
		txtAddress.sendKeys(caddress);
	}
	
	public void custCity(String ccity)
	{
		txtCity.sendKeys(ccity);
	}
	
	public void custState(String cstate)
	{
		txtState.sendKeys(cstate);
	}
	
	public void custPin(String cpin)
	{
		txtPinno.sendKeys(String.valueOf(cpin));
	}
	
	public void custPhone(String cphone)
	{
		txtTelephone.sendKeys(cphone);
	}
	
	public void custEmailid(String cemailid)
	{
		txtEmail.sendKeys(cemailid);
	}
	
	public void custPassword(String cpassword)
	{
		txtPassword.sendKeys(cpassword);
	}
	
	public void custSubmit()
	{
		btnSubmit.click();
	}

}
