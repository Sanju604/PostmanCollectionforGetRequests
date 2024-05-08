package Session11;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationDemoOath {
	@Test
	public void Oath2Demo()
	{
		RequestSpecification requestSpec=RestAssured.given();
		requestSpec.baseUri("https://api.openweathermap.org");
		requestSpec.basePath("/data/2.5/weather");
		//requestSpec.queryParam("q", "delhi").
		//queryParam("appid", "fc9449")
		
		
		
	}

}
