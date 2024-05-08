package Session03;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.collection.HasItemInArray;
import org.testng.annotations.Test;

import  io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matcher.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

public class Test01_GetMethod {
	@Test(enabled=false)
	public void test01()
	{
			Response response=RestAssured.get("https://reqres.in/api/users?page=2");
			

						 System.out.println(response.statusCode()); 
			  System.out.println(response.getTime());
		 
			System.out.println(response.getStatusLine());
			System.out.println(response.asString());
			System.out.println(response.contentType());
			System.out.println(response.getBody().asString());
			System.out.println(response.getTime());
			System.out.println(response.timeIn(TimeUnit.MILLISECONDS));
			System.out.println(response.body());
		
	}
	
	@Test(enabled=true)
	public void test02()
	{
			RestAssured.baseURI="https://reqres.in";
			RestAssured.basePath="/api/users";
			RestAssured.given().log().all().queryParam("page", 2,"page2",4).when().get().then().assertThat()
			.statusCode(200).statusLine("HTTP/1.1 200 OK").log().body();
		
			}
	

	
	
	@Test(enabled=false)
	public void test04()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.	given().queryParam("page", 2).queryParam("id", 7).
		when().get().then().statusCode(200).statusLine("HTTP/1.1 200 OK").
		header("Content-Type", "application/json; charset=utf-8").log().everything();
				
				
			}
	







}
