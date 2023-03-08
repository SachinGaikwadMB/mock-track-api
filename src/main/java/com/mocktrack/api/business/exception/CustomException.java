package com.mocktrack.api.business.exception;

import com.mocktrack.api.business.constant.StatusCode;

public class CustomException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	private  final StatusCode code;
	
	
	public CustomException(String meassage, StatusCode code)
	{
		super(meassage);
		this.code = code;
		
	}

	public StatusCode getCode()
	{
		return code;
	}
	
	
	
	
	
}
