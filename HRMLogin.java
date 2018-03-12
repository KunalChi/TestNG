package com.DD;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HRMLogin 
{

	WebDriver d;
	
	String exp_val,act_val,suid,spwd;
	
	WebElement uid,pwd,login;
	
	FileInputStream fi;
	
	FileOutputStream fo;
	
	XSSFWorkbook wb;
	
	XSSFSheet sh;
	
	
	
	
	@Test
	public void VerifyLogin() throws IOException
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_RT\\drivers\\chromedriver.exe");

		d=new ChromeDriver();
		
		d.navigate().to("http://opensource.demo.orangehrmlive.com/");
		
		
		fi=new FileInputStream("E:\\Selenium_Jan_13\\TestData\\HRMTestData.xlsx");
		
		wb=new XSSFWorkbook(fi);
		
		sh=wb.getSheet("HRMLoginData");
		
		suid=sh.getRow(1).getCell(0).getStringCellValue();
		
		spwd=sh.getRow(1).getCell(1).getStringCellValue();
		
		uid=d.findElement(By.xpath(".//*[@id='txtUsername']"));
		
		pwd=d.findElement(By.xpath(".//*[@id='txtPassword']"));
		
		login=d.findElement(By.xpath(".//*[@id='btnLogin']"));
		
		uid.sendKeys(suid);
		
		pwd.sendKeys(spwd);
		
		Sleeper.sleepTightInSeconds(3);
		
		login.click();
		
		exp_val="http://opensource.demo.orangehrmlive.com/index.php/dashboard";
		
		act_val=d.getCurrentUrl();
		
		if(exp_val.equals(act_val))
		{
			System.out.println("Login Success");
			
			//Reporter.log("Login Success",true);
			
			sh.getRow(1).createCell(3).setCellValue("pass");
			
		}
		else
		{
			System.out.println("Login UnSuccess");

			
			sh.getRow(1).createCell(3).setCellValue("fail");

			
			//Reporter.log("Login Success",true);


		}
		
		exp_val=sh.getRow(1).getCell(2).getStringCellValue();
		
		act_val=sh.getRow(1).getCell(3).getStringCellValue();
		
		if(exp_val.equals(act_val))
		{
			
			//Reporter.log("Login Success",true);
			
			sh.getRow(1).createCell(4).setCellValue("pass");
			
		}
		else
		{

			
			sh.getRow(1).createCell(4).setCellValue("fail");

			
			//Reporter.log("Login Success",true);


		}
	
		
		fo=new FileOutputStream("E:\\Selenium_Jan_13\\TestData\\HRMTestData.xlsx");
		
		
		wb.write(fo);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
