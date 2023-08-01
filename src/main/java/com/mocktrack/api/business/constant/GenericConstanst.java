package com.mocktrack.api.business.constant;

public class GenericConstanst
{
	public static final String BASE_URL = "/api/v1";
	public static final String USERS = BASE_URL + "/users";
	public static final String AUTH = BASE_URL + "/auth";
	
	public static final String REGISTER = "/register";
	public static final String ADMIN = "/admin";
	
	public static final String LOGIN = "/login";
	public static final String CATEGORIES = BASE_URL + "/categories";
	public static final String CATEGORY = "/{catId}";
	public static final String QUESTIONS = BASE_URL + "/questions";
	public static final String QUESTION = "/{quesId}";
	public static final String QUIZES =  BASE_URL + "/quizes";
	
	
	private GenericConstanst() {}
}
