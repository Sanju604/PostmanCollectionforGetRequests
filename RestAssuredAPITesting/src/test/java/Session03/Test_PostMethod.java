package Session03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test_PostMethod 
{
@Test(enabled=true)
	public void test3()
	{
	JSONObject json=new JSONObject();
	ArrayList<String>languages=new ArrayList<String>();
    languages.add("Java");
    languages.add("C++");
    languages.add("C#");
    JSONObject abc=new JSONObject();
    abc.put("ProgrammingLanguages", "Java");
    abc.put("WebAutomation", "Selenium");
    abc.put("APIAutomation", "RestAssured");
    
    
	json.put("name", "prachio");
	json.put("job", "dev");
	json.put("languages", languages);
	json.put("techskills", abc);
	
RestAssured.baseURI="https://reqres.in/api/users";
RestAssured.given().header("Content-Type","application/json").body(json).log().everything().
when().post().then().statusCode(201).log().ifValidationFails();


	 



}
		}
	
	
	
	

