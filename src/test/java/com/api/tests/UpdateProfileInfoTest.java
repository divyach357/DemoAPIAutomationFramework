package com.api.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.request.LoginRequest;
import com.api.request.UpdateProfileRequest;
import com.api.response.LoginResponse;
import com.api.response.UserProfileGetResponse;

import io.restassured.response.Response;

public class UpdateProfileInfoTest {
	
	@Test
	
	public void updateProfile() {
		
		LoginRequest loginRequest = new LoginRequest("Divya Bhanu","Divya@1234");
		
		AuthService authService = new AuthService();
		Response response = authService.loginFeature(loginRequest);
		System.out.println(response.asPrettyString());
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		String token = loginResponse.getToken();
		
		UserProfileManagementService userProfile = new UserProfileManagementService();
		response = userProfile.userProfileGetData(token);
		System.out.println(response.asPrettyString());
		
		UpdateProfileRequest updateProfileRequest = new UpdateProfileRequest("Divya","Chalam","divyabhanunaidu@gmail.com","87878777777");
		response = userProfile.updateProfileData(token, updateProfileRequest);
		UserProfileGetResponse userProfileResponse = response.as(UserProfileGetResponse.class);
		System.out.println(response.asPrettyString());
		assertEquals(userProfileResponse.getLastName(),"Chalam");
		assertEquals(userProfileResponse.getMobileNumber(),"8787877777");

		
		System.out.println(userProfileResponse.toString());
		
		response = userProfile.userProfileGetData(token);
		System.out.println(response.asPrettyString());
	}

}
