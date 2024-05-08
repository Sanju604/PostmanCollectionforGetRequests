package Session05;

import  static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {
	
	@Test(enabled = true)
	public void GetSingleUserUsingValidatableResponse()
	{
		RequestSpecification requestSpec=RestAssured.given();
		requestSpec.baseUri("https://reqres.in/");
		requestSpec.basePath("api/users?page=2");
		Response response=requestSpec.get();
		//System.out.println(response.header("Server"));
		//System.out.println(response.headers());
		//System.out.println("###################################");
		//System.out.println(response.getHeader("Server"));
		//System.out.println(response.getHeaders());
		//to reade all the response header attributes/key and print their values
		Headers headers=response.getHeaders();
		System.out.println(headers.getValue("Content-Type"));
		//for(Header a:headers)
		//{
			//System.out.println("Key: "+a.getName()+"   Value  "+a.getValue());
		//}
		String ExpectedContentType=response.header("Content-Type");
		Assert.assertEquals(ExpectedContentType, "application/json; charset=utf-8","error Message");
		
	}
	
	@Test(enabled = false)
	public void GetSingleUserUsingValidatableResponseBdd()
	{
		baseURI="https://reqres.in/api/users?page=2";
		given()
		
		
		.when()
		.get()
		
		.then()
		.statusCode(200).header("Content-Type","application/json; charset=utf-8");
		
	}

}
