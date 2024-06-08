package com.learnautomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataproviders.CustomDataProvider;
import com.learnautomation.pages.AdminPage;
import com.learnautomation.pages.HomePage;
import com.learnautomation.pages.LoginPage;

public class UserCreateTest extends BaseClass {
	LoginPage login;
	HomePage home;
	AdminPage admin;
	WebDriver driver;
	
	@BeforeMethod
	public void setupDriver()
	{
		driver=getDriver();
	}

	@Test(dataProvider = "Login", dataProviderClass = CustomDataProvider.class, priority = 0)
	public void login(String uname, String pass) {

		login = PageFactory.initElements(driver, LoginPage.class);
		
		home = login.loginAsAdmin(uname, pass);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "URL pattern did not match");
		
	}
/*
	@Test(dependsOnMethods = "login", dataProviderClass = CustomDataProvider.class, dataProvider = "User")
	public void verifyTabs() {
		int tabCount = home.countTabs();
		
		Assert.assertEquals(tabCount, 10);
	}
*/
	@Test( dependsOnMethods = "login",  dataProviderClass = CustomDataProvider.class, dataProvider = "User")
	public void createUser(String role, String empName, String userName,String userStatus, String pass) 
	{
		admin = home.clickOnAdmin();
		
		admin.createUser(role, empName, userName, userStatus, pass);
	
		boolean status = admin.isSuccessMsgDisplayed(); 

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "User Didn't match");
	}

	@Test(priority = 2, dependsOnMethods = "login")
	public void logOutApplication() {
		home.logoutFromApplication();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}

}
