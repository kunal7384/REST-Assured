package com.demo.testscript;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
	ArrayList<Object> getId;
	ArrayList<Object> getTitle;
	ArrayList<Object> getAuthor;
	
	
	@BeforeClass
	
	public void setUp()
	{
	
		getId = new ArrayList<Object>();
	    getTitle = new ArrayList<Object>()	;
	    getAuthor = new ArrayList<Object>();
	
	
	
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
				getId.add(titletest[i-1].getId());
				
				getTitle.add(titletest[i-1].getTitle());
				
				getAuthor.add(titletest[i-1].getAuthor());
				
				System.out.println(getTitle.get(i-1)+titletest[i-1].getTitle());
				Assert.assertEquals(getTitle.get(i-1), titletest[i-1].getTitle());	
				
			
			}
			
		}
	}
	
	@Test(priority=2 , dataProvider="dataApi")
	public void verifyIdData(String idd , String titlee , String author)
	{
		String url = URL.fixUrl+EndPoint.ADD_TITLE.getResouecePath(idd)	;
		
		System.out.println(url);
			responce = WebServiceTest.getMethod(url);
			Gson gson = new GsonBuilder().create();
	        TittleTest titletest;
	        if(responce.getStatusCode()==200)
			{
				
				titletest = gson.fromJson(responce.getBody().asString(), TittleTest.class);
				
			Assert.assertEquals(titlee, titletest.getTitle());
			
			Assert.assertEquals(author, titletest.getAuthor());
			
			}
	}
	
	@DataProvider(name="dataApi")
	public Object[][] getIdVerification()
	{
		
	Object[][] result = new Object[getId.size()][3];	
	for(int i=0;i<getId.size();i++)
	{
	result[i][0]= getId.get(i);
	result[i][1]= getTitle.get(i);
	result[i][2]= getAuthor.get(i);
	
	
		
	}
	return result;	
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

	
/*	@Test(priority=2 ,dataProvider="testingp")
	public void testverfitywithId(String idd , String titlee , String autorr)
	{
   String url = URL.fixUrl+EndPoint.ADD_TITLE.getResouecePath(idd)	;
		
		   System.out.println(url);
			responce = WebServiceTest.getMethod(url);
			Gson gson = new GsonBuilder().create();
	        TittleTest titletest;
	        
	        if(responce.getStatusCode()==200)
			{
				
				titletest = gson.fromJson(responce.getBody().asString(), TittleTest.class);
				
				//Assert.assertEquals(id, titletest.getId());
				Assert.assertEquals(titlee, titletest.getTitle());
				Assert.assertEquals(autorr, titletest.getAuthor());
			}	
			
		
	}
	@DataProvider(name ="testingp")
	public Object[][] verfitywithId()
	{
		Object[][] result = new Object[getId.size()][3];
		
		for(int i=0;i<getId.size();i++)
		{
			
			result[i][0] = getId.get(i);
			result[i][1] = getTitle.get(i);
			result[i][2] = getAuthor.get(i);
			
		}
		return result;
		
		
	
	
}
}*/
