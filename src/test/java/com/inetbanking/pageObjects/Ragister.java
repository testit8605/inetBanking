package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Ragister 
{
	
	WebDriver ldriver;
	
	public Ragister(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement textcustFirstName;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement textcustLastName;
	
	@FindBy(xpath = "//textarea[@class='form-control ng-pristine ng-valid ng-touched']")
	WebElement textcustAddress;
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement textcustEmail;
	
	@FindBy(xpath = "//input[@type='tel']")
	WebElement textcustPhone;
	
	@FindBy(xpath = "//label[normalize-space()='Male']")
	WebElement custGender;
	
	@FindBy(xpath = "//label[normalize-space()='Cricket']")
	WebElement custHobbies;
	
	@FindBy(xpath = "//div[@id='msdd']")
	WebElement textcustLanguage;
	
	@FindBy(xpath = "//select[@id='Skills']")
	WebElement dropdownSkill;
	
	@FindBy(xpath = "//select[@id='countries']")
	WebElement dropdownCountries;
	
	@FindBy(xpath = "//span[@role='combobox']")
	WebElement dropdownSelectCountries;
	
	@FindBy(xpath = "//select[@id='yearbox']")
	WebElement textBirthYear;
	
	@FindBy(xpath = "//select[@placeholder='Month']")
	WebElement textBirthMonth;
	
	@FindBy(xpath = "//select[@id='daybox']")
	WebElement textBirthday;
	
	@FindBy(xpath = "//input[@id='firstpassword']")
	WebElement textcustPassword;
	
	@FindBy(xpath = "//input[@id='secondpassword']")
	WebElement textcustConfirmPassword;
	
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement clickSubmit;
	
	
	public void custFistName(String cfirstname)
	{
		textcustFirstName.sendKeys(cfirstname);
	}

	public void custLastName(String clastname)
	{
		textcustLastName.sendKeys(clastname);
	}
	
	public void custAddress(String caddress)
	{
		textcustAddress.sendKeys(caddress);
	}
	
	public void custEmailid(String cemailid)
	{
		textcustEmail.sendKeys(cemailid);
	}
	
	public void custPhone(String cphone)
	{
		textcustPhone.sendKeys(cphone);
	}
	
	public void custGender()
	{
		custGender.click();
	}
	
	public void custHobbies()
	{
		custHobbies.click();
	}
	
	Select select1 = new Select(textcustLanguage);
	
	public void custLanguage(String clanguage)
	{
		select1.deselectByVisibleText(clanguage);
	}
	
	Select select2 = new Select(dropdownSkill);
	
	public void custSkill(String cskill)
	{
		select2.deselectByVisibleText(cskill);
	}
	
	Select select3 = new Select(dropdownCountries);
	
	public void custCountry(String ccountry)
	{
		select3.deselectByVisibleText(ccountry);
	}
	
	Select select4 = new Select(dropdownSelectCountries);
	
	public void custSelectCountry(String cselectcountry)
	{
		select4.deselectByVisibleText(cselectcountry);
	}
	
	Select select5 = new Select(textBirthYear);
	
	public void custBirthYear(String cbirthyear)
	{
		select5.deselectByVisibleText(cbirthyear);
	}
	
	Select select6 = new Select(textBirthYear);
	
	public void custBirthMonth(String cbirthmonth)
	{
		select6.deselectByVisibleText(cbirthmonth);
	}
	
	Select select7 = new Select(textBirthday);
	
	public void custBirthDay(String cbirthday)
	{
		select7.deselectByVisibleText(cbirthday);
	}
	
	public void custPassword(String cpassword)
	{
		textcustPassword.sendKeys(cpassword);
	}
	
	public void custConfirmPassword(String cconfirmpassword)
	{
		textcustConfirmPassword.sendKeys(cconfirmpassword);
	}
	
	public void custSubmit()
	{
		clickSubmit.click();
	}

}
