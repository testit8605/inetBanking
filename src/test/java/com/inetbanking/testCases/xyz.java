package com.inetbanking.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xyz 
{
	@Test
	public void test() 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Akshay");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Bhagat");
		
		// this is demo project
		
	}
	
	
  
}
