package Utilities;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory { // In this class I will achieve the Thread Local concept How to do this 
	
	
	 public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>(); //How to do this 	
	
	 
	 // Question is even though I am accessing the below methods static way can I achieve the Thread local concept for parallel execution 
//	public static WebDriver driver;  // I think remove static here
									// I think all the things must be in not static way for achieving the parallel or multiple  browser execution
	
	/* public Driver() { }	 */	
	
	public WebDriver getDriver()
	{
		return tlDriver.get();  // this is for retrieving the current driver Object for thread safety  I will check 
		
		
		
	}
	
	public static WebDriver init_Driver(String browser) // later or I will update this things 
	{// How to avoid unnecessary browsers open  if driver == null then only create the driver object or browser open otherwise browser not open
		
		//if(driver==null)
//	
		if(browser.equalsIgnoreCase("chrome"))
				{	System.setProperty("webdriver.chrome.driver", "/home/venkat/Softwares/Browsers/chromedriver");
					
				//WebDriverManager.chromedriver().setup();
	
				tlDriver.set(new ChromeDriver());
				browserThings();
			
				//	driver=new ChromeDriver();
					return tlDriver.get();
				}else if(browser.equalsIgnoreCase("firefox"))
				{	System.setProperty("webdriver.gecko.driver", "/home/venkat/Softwares/Browsers/geckodriver");
					
			//	WebDriverManager.firefoxdriver().setup(); // this will not working why I don't know
				tlDriver.set(new FirefoxDriver());
				browserThings();
				//driver=new FirefoxDriver();	
				return tlDriver.get();
				
				//return driver;
				}else if(browser.equalsIgnoreCase("opera"))
				{
					System.setProperty("webdriver.opera.driver", "/home/venkat/Softwares/Browsers/operadriver");
					
				//WebDriverManager.operadriver().setup();
				
				tlDriver.set(new OperaDriver());
				//driver=new OperaDriver();
				browserThings();
					//return driver;
				return tlDriver.get();
				}else if(browser.equalsIgnoreCase("safari"))
				{	
					System.setProperty("webdriver.safari.driver", "/home/venkat/Softwares/Browsers/safaridriver");
					
			//		WebDriverManager.
				tlDriver.set(new SafariDriver());	
				//driver=new SafariDriver();	
				browserThings();
					//return driver;
				return tlDriver.get();
				}else if(browser.equalsIgnoreCase("edge"))
				{
					System.setProperty("webdriver.edge.driver", "/home/venkat/Softwares/Browsers/edgedriver");
					
				//WebDriverManager.edgedriver().setup();
				
				tlDriver.set(new EdgeDriver());
				//driver=new EdgeDriver();
				browserThings();
				return tlDriver.get();
					//return driver;
				}
				else if(browser.equalsIgnoreCase("IE"))
				{
					System.setProperty("webdriver.ie.driver", "/home/venkat/Softwares/Browsers/iedriver");
					
				//WebDriverManager.iedriver().setup();
				
				tlDriver.set(new InternetExplorerDriver());
				//driver=new InternetExplorerDriver();
					//return driver;
				browserThings();
				return tlDriver.get();
				}
				else
				{
					System.out.println(" ***** You passed wrong browser name -"+browser+" - This browser is now available ");
					//return null;
					return tlDriver.get();
				}
		}// this is for browser is already is open or not 
		
	/*
	 * else{ System.out.
	 * println("Driver is not null Unable to launch the brwser without closing the browser "
	 * );// driver is already running the browser return tlDriver.get(); //if we
	 * want to create a new browser if driver is only null time possible check }
	 */



	public static void browserThings()
	{
		tlDriver.get().manage().window().maximize();
		tlDriver.get().manage().deleteAllCookies(); // initially I'm delete the pre requisites cookies 
		tlDriver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		tlDriver.get().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		tlDriver.get().manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		
		// How to set the webDriver Explicitly wait How to do this 
	}
	
	public static String getTitlePage()
	{
		return tlDriver.get().getTitle();
		
	}
	
	
	public static void closeBrowser()
	{
		//if(driver!=null)
		if(Objects.nonNull(tlDriver))
		{
		System.out.println("Browser is going to close not session close only browser close we may open new browser according to code ");
		tlDriver.get().close(); // here never specify driver = null , why because if we specify null here what will happened check  
	 	//tlDriver=null; // by this statement can I execute the remaining  things , normally it is not possible 
		
		// The above line will not use why because that remove the thread local instance null Unable to locate after things 
		}
	}
	
	public static void quitBrowser()
	{
		//if(driver!=null)
			
		if(Objects.nonNull(tlDriver))
		{
		System.out.println("Here I'm closing entaire session  we may not open new browser according this method \"quit\" code ");
		tlDriver.get().quit();
		tlDriver.remove();// How this statement will work
	// 	driver=null;
		}
		
	}
	
	public void deleteAllCookies() // this method will call last of the application 
	{
		tlDriver.get().manage().deleteAllCookies();
		
		
	}
	
}
