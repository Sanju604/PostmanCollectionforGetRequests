package Session14;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class ValidateXMLResponse {
	
	//https://petstore.swagger.io/v2/pet
	@Test(enabled=false)
	public void test1()
	{
		String XmlData="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		
		
		
		
		
		String jsonData="{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
	
	Response response=RestAssured.given().baseUri("https://petstore.swagger.io").basePath("/v2/pet")
			.header("accept","application/xml").header("Content-Type","application/json").body(jsonData).when().post();
	System.out.println(response.body().asString());
	Assert.assertEquals(response.statusCode(), 200);
	response.then().body("Pet.tags.tag.name", Matchers.equalTo("string")).log().body();
	
	
	/*              <?xml version="1.0" encoding="UTF-8"?>
	<Pet>
		<id>0</id>
		<Category>
			<id>0</id>
			<name>string</name>
		</Category>
		<name>doggie</name>
		<photoUrls>
			<photoUrl>string</photoUrl>
		</photoUrls>
		<tags>
			<Tag>
				<id>0</id>
				<name>string</name>
			</Tag>
		</tags>
		<status>available</status>
	</Pet>

	{
	  "id": 0,
	  "category": {
	    "id": 0,
	    "name": "string"
	  },
	  "name": "doggie",
	  "photoUrls": [
	    "string"
	  ],
	  "tags": [
	    {
	      "id": 0,
	      "name": "string"
	    }
	  ],
	  "status": "available"
	}                            */
	
	
	}
	@Test(enabled=false)
	public void test2()
	{
		String XmlData="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		
		
		
		
		
		String jsonData="{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
	
	Response response=RestAssured.given().baseUri("https://petstore.swagger.io").basePath("/v2/pet")
			.header("accept","application/json").header("Content-Type","application/json").body(jsonData).when().post();
	System.out.println(response.body().asString());
	Assert.assertEquals(response.statusCode(), 200);
	response.then().body("tags[0].name", Matchers.equalTo("string")).log().ifValidationFails();
	
	
	
	
	
	}
	
	
	
	
	
	
	@Test(enabled=true)
	public void test3()
	{
		String XmlData="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photourls>\r\n"
				+ "		<photourl>string</photourl>\r\n"
				+ "	</photourls>\r\n"
				+ "	<tags>\r\n"
				+ "		<tag>\r\n"
				+ "			<id>2</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		

	
	Response response=RestAssured.given().baseUri("https://petstore.swagger.io").basePath("/v2/pet")
			.header("accept","application/json").header("Content-Type","application/xml").body(XmlData).when().post();
	//System.out.println(response.body().asString());
	//Assert.assertEquals(response.statusCode(), 200);
	response.then().body("tags[0].name", Matchers.equalTo("string")).log().body();
	
	
	}
	
	@Test(enabled=true)
	public void test4()
	{
		String XmlData="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photourls>\r\n"
				+ "		<photourl>string</photourl>\r\n"
				+ "	</photourls>\r\n"
				+ "	<tags>\r\n"
				+ "		<tag>\r\n"
				+ "			<id>2</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		

	
	Response response=RestAssured.given().baseUri("https://petstore.swagger.io").basePath("/v2/pet")
			.header("accept","application/xml").header("Content-Type","application/xml").body(XmlData).when().post();
	//System.out.println(response.body().asString());
	//Assert.assertEquals(response.statusCode(), 200);
	response.then().body("Pet.tags.tag.name", Matchers.equalTo("string")).log().body();
	
	
	}
	
	
	
	
	
	
	

}
