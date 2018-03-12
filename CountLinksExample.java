package com.CountLinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CountLinksExample 
{




	
	WebDriver d;
	
	String exp_val,act_val;
	
	@Test
	public void VerifyLaunch()
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_RT\\drivers\\chromedriver.exe");

		d=new ChromeDriver();
		
		d.navigate().to("http://www.facrbook.com");

		List<WebElement> AllLinks=d.findElements(By.tagName("a"));
		
		for(WebElement eachLink:AllLinks)
		{
			
			System.out.println(eachLink.getText());
			
			
			
			
		}
				

System.out.println("========================================");

System.out.println("Total Links on current web page are: "+AllLinks.size());






	}










}
