package com.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;

public class HRMLoginPage 
{


	@FindBy(xpath=".//*[@id='txtUsername']")	
	WebElement uid;


	@FindBy(xpath=".//*[@id='txtPassword']")
	
	WebElement pwd;
	
	@FindBy(xpath=".//*[@id='btnLogin']")
	
	WebElement login;
	
	
	public void HRMLogin(String uid, String pwd)
	{
		
		this.uid.sendKeys(uid);
		
		this.pwd.sendKeys(pwd);
		
		Sleeper.sleepTightInSeconds(3);
		
		this.login.click();
		
		
		
	}
	
	




















}
