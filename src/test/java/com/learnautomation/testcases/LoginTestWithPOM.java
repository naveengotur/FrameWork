package com.learnautomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataproviders.CustomDataProvider;
import com.learnautomation.pages.LoginPage;

public class LoginTestWithPOM extends BaseClass
{

	@Test(dataProvider = "Login",dataProviderClass = CustomDataProvider.class)
	public void login(String uname,String pass) 
	{
		/*
		LoginPage login = new LoginPage();
		
		login.enterUserName(uname);
		
		login.enterPassword(pass);
		
		login.clickOnLoginButton();
		*/
		//or
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		login.loginAsAdmin(uname, pass);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"URL pattern did not match");
	}
 
}
