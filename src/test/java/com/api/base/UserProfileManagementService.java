package com.api.base;

import com.api.request.UpdateProfileRequest;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService{
	
	private static final String BASE_PATH = "/api/users/";
	
	public Response userProfileGetData(String token) {
		addToken(token);
		return getRequest(BASE_PATH+"profile");
	}
	public Response updateProfileData(String token, UpdateProfileRequest payload) {
		addToken(token);
		return putRequest(payload, BASE_PATH+"profile");
	}
	
}
