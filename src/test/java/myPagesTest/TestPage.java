package myPagesTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPage extends BaseTest {
	
	

	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("\t----- @BeforeMethod ------");
	}
	

	@Test(priority=1,groups="class_1")
	public void test001()
	{
		System.out.println("\t --  ----");
	}
	
	
	@Test(priority=2,groups="class_1",dependsOnMethods="test001")// any other things later on I will update as per the requirement
	public void test002()
	{
		System.out.println("\t --  ----");	}

	
	@Test(priority=3,groups="class_1",dependsOnMethods="test001")
	public void test003()
	{
		System.out.println("\t --  ----");
		
	}

	
	@Test(priority=4,groups="class_1",dependsOnMethods="test001")
	public void test004()
	{
		System.out.println("\t --  ----");
		
	}
	
	@Test(priority=5,groups="class_1",dependsOnMethods="test001")
	public void test005()
	{
		System.out.println("\t --  ----");
	}

	
	@Test(priority=6,groups="class_2")
	public void test006()
	{
		System.out.println("\t --  ----");
		
	}

	
	@Test(priority=7,groups="class_2",dependsOnMethods="test006")
	public void test007()
	{
		System.out.println("\t --  ----");
		
	}

	
	@Test(priority=8,groups="class_2",dependsOnMethods="test006")
	public void test008()
	{
		System.out.println("\t --  ----");
	}

	
	@Test(priority=9,groups="class_3")
	public void test009()
	{
		System.out.println("\t --  ----");
		AssertJUnit.assertTrue(false); // I deliberately failed this group
	}

	
	@Test(priority=10,groups="class_3",dependsOnMethods="test009")
	public void test010()
	{
		System.out.println("\t --  ----");
		
	}

	@Test(priority=11,groups="class_3",dependsOnMethods="test009")
	public void test011()
	{
		System.out.println("\t --  ----");
		
	}

	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("\t----- @AfterMethod ------");
	}
	
	

	@Test
	public void test()
	{
		
	}

}
