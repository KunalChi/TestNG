package com.ConditionalMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;

public class MercurytoursLogin 
{

	public static void main(String[] args)
	{

		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_Jan_13/drivers\\chromedriver.exe");
		
		WebDriver d=new ChromeDriver();
		
		//d.navigate().to("http://www.facebook.com");
		
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//d.navigate().to("http://opensource.demo.orangehrmlive.com/");
		
		d.navigate().to("http://newtours.demoaut.com/");
		
		WebElement username=d.findElement(By.name("userName"));
		
		WebElement pwd=d.findElement(By.name("password"));
		
		if(username.isEnabled())
		{
			username.clear();
			
			username.sendKeys("Admin");
				
			
		}
		
		if(pwd.isEnabled())
		{
			pwd.sendKeys("mercury");
		}
		
		Sleeper.sleepTightInSeconds(4);
		
		WebElement login=d.findElement(By.name("login"));
		
		if(login.isDisplayed())
		{
			
			login.click();
		}
		
		WebElement two_way=d.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]"));
		
		WebElement one_way=d.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]"));
		
		
		if(two_way.isSelected())
		{
			
			Sleeper.sleepTightInSeconds(4);

			
			one_way.click();
		}
		
		Select depart=new Select(d.findElement(By.name("fromPort")));
		
		
		depart.selectByVisibleText("New York");
		
		Sleeper.sleepTightInSeconds(4);

		
		d.quit();
		
		
	}

}
