package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	int count=0;
	int rangeCount=3;
	
	//int rangeCount=Integer.parseInt("String"); //get the value from the property file
	
	@Override
	public boolean retry(ITestResult result) { // By this method means giving a chance a failed @Test method 
								// in the Test class 
		
		if(count<rangeCount)
		{
			count++;  // as per my expectation this will return deliberately re executing the @Test method if method is failed 
			return true; /// true means :: this means @Test method is 
		} // the above menas re -executing the @Test method again repete execution  the  because it failes
		
		
		return false; // false means what : :  even though the specified number of times it will return the same thing like failed the test case then it will automatically consider as failed the Test case it is 
	}
// How to implement this How to attach this things into the main things How to run this program 
	// Where I have to call this method 
	
	
	
	
}
