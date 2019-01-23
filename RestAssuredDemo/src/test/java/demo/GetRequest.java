package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
 @Test
 
 public void testGet()
 {
	 
	 RestAssured.baseURI="https://restcountries.eu/rest/v2/alpha";
	 
	 RequestSpecification httprequest = RestAssured.given();
	 
	 Response response=  httprequest.request(Method.GET, "/col");
	 
	String body= response.getBody().asString();
	
	System.out.println("Body of the Given Api is " +body);
	 
	 
	 
 }

}
