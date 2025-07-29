package com.api.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.request.LoginRequest;
import com.api.response.LoginResponse;
import com.api.response.UserProfileGetResponse;

import io.restassured.response.Response;

public class UserProfileManagementTest {
	
	@Test
	
	public void getUserProfile() {
		
		LoginRequest loginReq = new LoginRequest("divya bhanu","Divya@1234");
		AuthService authService = new AuthService();
		Response response = authService.loginFeature(loginReq);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		String token = loginResponse.getToken();
		UserProfileManagementService userProf = new UserProfileManagementService();
		response = userProf.userProfileGetData(token);
		System.out.println(response.asPrettyString());
		
		UserProfileGetResponse userProfileGetResponse = response.as(UserProfileGetResponse.class);
		assertEquals(userProfileGetResponse.getEmail(),"divya@gmail.com");
		assertEquals(userProfileGetResponse.getFirstName(),"Divya");
		assertEquals(userProfileGetResponse.getLastName(),"Bhanu");
		assertEquals(userProfileGetResponse.getUsername(),"divya bhanu");
		assertEquals(userProfileGetResponse.getId(),"2024");
		assertEquals(userProfileGetResponse.getMobileNumber(),"8787878787");
		
		
	}
	

}
