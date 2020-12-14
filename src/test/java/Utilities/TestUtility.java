package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


/*
 			Things are covered in this Utility class
 			----------------------------------------
 
 
 1 - ImpliciTimeOut,PageLoadTimeout,ScriptLoadeTimeOut  -Done
 
 2 - Background Color Change for Element  -Done 
 	bgColorChange(driver,element)  -Done
 	changeBGColor(driver,element  -Done
 	changeColor(driver,element,colorName)  -Done
 
 3 - getDate()  -Done
 4 - getTimeDate()  -Done
 5 - init(BrowerName) I have to pass   -Done
 
 6 - pullElementScreenshotPath(element,String)   -Done // by using CustomListenerAdapterClass we have one problem I am 
 6 - pullScreenshotPath(driver,string,stirng)  -Done    // unable to pass the element and driver reference 
 6 - screenshot(driver,string,string)  -Done            // to over come that chenge the background color before processing this screenshot method full page screenshot 

 
 7 - selectByIndex(Select,int)  -Done
 7 - selectByValue(Select,String value)  -Done
 7 - selectByVisibleText(Select,String  -Done
 7 - selectByType(Select,SelectType,String value);-- Not done 
 7 - for selectType for I will use DropDown.type from that enum class I will get the string type value
 6 - 
 6 - 
 6 - 
 6 - 
 6 - 
 6 - 
 6 - 
 6 - 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 */


public class TestUtility {
	// or these values are getting from the properties file I will up date later on 
	public static int pageLoadeTime=10;
	public static int scriptLoadTime=10;
	public static int implicitTime=10;
	public static String screenshotPath="./screenshots"; // (check user.dir) // by these where I have to store
	public static String loggerFileLocation="./loggerInformationFile";
	public static String chromeDriver="/home/venkat/Softwares/Browsers/chromedriver";
	public static String geckoDriver="/home/venkat/Softwares/Browsers/geckodriver"; 
	
	
	
	public TestUtility()// in here I need to load properties file And access statically 
	{
	// for get the values from the properties file what I have to implement here 	
	}
	//  ------------  for Browser  initiation ---------------
// check this method is working or not as per my expectations 
	public static WebDriver init(String browser)// this method return WebDriver Instance 
	{// for this method what is the time_complexity and space_complexity
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{	System.setProperty("webdriver.chrome.driver", "/home/venkat/Softwares/Browsers/chromedriver");
			driver=new ChromeDriver();		return driver;
		}else if(browser.equalsIgnoreCase("firefox"))
		{	System.setProperty("webdriver.gecko.driver", "/home/venkat/Softwares/Browsers/geckodriver");
			driver=new FirefoxDriver();		return driver;
		}else if(browser.equalsIgnoreCase("opera"))
		{	System.setProperty("webdriver.opera.driver", "/home/venkat/Softwares/Browsers/operadriver");
			driver=new OperaDriver();			return driver;
		}else if(browser.equalsIgnoreCase("safari"))
		{	System.setProperty("webdriver.safari.driver", "/home/venkat/Softwares/Browsers/safaridriver");
			driver=new SafariDriver();		return driver;
		}else if(browser.equalsIgnoreCase("edge"))
		{	System.setProperty("webdriver.edge.driver", "/home/venkat/Softwares/Browsers/edgedriver");
			driver=new EdgeDriver();		return driver;
		}
		else if(browser.equalsIgnoreCase("IE"))
		{System.setProperty("webdriver.ie.driver", "/home/venkat/Softwares/Browsers/iedriver");
			driver=new FirefoxDriver();		return driver;
		}
		else
		{
			System.out.println(" ***** You passed wrong browser name -"+browser+" - This browser is now available ");
			return null;
		}
	}	
	//  --------for Data and Time  ---------------------------- 
	public static String getTimeDate()
	{
		String date_time=null;
		String AmPm=null;	int hh=LocalTime.now().getHour(); // in need to get 24 hours format 
		int mm=LocalTime.now().getMinute();	int ss=LocalTime.now().getSecond();
		
		LocalDate lDate=LocalDate.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("u MMM uuuu"); // year month date in integer format how to get that I will update as per the requirement 
		String date=lDate.format(dtf);// I will get the particular for mat of the date 
		
		if(hh<12){AmPm="AM";	}else{	AmPm="PM";	}
		 date_time=date+" Time : "+hh+"H :"+mm+"M "+ss+"S -"+AmPm;
		return date_time;
	}// for getDateTime();
	
	public static String getDate()
	{
		String date=null;	LocalDate lDate=LocalDate.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("u mmm uuuu"); 
		date=lDate.format(dtf);	return date;
	}//for getDate()
																//	method name I have to pass How to do this
	public static void screenshot(WebDriver driver,String path, String imageName)
	{		
		TakesScreenshot shot=(TakesScreenshot)driver;
		File srcImg=shot.getScreenshotAs(OutputType.FILE);	String imgPath=path+"/"+imageName+".jpg";
		File destFile=new File(imgPath);
	try {FileUtils.copyFile(srcImg, destFile);	System.out.println("Screenshot is taken in :: "+imgPath);
		} catch (IOException e) {	System.out.println("Screenshot is not taken in screenshot method in Utility.class check in that");	e.printStackTrace();}
	}//full page screenshot();
	// Whenever failurs occures and I will take screeshot of the particular screen
	// for this I have to change the background color  at the time of taking screenshot 
	public static void elementScreenshot(WebDriver driver,WebElement ele,String path)
	{
		String date=getDate();	String elePath=path+"/elementsOnly/"+date;
		File srcImg=ele.getScreenshotAs(OutputType.FILE);	String imgPath=elePath+ele.getText()+".jpg";
		File destFile=new File(imgPath);
			try {	FileUtils.copyFile(srcImg, destFile);	System.out.println("Element Screenshot is taken  in ::"+imgPath);
		} catch (IOException e) {	System.out.println("Screenshot is not taken in Utility.class elementScreenshot() method check " );
			e.printStackTrace();	}
	}//elementScreenshot()
	
