package Session02;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Class03 {
	
	@Test  
	public void test06()
	{
		System.out.println("my sixth Test");
	}
	
	@Test  
	public void test07()
	{
		System.out.println("my seventh Test");
	}
	
	@Test
	@Parameters({"a","b"})
	public void test08(int a, int b)
	{
		System.out.println(a+b);
	}

}
