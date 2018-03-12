package com.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HRMDashboardPage 
{


	@FindBy(xpath=".//*[@id='menu_admin_viewAdminModule']/b")
	WebElement adm;
	
	@FindBy(xpath=".//*[@id='menu_admin_UserManagement']")

	WebElement umgt;
	
	@FindBy(xpath=".//*[@id='menu_admin_viewSystemUsers']")
	
	WebElement users;























}