	public static String pullScreenshotPath(WebDriver driver,String methodName,String path)
	{// In this case also I want to change the background color and process the element operation is required 	
		String imgPath=null;	TakesScreenshot shot=(TakesScreenshot)driver;
		File sreImg=shot.getScreenshotAs(OutputType.FILE);
		imgPath=path+methodName+".jpg";	File destImg=new File(imgPath);
		try {
			FileUtils.copyFile(sreImg, destImg);System.out.println("Screenshot is taken at ::"+imgPath);
		} catch (IOException e) {
			System.out.println("Screenshot is not taken Utility class pullScreenshotPath");	e.printStackTrace();
		}
			return imgPath;
	}// pullScreenshotPath() -- Close -----
	
	public static String pullElementScreenshotPath(WebElement ele,String path)
	{ //Actually In this case I have to take a screenshot by change the background How to do this 
		String imgPath=null;		String imgName=ele.getText().toString();//Anything convert into String type 
		File srcImg=ele.getScreenshotAs(OutputType.FILE);	imgPath=path+"/elementsOnly/"+imgName+".jpg";
		File destImg=new File(imgPath);		
		try {
			FileUtils.copyFile(srcImg, destImg);System.out.println("Element screenshot is taken at::"+imgPath);
		} catch (IOException e) {
System.out.println("Element screenshot is not taken in at Utility.pullElementScreenshotPath() check there");	e.printStackTrace();
		}
		return imgPath;
	}
	
	 	
	// How to call this method for only failure test case and take it 's screenshot only Hot to do this 
	public static void changeBGColor(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor javaScript=(JavascriptExecutor)driver;
		String colorName="yellow"; // check this work or not  // or This color name take from properties file 
	javaScript.executeScript("aruguments[0].style.backgroundColor='"+colorName+"'", ele); // check this method is workig or not 
	}
	public static void bgColorChange(WebDriver driver,WebElement ele)
	{	
		JavascriptExecutor javaScript=(JavascriptExecutor)driver;
		String bgColor=ele.getCssValue("backgroundColor");	String fColor="Red";
		for(int i=0;i<=2;i++)
		{
			changeColor(driver,ele,fColor,i);
			try {Thread.sleep(25);	} catch (InterruptedException e) {e.printStackTrace();	}
			changeColor(driver,ele,bgColor,i);
		}
	}// bgColorChange()
	 public static void changeColor(WebDriver driver,WebElement ele,String colorName , int num)
	  {
		 String imgPath="./screenshots/";
		 JavascriptExecutor javaScript=(JavascriptExecutor)driver;
		 javaScript.executeScript("arguments[0].style.backgroundColor='"+colorName+"'", ele);
		 if(num==1&&colorName.equalsIgnoreCase("Red")) // this is for highlight the background color for element with change the color
		 { elementScreenshot(driver,ele,imgPath);	 } // for take the screenshot 
		 try {	Thread.sleep(100);	} catch (InterruptedException e) {	e.printStackTrace();}
	 }//changeColor

// For handling dropDown things by using selectClass How to do this 
	 
	 // How to use Select Class 
	// public WebElement by(Select locator , int index)// this method return WebElement 
	 //{		// return WebElement element=locator.selectByIndex(index);	 }
	 
	 
	 // How to pass the the By locator for By and return the webEelent this time How to do this 
	 
	 
	  // how to call this below methods  How to do this 
	 public void selectByValue(Select select,String value)
	 {
		 select.selectByValue(value);
	 }
	 public void selectByIndex(Select select,int index)
	 {
		 select.selectByIndex(index);
		 
	 }
	 public void selectByVisibleText(Select select ,String text)
	 {
		 select.selectByVisibleText(text); // this is for selectByVisibleText
	 }
	 
	 
	 // for below method I will use enum class for type of the String 
	 // How to make that things by interface How to do that I will try later on 
	 public static void selectByType(WebElement ele,String type, String value)
	 {// here what is the Time_Complexity and Space_Complextiy How to caluclate it 
		 Select select=new Select(ele); // drop down handle by on the element 
		 boolean bool=false;
		 
		 switch(type)
		 {
		 
		 case "ByText" : select.selectByVisibleText(value);System.out.println("DropDown is selected under List value="+value);bool=true;
			 break;
			 

		 case "byValue" : select.selectByValue(value);System.out.println("DropDwon is selected by the element = [\" "+ele.getText()+"\" ] and value is  ="+value);bool=true;
			 break;

		 case "byIndex" : select.selectByIndex(Integer.parseInt(value));System.out.println("DropDown is selected by the Index number ="+Integer.parseInt(value));bool=true;
			 break;
		 
		default : System.out.println(type+" - this Type of the Select class method is not available  ");
			break;
		 
		 }
		 System.out.println("I'm validating that select value is selected or not ");
		 if(bool==true)
		 {
			 System.out.println(value+"-- value is selected by the SelectClass");
		 }
		 else
		 {
			 System.out.println(value+"-- value is not available in the Drop Down List Select Class check the  value next time ");
			 Assert.assertTrue(bool, value+"-- value is not available in the Drop Down List Select Class check the  value next time ");
		
		 // How to add logger information to here 
		 }
	 }
	 
}// Class level close 
