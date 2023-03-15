package com.mocktrack.api.business.constant;

public enum StatusCode
{
	
	INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
	USER_ALREADY_EXIST(600, "User Already Exists!"),
	CATEGORY_ALREADY_EXIST(608, "Category Alredy Exists!"),
	CATEGORY_NOT_FOUND(604, "Category Not Found!"),
	QUESTION_ALREADY_EXIST(610, "Question Alreay Exist!"),
	QUESTION_NOT_FOUND(610, "Question Not Found!");
	;
	
	private final int code;
	private final String reasonPhrase;
	
	private StatusCode(int code, String reasonPhrase)
	{
		this.code = code;
		this.reasonPhrase = reasonPhrase;
	}

	public int getCode()
	{
		return code;
	}

	public String getReasonPhrase()
	{
		return reasonPhrase;
	}
	
	
}
