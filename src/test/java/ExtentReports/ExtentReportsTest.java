package ExtentReports;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsTest {
	String browser="chrome_87";
	String mechine="Ubatu_18.O4";
	String preparedBy="Venkat";
	String teamLead="TeamLead";
	String manager="Manager";
	
	@Test
	public void reportTest()
	{
// my intention is generate the Extent Spark Reports by using Java  is in TestNG pluggin 
		
		ExtentReports extentReports=new ExtentReports();
		
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter("./extentReports/sparkReports/index.html");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Automation Reports");
		sparkReporter.config().setReportName("<h3><center>Prepared Venkat</center></h3>");
		//sparkReporter.config().
		
		
		// for below this I need it's dependence I will tyr later on about this 
			//ExtentKlovReporter klovReporter=new ExtentKlovReporter("./extentReports/klovReports/index.html");
		//	klovReporter.
		//extentReports.attachReporter(sparkReporter,klovReporter);// we can add later on Number of reporter accordingly 
		extentReports.attachReporter(sparkReporter);
		
							//For create test Node in the Report 
		ExtentTest test=extentReports.createTest("Login_Test");// this create the tags for the Each TestMethod
		test.info("This is for Login Test Functionality").assignAuthor(manager).assignAuthor(preparedBy).assignAuthor(teamLead).assignCategory("SmokeTest").assignCategory("RegressionTest").assignCategory("SanityTest").assignDevice(mechine).assignDevice(browser);
		//test.pass("URL is launched "); // these are all create a Test Step  Node in the Report
		//test.pass("Values are entered correct");
		//test.pass("I will check about this later on");
		
		test.info("Application Login page is opened");
		test.info("User name is write in text feld");
		test.info("user Password is wrote in that password feild");
		test.info("user Cllic on Login button");
		test.pass("Login sucessfully ");
		
		// test.fail("This is for Test  Fail Time ");
		// test.skip("THis is for Test Skipped Time this will "); // these are all logs over loaded methods
		// test.info("This will is for INformatin of the Test ");
		/*
		 * // debug , fatal , error .. Removed in 5th version ,and these are logs
		 * information. test.fatal(); test.error(); test.debug();
		 */
		
		
		// For one more node creation in Test Report 
		
		ExtentTest test2=extentReports.createTest("Home Page Test");
		test2.info("This is for HomePage Test ").assignAuthor(preparedBy).assignAuthor(teamLead).assignCategory("RegressionTest").assignDevice(mechine).assignDevice(browser);
		test2.pass("This test is passed");
		
		ExtentTest test3=extentReports.createTest("This is LogOutRunction");
		test3.info("This test is for Logout Functionality ").assignAuthor(preparedBy).assignCategory("SmokeTest").assignDevice(mechine).assignDevice(browser);
		Assert.fail("Due to some resons this test is fail ");
		
		extentReports.flush();// this is for create the test Nodes the HTML Report
			// otherwise in Html Report Nodes will not create without this statement 
		//klovReporter.flush(entity);
	}
	
	
}
