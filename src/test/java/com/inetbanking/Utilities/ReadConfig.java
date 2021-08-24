package com.inetbanking.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig 
{

	Properties prop;

	public ReadConfig()
	{

		try 
		{
			FileInputStream fis = new FileInputStream("./Configuration/Config.properties");
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is" +e);
		}

	}
	
	public String getApplicationURL()
	{
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String username = prop.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password = prop.getProperty("password");
		return password;
	}
	public String getChromePath()
	{
		String chroPath = prop.getProperty("chromepath");
		return chroPath;
	}




}
