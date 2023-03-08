package com.mocktrack.api.business.constant;

public enum StatusCode
{
	
	INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
	USER_ALREADY_EXIST(600, "User Already Exists!")
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
