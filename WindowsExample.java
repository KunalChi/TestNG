package com.MultipleWindows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowsExample 
{


	WebDriver d;
	
	String exp_val,act_val;
	
	@Test(priority=0)
	public void VerifyLaunch()
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_RT\\drivers\\chromedriver.exe");

		d=new ChromeDriver();
		
		d.navigate().to("https://www.facebook.com/");
		
		
		
		String window1=d.getWindowHandle();
		
		
		d.findElement(By.xpath(".//*[@id='terms-link']")).click();
		
		
		Set<String> allwindows=d.getWindowHandles();
		
		
		for(String eachwindow:allwindows)
		{
			
			if(!(eachwindow.equals(window1)))
			{
				
				d.switchTo().window(eachwindow);
				
				d.findElement(By.xpath(".//*[@id='blueBarDOMInspector']/div/div[2]/div/div/span/a")).click();


				d.findElement(By.xpath(".//*[@id='u_0_m']")).sendKeys("sljflfkjdlfj");
				
				
			
				
			}
			
			
		}
		
		d.close();
		
		d.switchTo().window(window1);
		
		d.findElement(By.xpath(".//*[@id='u_0_l']")).sendKeys("Ravi Teja");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		








	}







}
