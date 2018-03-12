package com.KD;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HRMLib 
{

		WebDriver d;
		
		String ExpVal,ActVal,str;
		
		Boolean kwres=false;
		
		WebDriverWait wait;

		public boolean Launch(String url) throws IOException
		{
			
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver.exe");
			
			d=new ChromeDriver();
			
			//System.setProperty("webdriver.ie.driver","E:\\IEDriverServer.exe");
			
			//d=new InternetExplorerDriver();
			
			
			d.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
			d.navigate().to(url);
			
			//d.manage().window().maximize();
			
		//	d.manage().window().maximize();
			
			
			
			ExpVal="OrangeHRM";
			
			ActVal=d.getTitle();
			
			try
			{
				Assert.assertEquals(ActVal, ExpVal, "Application not Launched Successfully");
				
				
			}
			catch(AssertionError e)
			{
				//File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
				
			//	File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
				
				
				File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
				
				
			//	FileUtils.copyFile(src, new File("E:\\TestData\\KD\\Errors\\LaunchFailed.jpg"));
				
				FileUtils.copyFile(src, new File("E:\\TestData\\KD\\Errors\\LaunchFailed.jpg"));
				
				
				return false;		
			}
			
				return true;
			
		}

		public boolean AdminLogin(String uid, String pwd) throws IOException
		{
			
			ExpVal="http://opensource.demo.orangehrmlive.com/index.php/dashboard";
			
			wait=new WebDriverWait(d, 2);		
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='txtUsername']"))).sendKeys(uid);
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='txtPassword']"))).sendKeys(pwd);
			
			Sleeper.sleepTightInSeconds(5); 
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='btnLogin']"))).click();;

			
			ActVal=d.getCurrentUrl();
			
			try
			{
				Assert.assertEquals(ActVal, ExpVal, "Failed to login");
			}
			catch(AssertionError e)
			{
				File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
				
				FileUtils.copyFile(src, new File("E:\\TestData\\KD\\Errors\\LoginFailed.jpg"));			
				
				return false;		
			}
			
				return true;
			
		}
		
		public boolean ViewUsers() throws IOException
		{
			
			
			wait=new WebDriverWait(d, 4);		

			
			Actions act=new Actions(d);
			
			
			WebElement adm=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='menu_admin_viewAdminModule']/b")));
			
			
			act.moveToElement(adm).build().perform();
			
			Sleeper.sleepTightInSeconds(3);

			WebElement umgt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='menu_admin_UserManagement']")));

		//	WebElement umgt=d.findElement(By.xpath(".//*[@id='menu_admin_UserManagement']"));

			
			
			
			act.moveToElement(umgt).build().perform();

			Sleeper.sleepTightInSeconds(3);

			WebElement users=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='menu_admin_viewSystemUsers']")));

			
			act.moveToElement(users).click().build().perform();
			
			
			ExpVal="btnAdd";
			
			
			ActVal=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='btnAdd']"))).getAttribute("id");
			
			try
			{
				Assert.assertEquals(ActVal, ExpVal, "View Users failed");
			}
			catch(AssertionError e)
			{
				File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
				
				FileUtils.copyFile(src, new File("E:\\TestData\\KD\\Errors\\ViewUsersFailed.jpg"));			
				
				return false;		
			}
			
				return true;					
			
		}
		
		
		public boolean logout() throws IOException
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='welcome']"))).click();
			
			Sleeper.sleepTightInSeconds(2);	
		
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout"))).click();

			Sleeper.sleepTightInSeconds(3);	

			ExpVal="txtUsernam";
			
			ActVal=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='txtUsername']"))).getAttribute("id");
			
			try
			{
				Assert.assertEquals(ActVal, ExpVal, "Logoutfailed");
			}
			catch(AssertionError e)
			{
				File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
				
				FileUtils.copyFile(src, new File("E:\\TestData\\KD\\Errors\\LogoutFailed.jpg"));			
				
				return false;		
			}
			
				return true;
		}
			
			
		
}










