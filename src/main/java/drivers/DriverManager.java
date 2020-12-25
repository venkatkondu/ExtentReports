package drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	
	
	public WebDriver getDriver()
	{
		
		return tlDriver.get();
	}
	
	public void setDriver(WebDriver rDriver)
	{
		tlDriver.set(rDriver); // I have to pass the Driver reference from the requested classes only 
		// for Achieving the parallel browsing testing
	}

}
