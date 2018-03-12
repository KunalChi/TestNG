package com.ExplicitWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitExample 
{




	WebDriver d;
	
	String exp_val,act_val;
	
	@Test(priority=0)
	public void VerifyLaunch()
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_RT\\drivers\\chromedriver.exe");

		d=new ChromeDriver();
		
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
		d.navigate().to("http://opensource.demo.orangehrmlive.com/");
		
		WebDriverWait wait=new WebDriverWait(d, 10);
		
		WebElement uid=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='txtUsername']")));
		
		uid.clear();
		
		uid.sendKeys("Admin");


		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("txtPassword"))).sendKeys("admin");

		
		Sleeper.sleepTightInSeconds(3);


		d.findElement(By.name("Submit")).click();
		
		



	}









}
