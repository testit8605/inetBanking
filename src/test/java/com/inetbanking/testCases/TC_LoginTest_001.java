package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void LoginTest() throws IOException
	{
		driver.get(baseURL);
		logger.info("URL is Opened");
		
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToDemoGuruApplication(username, password);
		/*lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		logger.info("Clicked Login");*/
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);
			logger.info("Test case is pass");
			
		}
		else 
		{
			captureScreen(driver, "LoginPage");
			Assert.assertTrue(false);
			logger.info("Test case is fail");
		}
			

	}




}
