package Utilities;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
	
	
	public static WebDriver driver;
		
	
	/* public Driver() { }	 */	
	
	
	public static void init_Driver(String browser) // later or I will update this things 
	{// How to avoid unnecessary browsers open  if driver == null then only create the driver object or browser open otherwise browser not open
		
		//if(driver==null)
		if(Objects.isNull(driver))
		{
				if(browser.equalsIgnoreCase("chrome"))
				{	System.setProperty("webdriver.chrome.driver", "/home/venkat/Softwares/Browsers/chromedriver");
					driver=new ChromeDriver();
				//	return driver;
				}else if(browser.equalsIgnoreCase("firefox"))
				{	System.setProperty("webdriver.gecko.driver", "/home/venkat/Softwares/Browsers/geckodriver");
					driver=new FirefoxDriver();	
					//return driver;
				}else if(browser.equalsIgnoreCase("opera"))
				{	System.setProperty("webdriver.opera.driver", "/home/venkat/Softwares/Browsers/operadriver");
					driver=new OperaDriver();	
					//return driver;
				}else if(browser.equalsIgnoreCase("safari"))
				{	System.setProperty("webdriver.safari.driver", "/home/venkat/Softwares/Browsers/safaridriver");
					driver=new SafariDriver();	
					//return driver;
				}else if(browser.equalsIgnoreCase("edge"))
				{	System.setProperty("webdriver.edge.driver", "/home/venkat/Softwares/Browsers/edgedriver");
					driver=new EdgeDriver();	
					//return driver;
				}
				else if(browser.equalsIgnoreCase("IE"))
				{System.setProperty("webdriver.ie.driver", "/home/venkat/Softwares/Browsers/iedriver");
					driver=new FirefoxDriver();	
					//return driver;
				}
				else
				{
					System.out.println(" ***** You passed wrong browser name -"+browser+" - This browser is now available ");
					//return null;
				}
		}// this is for browser is already is open or not 
		
		else{
			System.out.println("Driver is not null");// driver is already running the browser if we want to create a new browser if driver is only null time possible check
		}
	}
	
	public static void closeBrowser()
	{
		//if(driver!=null)
		if(Objects.nonNull(driver))
		{
		System.out.println("Browser is going to close not session close only browser close we may open new browser according to code ");
		driver.close(); // here never specify driver = null , why because if we specify null here what will happened check  
		driver=null;
		}
	}
	
	public static void quitBrowser()
	{
		//if(driver!=null)
			
		if(Objects.nonNull(driver))
		{
		System.out.println("Here I'm closing entaire session  we may not open new browser according this method \"quit\" code ");
		driver.quit();
		driver=null;
		}
		
	}
	
}
