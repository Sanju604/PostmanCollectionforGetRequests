package Session09;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationDemo {
	
	@Test
	public void BarearToken()
	{
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("name", "prachin");
		jsonobject.put("gender", "Female");
        jsonobject.put("email", "prachin@gmail.com");
        jsonobject.put("status", "Active");

		
String AuthToken="Bearer fc9449dd9b2836e8091ec1167d1061725869fa1b501c9694b1d33c355b8065c0";
	
RequestSpecification requestSpec=RestAssured.given();
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");
		Response response=requestSpec.headers("Authorization", AuthToken).contentType(ContentType.JSON).body(jsonobject.toJSONString()).get();
		String responsebody=response.getBody().asString();
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.body().asString());
		Assert.assertEquals(response.statusCode(), 201);
		
	
		
	}

}
