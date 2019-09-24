package CommonFunLib;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PropertyFilesUtil;

public class FunctionLibrary 
{
	WebDriver dr;
	//startBrowser
	public static WebDriver startBrowser(WebDriver dr) throws Throwable
	{
		if(PropertyFilesUtil.getValueForKey("Browser").equalsIgnoreCase("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "");
			dr=new FirefoxDriver();
		}else
			if(PropertyFilesUtil.getValueForKey("Browser").equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\chaitanya.t\\workspace\\Chaitanya\\TestProject\\CommonJarFiles\\chromedriver.exe");
				dr=new ChromeDriver();
			}
		
		return dr;
	}
	
	//Open Application
	public static void openApplication(WebDriver dr) throws Throwable
	{
		dr.get(PropertyFilesUtil.getValueForKey("url"));
		dr.manage().window().maximize();
	}
	
	// clickAction
	public static void clickAction(WebDriver dr, String locatorType,String locatorValue)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			dr.findElement(By.id(locatorValue)).click();
		}else
			if(locatorType.equalsIgnoreCase("name"))
			{
				dr.findElement(By.name(locatorValue)).click();
			}else
				if(locatorType.equalsIgnoreCase("xpath"))
				{
					dr.findElement(By.xpath(locatorValue)).click();
				}
	}
	
	
	//typeAction
	public static void typeAction(WebDriver dr, String locatorType,String locatorValue,String data)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			dr.findElement(By.id(locatorValue)).clear();
			dr.findElement(By.id(locatorValue)).sendKeys(data);
		}else
			if(locatorType.equalsIgnoreCase("name"))
			{
				dr.findElement(By.name(locatorValue)).clear();
				dr.findElement(By.name(locatorValue)).sendKeys(data);
			}else
				if(locatorType.equalsIgnoreCase("xpath"))
				{
					dr.findElement(By.xpath(locatorValue)).clear();
					dr.findElement(By.xpath(locatorValue)).sendKeys(data);
				}
	}
	
	//closeBrowser
	public static void closeBrowser(WebDriver dr)
	{
		dr.close();
	}
	
	//waitForElement
	public static void waitForElement(WebDriver dr, String locatorType,String locatorValue,String waittime)
	{
		WebDriverWait myWait=new WebDriverWait(dr, Integer.parseInt(waittime));
		
		if (locatorType.equalsIgnoreCase("id"))
		{
			myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
		}else
			if(locatorType.equalsIgnoreCase("name"))
			{
				myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			}else
				if(locatorType.equalsIgnoreCase("xpath"))
				{
					myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));	
				}
	}
	
// Scroll down page
	public static void pageDown(WebDriver dr){
		Actions action =new Actions(dr);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
	// CaptureData
	public static void captureData(WebDriver dr, String locatorType,String locatorValue,String data){
		String data1= "";
		
	}
	
		public static void main(String[] args) throws Throwable 
	{
		WebDriver dr=null;
		dr=FunctionLibrary.startBrowser(dr);
		FunctionLibrary.openApplication(dr);
		
		
	}
	
}
