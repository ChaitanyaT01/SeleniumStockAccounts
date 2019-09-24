package CommonFunLib;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FuncLib 
{
			
	public static WebDriver driver;
	public static String url="http://webapp.qedge.com/login.php";
	public static String uname= "admin";
	public static String pword= "master";
	public static String res;
			
	public String appLaunch(String url) 
	{
	System.setProperty("webdriver.chrome.driver", "D:\\Chaitanya\\chromedriver_win32.exe");
	driver=new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	if (driver.findElement(By.id("username")).isDisplayed())
	{
			res="Pass";
	}else
	{
		res="Fail";
	}
		return res;
	}
		public String appLogin(String uname,String pword) 
		{
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.id("btnsubmit")).click();
		if (driver.findElement(By.id("logout")).isDisplayed())
		{
		res="pass";	
		}else
		{
		res="fail";
		}
		return res;
}
		public String appLogout()
		{
			driver.findElement(By.id("logout")).click();
			driver.findElement(By.className("ajs-button btn btn-primary")).click();
			if (driver.findElement(By.id("username")).isDisplayed())
			{
				res="Pass";
			}else
			{
				res="Fail";
			}
				return res;
		}
		
		
		public void appClose()
		{
			driver.close();
		}
		
		public void supplierCreation(String sName,String addr,String city,String count,String cPerson,String pNumber,String eMail,String mNumber,String notes) throws Throwable
		{
			driver.findElement(By.id("mi_a_suppliers")).click();
			driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]")).click();
			driver.findElement(By.id("x_Supplier_Name")).sendKeys(sName);
			driver.findElement(By.id("x_Address")).sendKeys(addr);
			driver.findElement(By.id("x_City")).sendKeys(city);
			driver.findElement(By.id("x_City")).sendKeys(count);
			driver.findElement(By.id("x_Contact_Person")).sendKeys(cPerson);
			driver.findElement(By.id("x_Phone_Number")).sendKeys(pNumber);
			driver.findElement(By.id("x__Email")).sendKeys(eMail);
			driver.findElement(By.id("x_Mobile_Number")).sendKeys(mNumber);
			driver.findElement(By.id("x_Notes")).sendKeys(notes);
			Actions pageDown=new Actions(driver);
			pageDown.sendKeys(Keys.PAGE_DOWN).build().perform();
			driver.findElement(By.id("btnAction")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[text()='OK!']")).click();
			Thread.sleep(2000);
			
		}
		
		public static void main(String[] args) throws Throwable
		{
			StockLibs fl=new StockLibs();
			FuncLib fb = new FuncLib();
			fl.appLaunch(url);
			fl.appLogin(uname, pword);
			fb.supplierCreation("Apple", "NY", "USA", "NY", "Sam", "789456", "gmail", "456789", "Completed");
			
			/*fl.appLogout();
			fl.appClose();*/
		}
		
}


