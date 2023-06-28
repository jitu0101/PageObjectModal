package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.TestBase;

public class Guru99_HomePage extends TestBase {
	
	@FindBy(xpath = "//b[text()='Testing']/..//following-sibling::ul[@id='java_technologies'][1]//li")
	List<WebElement> courcesName;
	
	@FindBy(xpath = "//b[text()='Testing']/..//following-sibling::ul[@id='java_technologies'][1]//li[5]")
	WebElement cucmbertestinglink;
	
	@FindBy(xpath = "//*[@id='gsc-i-id1']")
	WebElement google_textbox;
	
	@FindBy(xpath = "//button[@class='gsc-search-button gsc-search-button-v2']")
	WebElement search_button;
	
	public String[] courcesName_under_testing() {
		
		int numberOfcources = courcesName.size();
		String[] str = new String[numberOfcources];
				
		for(int i=1;i<=numberOfcources;i++)
		{
			String courceText = driver.findElement(By.xpath("//b[text()='Testing']/..//following-sibling::ul[@id='java_technologies']"
					+ "[1]//li["+i+"]")).getText();
			
			String str1 = courceText.replace("➤ ", " ");
			
			str[i-1]=str1;
		}
		return str;
	}
	
	public void click_on_CucumberTesting_link()
	{
		cucmbertestinglink.click();
	}
	
	public void get_google_text()
	{
		 google_textbox.sendKeys("Testing");
		 search_button.click();
		 
		//return text;
	}

}
