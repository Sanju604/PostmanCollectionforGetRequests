package Session22;

import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Session20.Employee;
import Session25.employeePojoClass;
import Session27.EmpPojoClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DemoNestedJSONPayload {
	
	@Test
	public void createUser() throws JsonProcessingException
	{
		
		EmployeePojoClass emp1=new EmployeePojoClass();
		emp1.setFirstname("Suresh");
		emp1.setLastname("Mehra");
		emp1.setGender("Male");
		emp1.setSalary(35000);
		emp1.setAge(45);

		
		EmployeeAddress emp1Address=new EmployeeAddress();
		emp1Address.setState("Andhra Pradesh");
		emp1Address.setCity("Vijayawada");
		emp1Address.setStreet("Park Avenue");
		emp1Address.setPin(530012);
		emp1.setAddress(emp1Address);
		ObjectMapper objMapper=new ObjectMapper();
		
		String z=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println(z);
		EmployeePojoClass emp2=objMapper.readValue(z, EmployeePojoClass.class);
		System.out.println(emp2.getAddress().getCity());
		

		
			
	
		

	}
}
