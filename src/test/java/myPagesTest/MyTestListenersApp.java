package myPagesTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListenersApp extends BaseTest implements ITestListener { 
	// How to add unimplemented methods here and ,
	// how to access that Extent Reports Here To pass that reference values Howe to do this 
	
	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test is going to Start What I have to do here");
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test is Sucessed What I have to do here ");
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test is Skipped what I have to do here");
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test is Failed Here what I have to do Here");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {  // where we will use this case 
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {  // What I will do with I context  what I kill do 
		// TODO Auto-generated method stub

	}

}
