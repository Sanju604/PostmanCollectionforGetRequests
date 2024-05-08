package Session20;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class SerializationAndDeserialization {
	@Test
	public void serializationandeserialization() throws JsonProcessingException
	{
		 Employee emp = new Employee();
		emp.setFirstName("Suresh");
		emp.setLastname("Mehra");
		emp.setSalary(500000);
		emp.setGender("Male");
		emp.setAge(35);
	
	
	ObjectMapper objMapp=new ObjectMapper();
	
String EmployeeJson=objMapp.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
System.out.println(EmployeeJson);//it will return json object

RestAssured.given().header("Content-Type","application/json").body(EmployeeJson).
when().post("https://httpbin.org/post").then().statusCode(200).log().body();
	
	//DESERIALIZATION
	Employee emp2=objMapp.readValue(EmployeeJson, Employee.class);
	System.out.println(emp2.getFirstName());
	System.out.println(emp2.getLastname());
    System.out.println(emp2.getAge());
    System.out.println(emp2.getGender());



	}

}

