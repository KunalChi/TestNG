package com.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HRM 
{

	public static void main(String[] args) 
	{

		
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_Jan_13/drivers\\chromedriver.exe");
		
		WebDriver d=new ChromeDriver();
		
		//d.navigate().to("http://www.facebook.com");
		
		d.navigate().to("http://opensource.demo.orangehrmlive.com/");
		
		String title=d.getTitle();
		
		System.out.println("The title of Orange HRM is "+title);
		
		System.out.println("Url: "+d.getCurrentUrl());
		
		System.out.println("Lenght of Title: "+title.length());
		
		System.out.println(d.getPageSource());
		
		
		
		
		
		
		
		
		
	}

}
