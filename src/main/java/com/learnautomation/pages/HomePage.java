package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	 By allTabs= By.xpath("//a[@class='oxd-main-menu-item active']");
	By adminTab = By.xpath("//h6[.='Admin']");
	
	 
	 By welcomeTab=By.xpath("//span[@class='oxd-userdropdown-tab']");
	 By logoutButton=By.xpath("//a[.='Logout']");
	 
	 public LoginPage logoutFromApplication()
	 {
		 driver.findElement(welcomeTab).click();
		 driver.findElement(logoutButton).click();
		 return new LoginPage();
	 }
	 
	 public int countTabs()
	 {
		 int count = driver.findElements(allTabs).size();
		 return count;	 
	 }
	 
	 public  AdminPage clickOnAdmin()
	 {
		 driver.findElement(adminTab).click();
		 return new AdminPage(driver);
	 }
}
