package Session18;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
public class FileUploadDemo {
	
	@Test(enabled=false)
	public void UploadFile()
	{
		File filename1=new File("C:\\Users\\sanju\\Desktop\\TestFileUpload.txt");
		File filename2=new File("C:\\Users\\sanju\\Desktop\\TestFileUpload2.txt");
		Response response=RestAssured.given().header("Content-Type","multipart/form-data").baseUri("http://httpbin.org/post").multiPart("abc",filename1).
		multiPart("def",filename2).when().post();
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200);
		
		
		
	}
	
	@Test(enabled=true)
	public void Uploadimg()
	{
		File filename1=new File("C:\\Users\\sanju\\Desktop\\img.jpg");

		Response response=RestAssured.given().header("Content-Type","multipart/form-data").baseUri("https://petstore.swagger.io/v2/pet/1/uploadImage").multiPart("abc",filename1).
	when().post();
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200);
		
		
		
	}
	

}
