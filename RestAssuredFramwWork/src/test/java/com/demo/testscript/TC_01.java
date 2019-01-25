package com.demo.testscript;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.demo.pojo.TittleTest;
import com.demo.utility.EndPoint;
import com.demo.utility.URL;
import com.demo.webservice.WebServiceTest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.restassured.response.Response;

public class TC_01 {
	Response responce;
	ArrayList<String> getTitle;
	
	@BeforeClass
	
	public void setUp()
	{
		
	getTitle = new ArrayList<String>()	;
	
	getTitle.add("json-server");
	getTitle.add("kunal");
	getTitle.add("Jigar");
	getTitle.add("mukesh");
	
	getTitle.add("Nilesh");
	getTitle.add("Dhaval");
	getTitle.add("Mitthal");
	
	}
	
	@Test(priority=1)
	
	public void gettestId()
	{
	String url = URL.fixUrl+EndPoint.GET_TITLE.getResouecePath()	;
		
	System.out.println(url);
		responce = WebServiceTest.getMethod(url);
		Gson gson = new GsonBuilder().create();
        TittleTest[] titletest;
		System.out.println(responce.getBody().asString());
		if(responce.getStatusCode()==200)
		{
			
			titletest = gson.fromJson(responce.getBody().asString(), TittleTest[].class);
			
			for(int i =1;i<=titletest.length;i++)
			{
				System.out.println(getTitle.get(i-1)+titletest[i-1].getTitle());
				Assert.assertEquals(getTitle.get(i-1), titletest[i-1].getTitle());	
				
			
			}
			
		}
	}
	
	
/*@Test(priority=2)
	
	public void postTest()
	
	{
	String url =URL.fixUrl+EndPoint.ADD_TITLE.getResouecePath();
	 
	JSONObject json = new JSONObject();
	json.put("id", "6");
	json.put("title", "Dhaval");
	json.put("author", "dhn");
	
	String jsonn = json.toJSONString();
	responce = WebServiceTest.postMethod(url, jsonn);
	System.out.println(responce.getBody().asString());
	}*/

}
