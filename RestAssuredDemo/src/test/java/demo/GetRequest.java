package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
 @Test
 
 public void testGet()
 {
	 
	 RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	 
	 RequestSpecification httprequest = RestAssured.given();
	 
	 Response response=  httprequest.request(Method.GET, "/Pune");
	 
	String body= response.getBody().asString();
	
	System.out.println("Body of the Given Api is " +body);
	 
	 int statusCode = response.getStatusCode();
	 System.out.println(statusCode);
	 Assert.assertEquals(String.valueOf(statusCode), "200");
	 
 }

}
