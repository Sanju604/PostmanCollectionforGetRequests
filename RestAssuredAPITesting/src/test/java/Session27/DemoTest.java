package Session27;

import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoTest {
	
		
	@Test(enabled=false)
	public void testmethod1()
		{
		RequestSpecification requestSpec=RestAssured.given();
	requestSpec.baseUri("https://run.mocky.io/v3/58c3d1ed-512a-445f-8008-88aa9882ea76");
	
	Response response=requestSpec.when().get();
	String responsebody=response.getBody().asString();
	System.out.println(responsebody);
	Assert.assertEquals(response.statusCode(), 200);

}
	
	@Test
	public void testmethod2()
		{
		RequestSpecification requestSpec=RestAssured.given();
	requestSpec.baseUri("https://run.mocky.io/v3/58c3d1ed-512a-445f-8008-88aa9882ea76");
	
	EmpPojoClass emp=requestSpec.when().get().as(EmpPojoClass.class);
	System.out.println(emp.getFirstname());
	System.out.println(emp.getLastname());
	System.out.println(emp.getGender());
	System.out.println(emp.getSalary());
	System.out.println(emp.getAge());
	System.out.println(emp.getHobbies());
	for(String hobbi:emp.getHobbies())
	{
		System.out.println(hobbi);	
	}
	
	for(Entry<String, String> entry: emp.getFamilymembers().entrySet()) {
	      System.out.println(entry.getKey()+"   "+entry.getValue());
	      //System.out.print(", ");
	    }
	
	
	
	//System.out.println(emp.getFamilymembers());
	

}
}
