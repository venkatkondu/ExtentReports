package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyAnnotationTransformer implements IAnnotationTransformer {
	
	@Override 													// below these Constructor and Method get from the java.lang.reflect.Constructor,Method
	public void transform(ITestAnnotation annotation,Class testClass, Constructor testConstructor, Method testMethod)
	{
		
		
		annotation.setRetryAnalyzer(MyRetryAnalyzer.class); // some more things I have to added later on
		
		
	}

}
