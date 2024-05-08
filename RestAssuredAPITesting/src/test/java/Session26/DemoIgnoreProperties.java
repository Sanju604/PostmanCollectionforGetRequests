package Session26;

import org.testng.annotations.Test;
import Session26.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//how to ignore unknown properties during deserialization
//fields which are available in pojo class called as known properties
//fields which are not available in pojo class called as Unknown properties
public class DemoIgnoreProperties {
	
	@Test
	public void testmethod1() throws JsonProcessingException
	{
	
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
	
	//String Employee=objMapp.writerWithDefaultPrettyPrinter().writeValueAsString(payload);
	//System.out.println(Employee);

	
	Employee emp2=objMapp.readValue(payload, Employee.class);
	System.out.println("Firstname "+ emp2.getFirstName());
	System.out.println("Lastname "+ emp2.getLastname());
    System.out.println("Age  "+ emp2.getAge());
    System.out.println("Gender "+ emp2.getGender());
    System.out.println("Salary "+ emp2.getSalary());
    System.out.println("IsMarried "+ emp2.isMarried());

    
	}


}
