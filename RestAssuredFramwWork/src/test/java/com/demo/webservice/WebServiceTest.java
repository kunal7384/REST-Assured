package com.demo.webservice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WebServiceTest {
	
	
	public static Response postMethod(String Uri ,String stringJSON)
	{
		
	RequestSpecification requestSpecification = RestAssured.given().body(stringJSON)	;
	
	requestSpecification.contentType(ContentType.JSON);
	
	Response response  = requestSpecification.post(Uri);
	
	return response;	
		
		
	}
	
	
	public static Response getMethod(String Uri )
	{
		
	RequestSpecification requestSpecification = RestAssured.given()	;
	
	requestSpecification.contentType(ContentType.JSON);
	
	Response response  = requestSpecification.post(Uri);
	
	return response;	
		
		
	}
	
	public static Response putMethod(String Uri,String stringJSON )
	{
		
	RequestSpecification requestSpecification = RestAssured.given().body(stringJSON)	;
	
	requestSpecification.contentType(ContentType.JSON);
	
	Response response  = requestSpecification.post(Uri);
	
	return response;	
		
		
	}
	
	
	public static Response deleteMethod(String Uri )
	{
		
	RequestSpecification requestSpecification = RestAssured.given()	;
	
	requestSpecification.contentType(ContentType.JSON);
	
	Response response  = requestSpecification.post(Uri);
	
	return response;	
		
		
	}

}
