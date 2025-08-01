package com.api.base;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseService {
	
	private static final String baseURI = "http://64.227.160.186:8080" ;
	protected RequestSpecification requestSpecification;
	
	static {
		RestAssured.filters(new LoggingFilter());
	}
	
	public BaseService() {
		
		requestSpecification = given().baseUri(baseURI);
	}
	protected Response postRequest(Object payload, String endpoint)
	{
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	protected Response putRequest(Object payload, String endpoint)
	{
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}
	
	protected Response getRequest(String endpoint)
	{
		return requestSpecification.get(endpoint);
	}
	
	protected void addToken(String token)
	{
		 requestSpecification.header("Authorization", "Bearer"+token);
	}

}
