package Session07;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameterDemo {
	
	
	@Test
	public void filterData()
	{
		RequestSpecification requestSpec=RestAssured.given();
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users");
		requestSpec.queryParam("page", "2").queryParam("id", "10");//to give multiple query parameter to filter the records
		Response response=requestSpec.get();
		String firstname=response.jsonPath().get("data.first_name");;
		System.out.println(firstname);
		Assert.assertEquals(firstname,"Byron");
		
		
		
		//String responsebody=response.getBody().asString();
		//System.out.println("Response body" + responsebody);
		
	}

}
