package com.inetbanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.inetbanking.Utilities.XLUtility;
import com.inetbanking.pageObjects.AddCustomer;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws IOException, InterruptedException 
	{
		
		driver.get(baseURL);
		logger.info("URL is Opened");
		driver.manage().window().maximize();

		String path  = "./src/test/java/com/inetbanking/testData/DDTestCase.xlsx";
		XLUtility xlreader =new XLUtility(path);

		int rowcount = xlreader.getRowCount("Sheet2");
		System.out.println(rowcount);
		int cellcount = xlreader.getCellCount("Sheet2", 1);
		System.out.println(cellcount);


		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.clickSubmit();
		logger.info("Click on login");

		Thread.sleep(3000);

		for(int i=1; i<=3; i++)
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			String First_Name = xlreader.getCellData("Sheet2", i, 0);
			String dateOfBirth = xlreader.getCellData("Sheet2", i, 1);
			String Address = xlreader.getCellData("Sheet2", i, 2);
			String City = xlreader.getCellData("Sheet2", i, 3);
			String State = xlreader.getCellData("Sheet2", i, 4);
			String PostalCode = xlreader.getCellData("Sheet2", i, 5);

			AddCustomer addnewcustomer = new AddCustomer(driver);
			addnewcustomer.clickAddNewCustomer();
			logger.info("Click on add new customer");

			logger.info("Adding customer details");
			addnewcustomer.custName(First_Name);
			addnewcustomer.custGender();
			addnewcustomer.custDob(dateOfBirth);
			addnewcustomer.custAddress(Address);
			addnewcustomer.custCity(City);
			addnewcustomer.custState(State);
			addnewcustomer.custPin(PostalCode);

			String randomnumber = randomNumber();
			addnewcustomer.custPhone(randomnumber);

			String email = randomString()+"@gmail.com";
			addnewcustomer.custEmailid(email);

			String password = randomString()+"123#";
			addnewcustomer.custPassword(password);
			Thread.sleep(5000);
			addnewcustomer.custSubmit();
			Thread.sleep(5000);

			logger.info("Validation Started");

			boolean res = driver.getPageSource().contains("Guru99 Bank Customer Registration Page");

			if(res==true)
			{
				Assert.assertTrue(true);
				logger.info("Adding customer done");
				Thread.sleep(3000);
				

			}

			else
			{
				captureScreen(driver,"addNewCustomer");
				Assert.assertTrue(false);
				logger.info("Adding customer fail");
			}
			
			
			/*lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();*/
		}
		
		

	}
}
