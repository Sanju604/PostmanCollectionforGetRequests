package Session15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonObjectUsingJavaMapDemo {
	
	@Test(enabled=false)
	public void CreateAuthToken1()
	{
		
		Map<String,String> Authtoken=new HashMap<String,String>();
		Authtoken.put("username", "admin");
		Authtoken.put("password", "password123");
		Response response=RestAssured.given().baseUri("https://restfull-booker.herokuapp.com/auth").contentType(ContentType.JSON).body(Authtoken).post();
		response.prettyPrint();
	}
	
	@Test(enabled=true)
	public void CreateAuthToken2()
	{
		/*{
		    "firstname" : "Amod",
		    "LastName":"Mahajan",
		    "Age":28,
		    "Salary":10000.50,
		    "IsMarried":true,
		"Hobbies":["Music","Computer","Games"],
		"Techskills":{
		"Programming language":["Java","C++","C#"]
		"WebAutomation":"Selenium",
		"API Automation":"RestAssured"
		        }
		"Address":[{“AddressType”,”Home”,
                “City”,”Mumbai”}
{“AddressType”,”Office”,

“City”,”Delhi”
       }
]
		}*/
		ArrayList<String>hobbies=new ArrayList<String>();
        hobbies.add("Music");
        hobbies.add("Computer");
        hobbies.add("Games");
        ArrayList<String>languages=new ArrayList<String>();
        languages.add("Java");
        languages.add("C++");
        languages.add("C#");
        HashMap<String,Object> techskills=new HashMap<String,Object>();
        techskills.put("Programming language", languages);
        techskills.put("WebAutomation", "Selenium");
        techskills.put("API Automation", "RestAssured");
        HashMap<String,String> address1=new HashMap<String,String>();
        address1.put("AddressType", "Home");
        address1.put("City", "Mumbai");
        HashMap<String,String> address2=new HashMap<String,String>();
        address2.put("AddressType", "Office");
        address2.put("City", "Pune");
        ArrayList<HashMap<String,String>>addre=new ArrayList<HashMap<String,String>>();
        addre.add(address1);
        addre.add(address2);
		HashMap<String,Object> Authtoken=new HashMap<String,Object>();
		Authtoken.put("firstname","Amod");
		Authtoken.put("LastName","Mahajan");
        Authtoken.put("Age",28);
        Authtoken.put("Salary",10000.50);
        Authtoken.put("IsMarried",true);
        Authtoken.put("Techskills",techskills);
        Authtoken.put("Hobbies",hobbies);
        Authtoken.put("Address",addre);
      RestAssured.given().baseUri("https://reqres.in/api/users").contentType(ContentType.JSON).body(Authtoken).when().post().then().log().all();
		
        
        

		
	}
	
	@Test(enabled=false)
	public void CreateAuthToken3()
	{
		
		Map<String,String> Authtoken=new HashMap<String,String>();
		Authtoken.put("username", "admin");
		Authtoken.put("password", "password123");
		//Response response=RestAssured.given().baseUri("https://restfull-booker.herokuapp.com/auth").contentType(ContentType.JSON).body(Authtoken).post();
		System.out.println(Authtoken);
		
		JSONObject json=new JSONObject();
		json.put("name", "prachio");
		json.put("job", "dev");
		System.out.println(json);
	}
		
		@Test(enabled=false)
		public void main(){  
			   HashMap<Integer,String> map=new HashMap<Integer,String>();//Creating HashMap    
			   map.put(1,"Mango");  //Put elements in Map  
			   map.put(2,"Apple");    
			   map.put(3,"Banana");   
			   map.put(1,"Grapes"); 
			   System.out.println(map);
	
	}
	


}


