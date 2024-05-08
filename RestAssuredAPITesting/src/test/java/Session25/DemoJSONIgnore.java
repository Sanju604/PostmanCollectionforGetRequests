package Session25;
import java.util.List;
import java.util.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Session20.Employee;
import io.restassured.RestAssured;

public class DemoJSONIgnore {
	
	@Test
	public void testmethod1() throws JsonProcessingException
	{
		employeePojoClass emp=new employeePojoClass();
	emp.setFirstname("Suresh");
	emp.setLastname("Mehra");
	emp.setSalary(500000);
	emp.setGender("Male");
	emp.setAge(35);
	emp.setMarried(false);
	emp.setFullname("Suresh Mehra");
	
	String payload="{\r\n"
			+ "  \"firstname\" : \"Suresh\",\r\n"
			+ "  \"lastname\" : \"Mehra\",\r\n"
			+ "  \"gender\" : \"Male\",\r\n"
			+ "  \"age\" : 35,\r\n"
			+ "  \"salary\" : 500000.0,\r\n"
			+ "  \"fullname\" : \"Suresh Mehra\",\r\n"
			+ "  \"married\" : false\r\n"
			+ "}";
	
	ObjectMapper objMapp=new ObjectMapper();
	
	String EmployeeJson=objMapp.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
	System.out.println(EmployeeJson);

	//RestAssured.given().header("Content-Type","application/json").body(EmployeeJson).
	//when().post("https://httpbin.org/post").then().statusCode(200).log().body();
	
	employeePojoClass emp2=objMapp.readValue(payload, employeePojoClass.class);
	System.out.println("Firstname "+ emp2.getFirstname());
	System.out.println("Lastname "+ emp2.getLastname());
    System.out.println("Age  "+ emp2.getAge());
    System.out.println("Gender "+ emp2.getGender());
    System.out.println("Salary "+ emp2.getSalary());
    System.out.println("Fullname "+ emp2.getFullname());

	}

}



