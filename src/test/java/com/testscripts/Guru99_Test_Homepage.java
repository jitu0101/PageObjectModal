package com.testscripts;

import java.io.IOException;

//import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.Guru99_HomePage;

public class Guru99_Test_Homepage extends TestBase {
	
	
	static Logger log = LogManager.getLogger();
	//static Logger log = LogManager.getLogger("Guru99_Test_Homepage");
	
	
	@BeforeMethod
	public void tearup() throws IOException
	{
		OpenBrowser();
	}
	
	@Test(priority=1)
	public void displaying_courcesName_under_TESTING()
	{
		Guru99_HomePage homepage = PageFactory.initElements(driver, Guru99_HomePage.class);

		String[] courcesName = homepage.courcesName_under_testing();
		System.out.println("Total Number of Cources under Testing are:"+courcesName.length);
		log.info("Total Number of Cources under TESTING is:"+courcesName.length);
		
		for(int i=0;i<courcesName.length;i++)
		{
			//log.info(courcesName[i]);
			System.out.println(courcesName[i]);

		}
	}
	
	@Test(priority=2)
	public void verify_click_on_cucumbertesting_link()
	{
		Guru99_HomePage homepage = PageFactory.initElements(driver, Guru99_HomePage.class);
		homepage.click_on_CucumberTesting_link();
	}
	
	@Test
	public void text_of_google_search()
	{
		Guru99_HomePage homepage = PageFactory.initElements(driver, Guru99_HomePage.class);

		homepage.get_google_text();
		System.out.println("clicked on search icon");
		log.info("clicked on link:");

	}
	
	
	@AfterMethod
	public void teardown()
	{
		closeBrowser();
	}

}
