package Session24;

import java.util.List;
import java.util.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class DemoJsonInclude {
	
	@Test
	public void testmethod1() throws JsonProcessingException
	{
	employeePojoClass emp=new employeePojoClass();
	emp.setFirstname("Suresh");
	//emp.setLastname("Mehra");
	emp.setSalary(500000);
	emp.setGender("Male");
	emp.setAge(35);
	emp.setMarried(false);
	String[] hobbies= new String[2];
	hobbies[0]="mn";
	hobbies[1]="op";
	ArrayList<String> degrees=new ArrayList<String>();
	HashMap<String,String> familyMembers=new HashMap<String,String>();
	familyMembers.put("abc", "def");
	emp.setHobbies(hobbies);
	emp.setDegrees(degrees);
	emp.setFamilyMembers(familyMembers);
	
	ObjectMapper objMapp=new ObjectMapper();
	
	String EmployeeJson=objMapp.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
	System.out.println(EmployeeJson);//it will return json object

	//RestAssured.given().header("Content-Type","application/json").body(EmployeeJson).
	//when().post("https://httpbin.org/post").then().statusCode(200).log().body();
	}

}
