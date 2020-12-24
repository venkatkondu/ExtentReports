package myPagesTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

//@Listeners(MyTestListenersApp.class) // this will recognize the predefined methods automatically 
public class BaseTest {
	
	public static WebDriver driver;
	//public static Logger logger;
	
	// How to configure ExtentReports in this class how to do that 
	
	// How to configure that Extent reports Things 
	
	
	protected BaseTest() // by this protected access modifiers we can access this class variables only its subclass only 
	{
		// I will check about this thing where we will use 
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("\t----- @BeforeSuite  ------");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("\t----- @AfteSuite ------");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("\t----- @BeforeTest ------");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("\t----- @AfterTest ------");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("\t----- @BeforeClass ------");
	

	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("\t----- @AfterClass ------");
	}
	
	
	/*
	 * @Test public void test000() { * }
	 */	
	
@BeforeGroups // when I will use this methods 
public void beforeGroups()
{
	System.out.println("\t --------- @Before Groups -------------------- ");
}
@AfterGroups
public void afterGroups()
{
	System.out.println("\t ----------- @AfterGroups ----------------------");
}

	
}
