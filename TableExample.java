package com.TableHandles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TableExample
{

	
	
	WebDriver d;
	
	String exp_val,act_val;
	
	@Test(priority=0)
	public void VerifyLaunch()
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_RT\\drivers\\chromedriver.exe");

		d=new ChromeDriver();
		
		d.navigate().to("file:///E:/Md%20Zabiuddin/QAPracticeAll/SeleniumTraining/WebDriver/NewConepts/a%20table.html");
	
	
		WebElement table=d.findElement(By.xpath("html/body/table"));
		
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		
		for(WebElement eachrow:rows)
		{
			
			List<WebElement> cols=eachrow.findElements(By.tagName("td"));
			
			for(WebElement eachcol:cols)
			{
				
				System.out.println(eachcol.getText());
			}
			
			System.out.println();
			
			
			
		}
	
	
	
	
	
	}
	
	
	
}
