package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.request.LoginRequest;
import com.api.response.LoginResponse;

import io.restassured.response.Response;
@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest {
	
	@Test(description = "verify if login API is working...")
	public void LoginAPITest1(){
		
		LoginRequest loginRequest = new LoginRequest("Divya Bhanu","Divya@1234");
		AuthService authService = new AuthService();
		Response response = authService.loginFeature(loginRequest);
		System.out.println(response.asPrettyString());
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		
	}
	

}
