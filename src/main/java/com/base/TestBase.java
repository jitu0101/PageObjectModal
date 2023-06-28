package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String Browser;
	
	public static void OpenBrowser() throws IOException
	{
		
		 FileInputStream fis = new FileInputStream(".\\src\\main\\java\\com\\configuration\\config.Properties");
		 prop = new Properties();
		 prop.load(fis);
		 Browser = prop.getProperty("BrowserName");
		 
		 if(Browser.equalsIgnoreCase("chrome"))
		  {
			 driver = WebDriverManager.chromedriver().create();
		  }	 
		 else if(Browser.equalsIgnoreCase("firefox"))
		  {
			 driver = WebDriverManager.firefoxdriver().create();
		  }
		 else
		 {
			 driver = WebDriverManager.iedriver().create();
		 }

		  String URL= prop.getProperty("Url");
		  driver.get(URL);
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		 }
	public static void closeBrowser()
	{driver.quit();}


}
