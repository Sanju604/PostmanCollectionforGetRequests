package Session06;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJsonResponseBody {
	
	@Test(enabled = false)
	public void UserListResponseBody()
	{
		RequestSpecification requestSpec=RestAssured.given();
		requestSpec.baseUri("https://reqres.in/");
		requestSpec.basePath("api/users?page=2");
		Response response=requestSpec.get();
		System.out.println(response.body().asString());
		System.out.println("###############");
		System.out.println(response.getBody().asString());
		String responseString=response.body().asString();
		Assert.assertEquals(responseString.contains("George"),true);
	}
	@Test(enabled = true)
	public void UserListResponseBody1()
	{
		RequestSpecification requestSpec=RestAssured.given();
		requestSpec.baseUri("https://reqres.in/");
		requestSpec.basePath("api/users?page=2");
		Response response=requestSpec.get();
		ResponseBody responsebody=response.getBody();
		System.out.println(responsebody.asString());
		JsonPath jsonpathview=responsebody.jsonPath();
		String firstName=jsonpathview.get("data[0].first_name");
		System.out.println(firstName);
		Assert.assertEquals(firstName,"George");
		
		
		
		
	}

}
