package Session23;
import static org.testng.Assert.assertEquals;

import java.util.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Session20.Employee;
import Session22.EmployeeAddress;
import Session22.EmployeePojoClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DemoTestComplexNestedJSONobject {
	/*"Company Name":"XYZ LTD",
	"Street":"Africa Avenue",
	"City":"RK Puram Delhi",
	"State":"New Delhi",
	"Pin":"110066",
	"Bank Accounts":["HDFC","SBI","AXIS"],
	*/
	@Test
	public void createUser() throws JsonProcessingException
	{
		
		NestedJSONPojoClass requestpayload=new NestedJSONPojoClass();
		requestpayload.setCompanyName("XYZ LTD");
		requestpayload.setStreet("Africa Avenue");
		requestpayload.setCity("RK Puram Delhi");
		requestpayload.setState("New Delhi");
		requestpayload.setPin("110066");
		ArrayList<String> banks=new ArrayList<String>();
		banks.add("HDFC");
		banks.add("SBI");
		banks.add("AXIS");
		requestpayload.setBankAccount(banks);
		
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
		
		EmployeePojoClass emp2=new EmployeePojoClass();
		emp2.setFirstname("Amit");
		emp2.setLastname("Mishra");
		emp2.setGender("Male");
		emp2.setSalary(1);
		emp2.setAge(2);
        EmployeeAddress emp2Address=new EmployeeAddress();
		emp2Address.setState("a");
		emp2Address.setCity("b");
		emp2Address.setStreet("c");
		emp2Address.setPin(530012);
		emp2.setAddress(emp2Address);
		
		EmployeePojoClass emp3=new EmployeePojoClass();
		emp3.setFirstname("Ashish");
		emp3.setLastname("Das");
		emp3.setGender("Male");
		emp3.setSalary(3);
		emp3.setAge(4);
        EmployeeAddress emp3Address=new EmployeeAddress();
		emp3Address.setState("d");
		emp3Address.setCity("e");
		emp3Address.setStreet("f");
		emp3Address.setPin(530012);
		emp3.setAddress(emp3Address);
		
		ArrayList<EmployeePojoClass> employees=new ArrayList<EmployeePojoClass>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		
		requestpayload.setEmployeeList(employees);
		
ObjectMapper objMapper=new ObjectMapper();
		
		String z=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestpayload);
		//System.out.println(z);
		
		//Response response=RestAssured.given().header("Content-Type","application/json").body(z).
				//when().post("https://httpbin.org/post");
					//System.out.println(response.getBody().asPrettyString());
					
		
		//newly added lines
		NestedJSONPojoClass emp5=objMapper.readValue(z, NestedJSONPojoClass.class);
					System.out.println(emp5.getCity());
					System.out.println(emp5.getEmployeeList().getLast().getFirstname());
					System.out.println(emp5.getEmployeeList().get(0).getAddress().getStreet());
				assertEquals(emp5.getEmployeeList().get(0).getAddress().getStreet(), "Park Avenue");
		
	}
	

}
