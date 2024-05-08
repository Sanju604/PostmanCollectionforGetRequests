package Session04;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class CheckForValidResponse {
	
	
	@Test(enabled = false)
	public void GetSingleUserUsingValidatableResponse()
	{
		
		//RestAssured.baseURI="https://reqres.in/api/users/2";
		//RequestSpecification request=RestAssured.given();
		//Response response=request.get();
		//int statusCode=response.getStatusCode();
		//Assert.assertEquals(statusCode, 2000);
		//String StatusLine=response.getStatusLine();
		//Assert.assertEquals(StatusLine, "HTTP/1.1 200 OK");
		
		
	}
	@Test(enabled = false)
	public void GetSingleUser()
	{
		
		//RestAssured.baseURI="https://reqres.in/api/users/2";
		//RequestSpecification request=RestAssured.given();
		//Response response=request.get();
		//ValidatableResponse ValidateRes=response.then();
		//ValidateRes.statusCode(200);
		//System.out.println("before Second validation,if status code fails then it wont execute Status line");
		//ValidateRes.statusLine("HTTP/1.1 200 OK");
	}
	
	//errors occured due to make that restassured class as statis and .*. it wiil go by removing them
		@Test
		public void GetSingleUserUsingBdd()
		{
			baseURI="https://reqres.in/api/users/2";
			given()
			
			
			.when()
			.get()
			
			.then()
			.statusCode(200);
			
		}
		
		@Test
		public void GetSingleUserUsingBdd2()
		{
		
			given()
			
			
			.when()
			.get("https://reqres.in/api/users/2")
			
			.then()
			.statusCode(200);
			
		}
		
		@Test
		public void GetSingleUserUsingBdd3()
		{
		
			given()
			.get("https://reqres.in/api/users/2")
		
			
		.then()
			.statusCode(200);
			
		}
		
		@Test
		public void GetSingleUserUsingBdd4()
		{
		
			when()
			.get("https://reqres.in/api/users/2")
		
		
		.then()
			.statusCode(200);
			
		}
		
	}

