package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HRMDirverScript 
{




	WebDriver d;
	
	String exp_val,act_val;
	
	@Test(priority=0)
	public void VerifyLaunch()
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_RT\\drivers\\chromedriver.exe");

		d=new ChromeDriver();
		
		d.navigate().to("http://opensource.demo.orangehrmlive.com/");
		
		HRMLoginPage obj1=PageFactory.initElements(d, HRMLoginPage.class);
		
		
	//	obj1.HRMLogin("Admin", "admin");

		obj1.uid.sendKeys("Admin");

		obj1.pwd.sendKeys("admin");

		Sleeper.sleepTightInSeconds(3);

		obj1.login.click();
		
		
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


		HRMDashboardPage obj2=PageFactory.initElements(d, HRMDashboardPage.class);

		
		Actions act=new Actions(d);
		
		act.moveToElement(obj2.adm).build().perform();
		
		Sleeper.sleepTightInSeconds(4);

		
		act.moveToElement(obj2.umgt).build().perform();
		
		Sleeper.sleepTightInSeconds(4);

		
		act.moveToElement(obj2.users).click().build().perform();
		
		Sleeper.sleepTightInSeconds(4);

		
		
		
		d.quit();
		
		
		
		


	}


}
