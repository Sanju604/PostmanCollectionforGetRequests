package Session14;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTravellersData {
	
	
		@Test(enabled=false)
		public void gettravellerdata1()
		{
			
			

		Response response=RestAssured.given().baseUri("http://restapi.adequateshop.com").basePath("/api/Traveler").
				queryParam("page", "1").header("accept","application/xml")
				.when().get();
		response.then().body("TravelerinformationResponse.travelers.Travelerinformation[2].name",Matchers.equalTo("vano")).log().all();
		
		
		
		}
		
		@Test(enabled=true)
		public void gettravellerdata2()
		{
			
			

		Response response=RestAssured.given().baseUri("http://restapi.adequateshop.com").basePath("/api/Traveler").
				queryParam("page", "1").header("accept","application/xml")
				.when().get();
		
		Object xpat=response.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[2].name");
		Assert.assertEquals((String)xpat, "vano");
		
		
		}
		@Test(enabled=false)
		public void gettravellerdata3()
		{
			
			

		Response response=RestAssured.given().baseUri("http://restapi.adequateshop.com").basePath("/api/Traveler").
				queryParam("page", "1").header("accept","application/xml")
				.when().get();
		List<String> listOfTravelers=response.xmlPath().getList("TravelerinformationResponse.travelers.Travelerinformation");
		int Totaltravelercount=listOfTravelers.size();
		System.out.println(Totaltravelercount);
		Assert.assertEquals(Totaltravelercount, 10);
		
		
		
		
		
		
		}
		@Test(enabled=false)
		public void gettravellerdata4()
		{
			
			

		Response response=RestAssured.given().baseUri("http://restapi.adequateshop.com").basePath("/api/Traveler").
				queryParam("page", "1").header("accept","application/xml")
				.when().get();
		List<String> listOfTravelersName=response.xmlPath().getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		//verify for name vano in travellers list
		
		boolean found=false;
		for (String TravelersName : listOfTravelersName) {
			if(TravelersName.equals("vano"))
			{
				found=true;
				break;
			}
			  
			}
		Assert.assertEquals(found, true);
		
		
		
		
		
		
		}
		
		
	}


