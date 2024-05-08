package Session21;

import Session20.Employee;
import Session22.EmployeePojoClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import  com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONArrayPOJOClassDemo {

	@Test(enabled=true)
	public void createEmpolyeeJSONArray() throws JsonProcessingException
	{
		//Create first Employee JSON Object

		Employee emp1 = new Employee();
		emp1.setFirstName("Suresh");
		emp1.setLastname("Mehra");
		emp1.setSalary(500000);
		emp1.setGender("Male");
		emp1.setAge(35);


		//Create Second Employee JSON Object
		Employee emp2 = new Employee();
		emp2.setFirstName("Rama");
		emp2.setLastname("Singh");
		emp2.setSalary(40000);
		emp2.setGender("Male");
		emp2.setAge(25);

		//Create third Employee JSON Object
		Employee emp3 = new Employee();
		emp3.setFirstName("Sita");
		emp3.setLastname("Gupta");
		emp3.setSalary(200000);
		emp3.setGender("Female");
		emp3.setAge(55);
		
		ArrayList<Employee> listOfEmp=new ArrayList<Employee>();
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);
		
		ObjectMapper obj=new ObjectMapper();
		//convert employee class object to JSON Array payload as string
		
	String jsonArrayPayload= obj.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmp);
		//System.out.println(jsonArrayPayload);
		
		Response response=RestAssured.given().header("Content-Type","application/json").body(jsonArrayPayload).
	when().post("https://httpbin.org/post");
		System.out.println(response.getBody().asPrettyString());
			
		List<Employee> allEmployees =response.jsonPath().getList("json", Employee.class);
	for(Employee emp:allEmployees)
			{
System.out.println(emp.getAge());
		

}

	}
	
	
	
	
	
	
	
	@Test(enabled=false)
	public void createEmpolyeeJSONArray2() throws JsonProcessingException
	{
		//Create first Employee JSON Object

		Employee emp1 = new Employee();
		emp1.setFirstName("Suresh");
		emp1.setLastname("Mehra");
		emp1.setSalary(500000);
		emp1.setGender("Male");
		emp1.setAge(35);


		//Create Second Employee JSON Object
		Employee emp2 = new Employee();
		emp2.setFirstName("Rama");
		emp2.setLastname("Singh");
		emp2.setSalary(40000);
		emp2.setGender("Male");
		emp2.setAge(25);

		//Create third Employee JSON Object
		Employee emp3 = new Employee();
		emp3.setFirstName("Sita");
		emp3.setLastname("Gupta");
		emp3.setSalary(200000);
		emp3.setGender("Female");
		emp3.setAge(55);
		
		ArrayList<Employee> listOfEmp=new ArrayList<Employee>();
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);
		
		ObjectMapper obj=new ObjectMapper();
		String jsonArrayPayload= obj.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmp);
		//Employee emp4=RestAssured.given().header("Content-Type","application/json").body(jsonArrayPayload).
	//when().post("https://httpbin.org/post").as(Employee.class);
		
		//Newly added lines
		
		
		Employee emp5=obj.readValue(jsonArrayPayload, Employee.class);
		System.out.println(emp5.getAge());
		



	}

}
