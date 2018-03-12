package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class XYZ 
{


	
	WebDriver d;
	
	String exp_val,act_val;
	
	@Test(priority=0)
	public void VerifyLaunch()
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_RT\\drivers\\chromedriver.exe");

		d=new ChromeDriver();
		
		d.navigate().to("http://opensource.demo.orangehrmlive.com/");
		
		
		exp_val="OrangeHRM";
		
		act_val=d.getTitle();
		
		if(exp_val.equals(act_val))
		{
			System.out.println("Launch Success");
		}
		else
		{
			System.out.println("Launch UnSuccess");

		}
		
		
		
	}

	@Test(enabled=false)
	public void VerifyLogin()
	{
		
		d.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys("Admin");
		
		d.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("admin");
		
		
		Sleeper.sleepTightInSeconds(3);
		
		d.findElement(By.xpath(".//*[@id='btnLogin']")).click();
		
		exp_val="http://opensource.demo.orangehrmlive.com/index.php/dashboard";
		
		act_val=d.getCurrentUrl();
		
		if(exp_val.equals(act_val))
		{
		//	System.out.println("Login Success");
			
			Reporter.log("Login Success",true);
			
		}
		else
		{
			
			
			Reporter.log("Login Success",true);


		}
		
		
		d.quit();
		
		
		
		
	}












}
