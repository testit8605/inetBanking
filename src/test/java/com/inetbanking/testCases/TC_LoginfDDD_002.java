package com.inetbanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.Utilities.XLUtility;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginfDDD_002 extends BaseClass
{
	@Test
	public void loginDDD() throws IOException, InterruptedException 
	{
		driver.get(baseURL);
		logger.info("URL is Opened");
		driver.manage().window().maximize();
		
		String path  = "./src/test/java/com/inetbanking/testData/DDTestCase.xlsx";
		XLUtility xlreader =new XLUtility(path);
		
		int rowcount = xlreader.getRowCount("Sheet1");
		System.out.println(rowcount);
		int cellcount = xlreader.getCellCount("Sheet1", 1);
		System.out.println(cellcount);

		LoginPage lp = new LoginPage(driver);

		for(int i=1; i<=rowcount; i++)
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			String username = xlreader.getCellData("Sheet1", i, 0);
			String password = xlreader.getCellData("Sheet1", i, 1);
			String exp = xlreader.getCellData("Sheet1", i, 2);

			lp.setUserName(username);
			lp.setPassword(password);
			lp.clickSubmit();
			Thread.sleep(3000);

			if(exp.equals("Valid"))
			{
				if(isAlertPresent()==false)
				{
					Assert.assertTrue(true);
					logger.info("Login Passed");
					lp.clickLogout();
					Thread.sleep(2000);
					driver.switchTo().alert().accept();
					driver.switchTo().defaultContent();

				}
				else
				{
					driver.switchTo().alert().accept();
					driver.switchTo().defaultContent();
					Assert.assertTrue(false);
					logger.info("Login Failed");
				}
			}

			else if(exp.equals("Invalid")) 
			{ 

				if(isAlertPresent()==true)
				{
					driver.switchTo().alert().accept();
					driver.switchTo().defaultContent();
					Assert.assertTrue(true);
					logger.info("Login Passed");
				}
				else
				{
					Assert.assertTrue(true);
					logger.info("Login Failed");
					lp.clickLogout();
					driver.switchTo().alert().accept();
					driver.switchTo().defaultContent();
				}
			}
		}
	}

	public boolean isAlertPresent() 
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception is" +e);
			return false;
		}
	}
}
