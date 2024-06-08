package com.learnautomation.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.learnautomation.dataproviders.ConfigUtility;
import com.learnautomation.factory.BrowserFactory;

public abstract class BaseClass {
	
	public  WebDriver driver;
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	@BeforeClass
	public void setup()
	{
		driver = BrowserFactory.startBrowser(ConfigUtility.getValue("browser"));
		driver.get(ConfigUtility.getValue("url"));
			
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
