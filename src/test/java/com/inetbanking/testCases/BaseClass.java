package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{

	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;


	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j2.properties"); 


		if(br.equals("chrome"))
		{

			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		}

		else if(br.equals("firefox"))
		{

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		else if(br.equals("edge"))
		{

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get(baseURL);
		logger.info("URL is Opened");
		driver.manage().window().maximize();

	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
	
	public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}

	public String randomNumber()
	{
		String generatenumber = RandomStringUtils.randomNumeric(10);
		return generatenumber;
	}
	
	



}
