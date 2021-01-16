package Utilities;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//This is Listener Class for Generating ExtentReports 
public class ExtentReporting extends TestListenerAdapter{ // ths is is actually a listener class 
// below  variables are available up to this class only 
	// If I want to access below variables I will use  Encapsulation concept in Java 
	// Use public setter and public getter method 
	private String testerName="Venkat"; // I will check later on about this values where I have to get this things 
	private String testLead="TestLead";
	private String manager="Manager";
	
	private String system="Ubuntu_18.O4";
	private String browser="Chrome_87_Ver";
	private String smoke="SmokeTesting";
	private String sanity="SanityTesting";
	private String regression="RegressionTesting";
	private String function="FunctionalTesting";
	private String retesting="ReTesting";
	
	// I am not able to generating the reporting why what the reason
	private ExtentReports extentReports=null; // this is common for all the extent Reports 
	
	private ExtentSparkReporter sparkReporter=null ;// this is for where I have to store 
	// For the scope defined this reference variables are make it in private for testing prospective
	private ExtentTest test=null; // this is for each test I use this reference 
	
	@Override 
	public void onStart(ITestContext context) // Yes this method is execute only once in entire execution
	{ //	This things only execute only one times my requirements.
		// load the above references 
			
		
		System.out.println("I am in ExtentReporting for generatiing the ExgentSparkReporter ");
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// for time stamp
		String reportName="./test-output/ExtentReports/SparkReports-"+timeStamp+".html";
		System.out.println("With report name I have to store ="+reportName);
				
		extentReports=new ExtentReports();
		
		sparkReporter=new ExtentSparkReporter(reportName);
		extentReports.attachReporter(sparkReporter);
		
		//this.sparkReporter.loadXMLConfig(xmlFile);
		System.out.println("SparkReporterRefference - "+sparkReporter);
		
		System.out.println("ExtentReports Reference-"+extentReports );
		
		
		extentReports.setSystemInfo("hostName", "localhost");
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.setSystemInfo("User", "Venkat");
		extentReports.setSystemInfo("System", "Ubuntu 18.O4");
		extentReports.setSystemInfo("Browser", "Chrome_87");
		extentReports.setSystemInfo("Test", "Test");
		
		
		
		
		// for below this I need it's dependence I will tyr later on about this 
			//ExtentKlovReporter klovReporter=new ExtentKlovReporter("./extentReports/klovReports/index.html");
		//	klovReporter.
		//extentReports.attachReporter(sparkReporter,klovReporter);// we can add later on Number of reporter accordingly 
		extentReports.attachReporter(sparkReporter);
		
		
		// How to set the image logo for this html document  later on I will check 
	
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Automation report By Venkat");
		sparkReporter.config().setTheme(Theme.STANDARD);
	
		//	this.sparkReporter.config().setCss(css);
		
		
		//test=this.extentReports.createTest(result.getName()); //this will execute each test I want to execute this 
		
	}
	@Override
	public void onFinish(ITestContext context) // this method will execute lastly 
	{
		System.out.println("This is ofFinish(ITestContext context)");
		extentReports.flush(); // this I have to mention  without this I can not create a HTML report without this method calling 
	//	extentReports.				// Even though all methods and lines declared the above method call is must be required 
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("TestCase is sucess");
		// For every Test I will create a node for every test How to do this 
		
		test=this.extentReports.createTest(result.getName());// for method name for
		
		System.out.println("Test Node is created with name- "+result.getName());
		test.info(result.getName()+"-informantion").assignAuthor(testerName).assignAuthor(manager).assignAuthor(testLead).assignCategory(smoke).assignCategory(sanity).assignCategory(function).assignCategory(regression).assignDevice(system).assignDevice(browser);
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		test.pass(result.getName()+"- this test case Passed ");
		
		
	}
	@Override
	public void onTestSkipped(ITestResult result)// for every Test is skipped time I will create a label for this test skip 
	{       /// for create  a Node like on New row of the Test case I will use below code 
		System.out.println("Test case is skipped ");
		test=this.extentReports.createTest(result.getName());
		System.out.println("Test Node is created with name- "+result.getName());
		test.info(result.getName()+"-informantion").assignAuthor(testerName).assignCategory(smoke).assignCategory(sanity).assignCategory(function).assignCategory(regression).assignDevice(system).assignDevice(browser);
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
		test.skip(result.getName()+"-Test case is Skipped ");
		
	
	}
	
	@Override // in this scenario i want to take the screenshot How to do this 
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test case is Failed ");
		test=this.extentReports.createTest(result.getName());
		System.out.println("Test Node is created with name- "+result.getName());
		test.info(result.getName()+"-informantion").assignAuthor(testerName).assignCategory(smoke).assignCategory(sanity).assignCategory(function).assignCategory(regression).assignDevice(system).assignDevice(browser);
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
		test.fail(result.getName()+"- Test case is Failed ");
		// for screenshot I will update later on about this 
		
		
	}

}
