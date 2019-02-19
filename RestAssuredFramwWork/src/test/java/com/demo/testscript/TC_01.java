package com.demo.testscript;

import java.util.ArrayList;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.pojo.AddTitle;
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
	String url = URL.fixUrl+EndPoint.ADD_TITLE.getResouecePath()	;
		
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
			System.out.println("Done");
			}
	}
	
//	@Test(priority=3 , dataProvider="addingdata")
	public void postDataMethod(String json , String ttitle , String aauthor)
	{
		String url = URL.fixUrl+EndPoint.ADD_TITLE.getResouecePath();
		
		System.out.println(url);
		responce = WebServiceTest.postMethod(url, json);
		Gson gson = new GsonBuilder().create();
		AddTitle addtitle;
		
		System.out.println(responce.getStatusCode());
		System.out.println(responce.getBody().asString());
		if(responce.getStatusCode()==201)
		{
			
			addtitle = gson.fromJson(responce.getBody().asString(), AddTitle.class);
			
			Assert.assertEquals(ttitle, addtitle.getTitle());
			Assert.assertEquals(aauthor, addtitle.getAuthor());
			
		}
		
	
	}
	
	@Test(priority=4 , dataProvider="updatingdata")
	public void putDataMethod(String json)
	{
		String url = URL.fixUrl+EndPoint.GET_TITLE.getResouecePath("9");
		
		responce = WebServiceTest.putMethod(url, json);
		
		System.out.println("Put Method"+responce.getStatusCode());
		
		if(responce.getStatusCode()==200)
		{
		System.out.println("Sucessfully Updated");	
		
		Assert.assertTrue(true);
			
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
	
	
	
	@DataProvider(name ="addingdata")
	
	public Object[][] postData()
	{
		Object[][] postdata = new Object[2][3];
		
		postdata[0][0] = " { \"id\": 9, \"title\": \"Pravin\", \"author\": \"pp\" }";
		postdata[0][1] = "Pravin";
		postdata[0][2] = "pp";
		
		postdata[1][0] = " { \"id\": 10, \"title\": \"Mayank\", \"author\": \"mpp\" }";
		postdata[1][1] = "Mayank";
		postdata[1][2] = "mpp";
		
		return postdata;
		
	}
	
	@DataProvider(name ="updatingdata")
	
	public Object[][] updateData()
	{
		Object[][] updatedata = new Object[1][1];
		
	
		updatedata[0][0] = " { \"id\": 9, \"title\": \"Pravin\", \"author\": \"pch\" }";
		return updatedata;
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

	
