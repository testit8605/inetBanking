package com.inetbanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.Test;


import com.inetbanking.Utilities.XLUtility;
import com.inetbanking.pageObjects.Ragister;

public class TC_RagisterUser_004 extends BaseClass
{
	@Test
	public void ragisterNewCustomer() throws IOException, InterruptedException 
	{
	
		
		
		driver.get(baseURL2);
		logger.info("URL is Opened");
		//driver.manage().window().maximize();
		
		String path  = "./src/test/java/com/inetbanking/testData/DDTestCase.xlsx";
		XLUtility xlreader =new XLUtility(path);
		
		int rowcount = xlreader.getRowCount("Sheet3");
		System.out.println(rowcount);
		int cellcount = xlreader.getCellCount("Sheet3", 1);
		System.out.println(cellcount);
		
		Thread.sleep(3000);
		

		
		
		
		for(int i=1; i<=3; i++)
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			String First_Name = xlreader.getCellData("Sheet2", i, 0);
			String Last_Name = xlreader.getCellData("Sheet2", i, 1);
			String Address = xlreader.getCellData("Sheet2", i, 2);
			String Language = xlreader.getCellData("Sheet2", i, 3);
			String Skill = xlreader.getCellData("Sheet2", i, 4);
			String Country = xlreader.getCellData("Sheet2", i, 5);
			String SelectCountry = xlreader.getCellData("Sheet2", i, 6);
			String DateBirthOfYear = xlreader.getCellData("Sheet2", i, 7);
			String DateBirthOfMonth = xlreader.getCellData("Sheet2", i, 8);
			String DateOfBirthDay = xlreader.getCellData("Sheet2", i, 9);
			
			String Password = xlreader.getCellData("Sheet2", i, 10);
			String ConfirmPassword = xlreader.getCellData("Sheet2", i, 11);
			
			logger.info("Ragistration Started");
			
			Ragister reg = new Ragister(driver);
			logger.info("Ragistration Started2");
			
			
			reg.custFistName(First_Name);
			reg.custLastName(Last_Name);
			reg.custAddress(Address);
			
			String email = randomString()+"gmail.com";
			reg.custEmailid(email);
			
			String phone = randomString();
			reg.custPhone(phone);
			
			reg.custLanguage(Language);
			reg.custSkill(Skill);
			reg.custCountry(Country);
			reg.custSelectCountry(SelectCountry);
			reg.custBirthYear(DateBirthOfYear);
			reg.custBirthMonth(DateBirthOfMonth);
			reg.custBirthDay(DateOfBirthDay);
			reg.custPassword(Password);
			reg.custConfirmPassword(ConfirmPassword);
			logger.info("Clicked on Submit");
			reg.custSubmit();
			
			if(driver.getPageSource().contentEquals("Register")==true)
			{
				Assert.assertTrue(true);
				logger.info("Registring customer done");
				Thread.sleep(3000);
			}
			
			else
			{
				captureScreen(driver,"ragisterNewCustomer");
				Assert.assertTrue(false);
				logger.info("Registring customer fail");
			}
	
		}
	}
}
