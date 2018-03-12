package com.KD;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HRMMain 
{


	@Test
	public void HRM() throws IOException
	{
		
		FileInputStream excelfi=new FileInputStream("E:\\Md Zabiuddin\\QAPracticeAll\\SeleniumPractice\\KDT\\testdata.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(excelfi);
		
		XSSFSheet ws1=wb.getSheet("TestCases");
		
		XSSFSheet ws2=wb.getSheet("TestSteps");
		
	//	XSSFSheet ws3=wb.getSheet("TestData");
				
		String murl="http://opensource.demo.orangehrmlive.com/";
		
	//	int testcasecount,teststepcount;
		
		String exeflag,testcaseid,teststepid,keyword,tcres="Pass";

		boolean kwres=false;
		
		
		HRMLib hrmlib=new HRMLib();
		
		
		for(int i=1; i<=4; i++)
		{
			
			exeflag=ws1.getRow(i).getCell(2).getStringCellValue();
			
			if(exeflag.equalsIgnoreCase("Y"))
			{
				testcaseid=ws1.getRow(i).getCell(0).getStringCellValue();

				for(int j=1; j<=12; j++)
				{
					
					teststepid=ws2.getRow(j).getCell(0).getStringCellValue();

					if(testcaseid.equalsIgnoreCase(teststepid))
					{
						keyword=ws2.getRow(j).getCell(4).getStringCellValue();
						
						switch(keyword.toUpperCase())
						{
						
						case "LAUNCHAPP":
							kwres=hrmlib.Launch(murl);
						break;
						
						case "ADMINLOGIN":
							kwres=hrmlib.AdminLogin("admin", "admin");
						break;
						
						case "VIEWUSERS":
							kwres=hrmlib.ViewUsers();
						break;
						
						case "LOGOUT":
							kwres=hrmlib.logout();
						}
						
						if(kwres==true)
						{
							ws2.getRow(j).createCell(3).setCellValue("Pass");
	
						}
						else
						{
							ws2.getRow(j).createCell(3).setCellValue("Fail");
							tcres="Fail";
						}
							
						ws1.getRow(i).createCell(3).setCellValue(tcres);
					}
					
				}
				
			}
			else
			{
				ws1.getRow(i).createCell(3).setCellValue("Blocked");

			}
			
		}


			FileOutputStream fo=new FileOutputStream("E:\\Md Zabiuddin\\QAPracticeAll\\SeleniumPractice\\KDT\\testdata.xlsx");
			
			wb.write(fo);
			
			wb.close();
			
		}



}
