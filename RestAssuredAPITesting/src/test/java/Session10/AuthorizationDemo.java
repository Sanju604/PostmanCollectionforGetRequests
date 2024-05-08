package Session10;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationDemo {
	
	@Test
	public void GetWeatherDataByCity()
	{
		
		//https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
	
	
RequestSpecification requestSpec=RestAssured.given();
		requestSpec.baseUri("https://api.openweathermap.org");
		requestSpec.basePath("/data/2.5/weather");
		Response response=requestSpec.queryParam("q", "delhi").queryParam("appid", "fc9449dd9b2836e8091ec1167d1061725869fa1b501c9694b1d33c355b8065c0").get();
		String responsebody=response.getBody().asString();
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.body().asString());
		Assert.assertEquals(response.statusCode(), 200);
		
	
		
	}


}
