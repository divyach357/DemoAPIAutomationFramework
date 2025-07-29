package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	@Test(description = "Verify if Account Creation API is working...")
	
	public void createAccountTest(){
		
		SignUpRequest signUpReq = new SignUpRequest.Builder().userName("LalithK").
		passWord("Lalith1234").firstName("Lalith").
		eMail("Lalith@gmail.com").lastName("Khan").
		mobileNumber("5678567890").build();
		
		AuthService authService = new AuthService();
		Response response = authService.signUpFeature(signUpReq);
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());

		
	}

}
