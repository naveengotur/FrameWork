package com.learnautomation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learnautomation.utility.Helper;

public class AdminPage {

	WebDriver driver;
	
	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	By addButton = By.xpath("//button[.=' Add ']");
	
	By useRole = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
	
	By empName = By.xpath("//input[@placeholder='Type for hints...']");
	
	By userName = By.xpath("(//input[@autocomplete='off'])[1]");
	
	By userStatus =By.xpath("(//div[.='-- Select --'])[8]");
	
	By password = By.xpath("(//input[@autocomplete='off'])[2]");
	
	By confirmPassword = By.xpath("(//input[@autocomplete='off'])[3]");
	
	By saveButton = By.xpath("//button[.=' Save ']");
	
	By successMsg = By.xpath("");
	

	public void createUser(String uRole,String eName, String uName,String uStatus, String pass) 
	{
		
		 driver.findElement(addButton).click();
		 
		Select userRoleDD = Select(driver.findElement(useRole));
		
		userRoleDD.selectByVisibleText(uRole);
		
		driver.findElement(empName).sendKeys(eName);
		
		driver.findElement(userName).sendKeys(uName);
		
		driver.findElement(userStatus).sendKeys(uStatus);
		
		driver.findElement(password).sendKeys(pass);
		
		driver.findElement(confirmPassword).sendKeys(pass);
		
		Helper.wait(2);
		
		driver.findElement(saveButton).click();
	
		
	}


	public boolean isSuccessMsgDisplayed()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				
		return wait.until(ExpectedConditions.elementToBeClickable(successMsg)).isDisplayed();		
				
	}
	private Select Select(WebElement element) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
