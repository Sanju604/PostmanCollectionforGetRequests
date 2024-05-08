package Session12;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class DeserilizationJsonDemo {
	@Test
	public void test3()
	{
		
		JSONObject json=new JSONObject();
		json.put("name", "prachio");
		json.put("job", "dev");
	RestAssured.baseURI="https://reqres.in/api/users";
	Response response=RestAssured.given().header("Content-Type","application/json").contentType(ContentType.JSON).body(json.toJSONString()).
	when().post();
	
	ResponseBody responsebody=response.getBody();
	//System.out.println(response.jsonPath().get("job").toString());
	//System.out.println(json.toJSONString());
	//System.out.println(json);
	//System.out.println(response.);



	JSONPostRequestResponse res=responsebody.as(JSONPostRequestResponse. class);
	Assert.assertEquals(res.name,"prachio" );
	Assert.assertEquals(res.job, "dev");
	//Assert.assertEquals(res.id, null);
	//Assert.assertEquals(res.createdAt, null);
	
	
	}

}
