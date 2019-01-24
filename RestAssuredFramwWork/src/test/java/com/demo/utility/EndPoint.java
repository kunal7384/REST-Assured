package com.demo.utility;

public enum EndPoint {
	
	ADD_TITLE("/posts"),
	
	GET_TITLE("/posts/id");
	
	String resourcePath;
	
	
	EndPoint(String resourcePath)
	{
		
		this.resourcePath = resourcePath;
		
	}

	public String getResouecePath()
	{
		
	return this.resourcePath;	
		
	}
	

	public String getResouecePath(String data)
	{
		
	return this.resourcePath+data;	
		
	}
	
	
}
