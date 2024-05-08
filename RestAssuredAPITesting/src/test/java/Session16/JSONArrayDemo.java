package Session16;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class JSONArrayDemo {
	
	@Test(enabled=false)
	public void CreateuserusingJSONArray1()
	{//how to create JSON Array request body using JSON Object
		JSONObject user1=new JSONObject();
		user1.put("firstname", "Prachi");
		user1.put("lastname", "Gupta");
		user1.put("age", 28);
		user1.put("Salary", 10000.56);
		
		JSONObject user2=new JSONObject();
		user2.put("firstname", "Prerana");
		user2.put("lastname", "Gupta");
		user2.put("age", 28);
		user2.put("Salary", 10000.56);
		
		JSONObject user3=new JSONObject();
		user3.put("firstname", "Jatin");
		user3.put("lastname", "Gupta");
		user3.put("age", 28);
		user3.put("Salary", 10000.56);
		
		JSONArray jsonarray=new JSONArray();
		jsonarray.add(user1);
		jsonarray.add(user2);
		jsonarray.add(user3);
		RestAssured.given().baseUri("https://reqres.in/api/users").header("Content-Type","application/json").body(jsonarray).
		when().post().then().statusCode(201).log().body();
	}
	
	
	@Test(enabled=true)
	public void CreateuserusingJSONArray2()
	{//how to create JSON Array request body using List or Set
		//JSONObject user1=new JSONObject();
		HashMap<String,Object> user1=new HashMap<String,Object>();
		user1.put("firstname", "Prachi");
		user1.put("lastname", "Gupta");
		user1.put("age", 28);
		user1.put("Salary", 10000.56);
		
		//JSONObject user2=new JSONObject();
		HashMap<String,Object> user2=new HashMap<String,Object>();
		user2.put("firstname", "Prerana");
		user2.put("lastname", "Gupta");
		user2.put("age", 28);
		user2.put("Salary", 10000.56);
		
		//JSONObject user3=new JSONObject();
		HashMap<String,Object> user3=new HashMap<String,Object>();
		user3.put("firstname", "Jatin");
		user3.put("lastname", "Gupta");
		user3.put("age", 28);
		user3.put("Salary", 10000.56);
		

		ArrayList<HashMap<String,Object>> jsonarray=new ArrayList<HashMap<String,Object>>();
		jsonarray.add(user1);
		jsonarray.add(user2);
		jsonarray.add(user3);
		RestAssured.given().baseUri("https://reqres.in/api/users").header("Content-Type","application/json").body(jsonarray).
		when().post().then().statusCode(201).log().body();
	}
	
	
	
	

}
