package Session13;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import junit.framework.Assert;

public class CreateUser {
	@Test
	public void test3()
	{
		
		JSONObject json=new JSONObject();
		json.put("name", "prachio");
		json.put("job", "dev");
	
	RequestSpecification reqSpec=RestAssured.given().baseUri("https://reqres.in").header("Content-Type","application/json").basePath("/api/users").queryParam("page","2")
			.body(json.toJSONString()).header("headerName1","headerValue1");
	
	QueryableRequestSpecification queryRequest=SpecificationQuerier.query(reqSpec);
	Assert.assertEquals(queryRequest.getBasePath(), "/api/users");
	System.out.println(queryRequest.getBaseUri());
	System.out.println(queryRequest.getBasePath());
	System.out.println(queryRequest.getContentType());
	System.out.println(queryRequest.getURI());
	System.out.println(queryRequest.getBody().toString());
	System.out.println(queryRequest.getQueryParams());
	Headers allheaders=queryRequest.getHeaders();
	for(Header b:allheaders)
		{
		System.out.println(b.getName()+"  "+b.getValue());
	}

	
	
	
	
	}

}
