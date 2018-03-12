package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.Test;

public class OrangeHRM 
{


	WebDriver d;
	
	String exp_value,act_val;
	
	
	
	@Test
	public void Verify_Launch()
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_Jan_13/drivers\\chromedriver.exe");

		
		d=new ChromeDriver();
		
		d.navigate().to("http://opensource.demo.orangehrmlive.com/");
		
		exp_value="OrangeHRM";
		
		act_val=d.getTitle();
		
		
		if(exp_value.equals(act_val))
		{
			
			System.out.println("Launch Success");
		}
		else
		{
			System.out.println("Launch UnSuccess");

		}
		
		
		
	}

	@Test
	public void Verify_AdminLogin()
	{
		
		
		d.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys("Admin");
		
		d.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("admin");
		
		Sleeper.sleepTightInSeconds(3);
		
		d.findElement(By.xpath(".//*[@id='btnLogin']")).click();
		
		exp_value="http://opensource.demo.orangehrmlive.com/index.php/dashboard";
		
		act_val=d.getCurrentUrl();
		
		if(exp_value.equals(act_val))
		{
			
			System.out.println("Login Success");
		}
		else
		{
			System.out.println("Login UnSuccess");

		}
	

		d.quit();
	}





}
