package com.mocktrack.api.business.service;

import java.util.Map;
import com.mocktrack.api.web.model.LoginModel;
import com.mocktrack.api.web.model.UserModel;

public interface UserService
{
	String registerUser(UserModel userModel);
	
	String registerAdmin(UserModel userModel);
	
	Map<String, Object>  login(LoginModel loginModel);
}
