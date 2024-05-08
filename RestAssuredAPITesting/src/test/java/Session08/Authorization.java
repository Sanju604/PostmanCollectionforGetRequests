package Session08;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Authorization {
	
	@Test(enabled=false)
	public void BasicNonPreemptiveAutherization()
	{
		
		
	given().baseUri("https://postman-echo.com/").basePath("/basic-auth").auth().basic("postman", "password").when().get().then().statusCode(200);
		
		
		
	}
	
	@Test(enabled=false)
	public void BasicPreemptiveAutherization()
	{
		
		
	given().baseUri("https://postman-echo.com/").basePath("/basic-auth").auth().preemptive().basic("postman", "password").when().get().then().statusCode(200);
		
		
		
	}
	
	@Test
	public void DigestAutherization()
	{
		
		
	RequestSpecification requestSpec=RestAssured.given();
		requestSpec.baseUri("https://httpbin.org");
		requestSpec.basePath("/digest-auth/undefined/sanju/sanju");
		Response response=requestSpec.auth().digest("sanju", "sanju").when().get();
		String responsebody=response.getBody().asString();
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.body().asString());
		Assert.assertEquals(response.statusCode(), 200);
	
		
	}

}
