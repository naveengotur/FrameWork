package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.*;

public class LoginPage 
{
	 WebDriver driver;
	
	public LoginPage()
	{
		this.driver=driver;
	}
	
	By username =By.xpath("//input[@name='username']");
	By password =By.xpath("//input[@type='password']");
	By loginButton =By.xpath("//button[.=' Login ']");
	
	public void enterUserName(String uname)
	{
		driver.findElement(username).sendKeys(uname);
	}
	
	public void enterPassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickOnLoginButton()
	{
		driver.findElement(loginButton).click();
		
	}
	
	public HomePage loginAsAdmin(String uname, String pass)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
		
		return new HomePage(driver);
	}
}
