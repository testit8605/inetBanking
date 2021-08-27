package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.inetbanking.Utilities.ReadConfig;
import com.inetbanking.pageObjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{

	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String baseURL2 = readconfig.getApplicationURL2();
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


		if(br.equalsIgnoreCase("chrome"))
		{

			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			
		}

		else if(br.equalsIgnoreCase("firefox"))
		{

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		else if(br.equalsIgnoreCase("edge"))
		{

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		/*driver.get(baseURL);
		logger.info("URL is Opened");
		driver.manage().window().maximize();*/

	}
	
	
	@AfterClass
	public void tearDown()
	{
		//driver.close();
		//driver.quit();
	}
	
	
	public static void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
	
	public static String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}

	public static String randomNumber()
	{
		String generatenumber = RandomStringUtils.randomNumeric(10);
		return generatenumber;
	}
	
	



}
