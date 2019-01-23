package demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	
	public void testPost()
	{
		
	RestAssured.baseURI ="http://restapi.demoqa.com/customer";
	
	RequestSpecification requestparam =  RestAssured.given();
	
	JSONObject json = new JSONObject();
	
	json.put("FirstName", "Mukeshh");
	json.put("LastName", "narolaa");
	json.put("UserName", "Mukesh1");
	json.put("Password", "hyt567899");
	json.put("Email", "mukesh@gmail.com");
	
	requestparam.header("Content-Type","application/json");
	requestparam.body(json.toJSONString());
	
	       Response res= requestparam.post("/register");
	       
	        String resBody= res.body().asString();
	        
	        System.out.println("Responce of the Body is " +resBody);
		
		
	}

}
