package com.learnautomation.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataproviders.CustomDataProvider;

public class LoginTestWithoutPOM extends BaseClass
{

	@Test(dataProvider = "Login",dataProviderClass = CustomDataProvider.class)
	public void login(String uname,String pass) 
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[.=' Login ']")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"URL pattern did not match");
	}
 
}
