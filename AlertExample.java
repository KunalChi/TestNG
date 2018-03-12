package com.Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.Test;

public class AlertExample 
{





	WebDriver d;
	
	String exp_val,act_val;
	
	@Test(priority=0)
	public void VerifyAlerts()
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_RT\\drivers\\chromedriver.exe");

		d=new ChromeDriver();
		
		d.navigate().to("file:///E:/Md%20Zabiuddin/QAPracticeAll/SeleniumTraining/WebDriver/NewConepts/ForAlerts.html");

		d.findElement(By.xpath("html/body/center[4]/button")).click();
		
		Sleeper.sleepTightInSeconds(4);

		
		
		Alert alert1=d.switchTo().alert();
		
		System.out.println("message on alert1 is: "+alert1.getText());

		alert1.accept();
		
		
		d.findElement(By.xpath("html/body/center[7]/button")).click();
		
		Sleeper.sleepTightInSeconds(4);

		
		Alert alert3=d.switchTo().alert();
		
		alert3.sendKeys("Ravi");

		alert3.accept();
		
		Sleeper.sleepTightInSeconds(4);

		
		d.quit();







	}






}
