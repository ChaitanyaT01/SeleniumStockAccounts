package DriverFactory;

import org.openqa.selenium.WebDriver;

import CommonFunLib.FunctionLibrary;
import Utilities.ExcelFileUtil;

public class DriverScript 
{
	WebDriver dr;
	public void startTest() throws Throwable
		
{
	ExcelFileUtil xl=new ExcelFileUtil();
	
	for (int i = 1; i <=xl.rowCount("MasterTestCases"); i++) 
	{
		String ModuleStatus="";
		
		if (xl.getData("MasterTestCases", i, 2).equalsIgnoreCase("Y"))
		{
			String TCModule=xl.getData("MasterTestCases", i, 1);
			int rowCount=xl.rowCount(TCModule);
			
			for (int j = 1; j <=rowCount; j++) 
			{
			
				String Description=xl.getData(TCModule, j, 0);
				String Object_Type=xl.getData(TCModule, j, 1);
				String Locator_Type=xl.getData(TCModule, j, 2);
				String Locator_Value=xl.getData(TCModule, j, 3);
				String Test_Data=xl.getData(TCModule, j, 4);
				
				try
				{
				if (Object_Type.equalsIgnoreCase("startBrowser")) 
				{
					dr=FunctionLibrary.startBrowser(dr);
				}
				if (Object_Type.equalsIgnoreCase("openApplication"))
				{
					FunctionLibrary.openApplication(dr);
				}
				if (Object_Type.equalsIgnoreCase("typeAction"))
				{
					FunctionLibrary.typeAction(dr, Locator_Type, Locator_Value, Test_Data);
				}
				if (Object_Type.equalsIgnoreCase("clickAction")) 
				{
					FunctionLibrary.clickAction(dr, Locator_Type, Locator_Value);
				}
				if (Object_Type.equalsIgnoreCase("closeBrowser")) 
				{
					FunctionLibrary.closeBrowser(dr);
				}
				if (Object_Type.equalsIgnoreCase("waitForElement"))
				{
					FunctionLibrary.waitForElement(dr, Locator_Type, Locator_Value, Test_Data);
				}
				xl.setData(TCModule, j, 5, "PASS");
				ModuleStatus="true";
				}catch (Exception e)
				{
					xl.setData(TCModule, j, 5, "FAIL");
					ModuleStatus="false";
					break;
				}
			}
			if (ModuleStatus.equalsIgnoreCase("true"))
			{
				xl.setData("MasterTestCases", i, 3, "PASS");
			}else
				if(ModuleStatus.equalsIgnoreCase("false"))
			{
				xl.setData("MasterTestCases", i, 3, "FAIL");
			}
		}
		else
		{
			xl.setData("MasterTestCases", i, 3, "Not Executed");
		}
	}
	
}
	}

