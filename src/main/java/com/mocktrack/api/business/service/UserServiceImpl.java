package com.mocktrack.api.business.service;

import java.util.HashMap;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mocktrack.api.business.constant.MessageConstant;
import com.mocktrack.api.business.constant.StatusCode;
import com.mocktrack.api.business.exception.CustomException;
import com.mocktrack.api.persistance.entity.User;
import com.mocktrack.api.persistance.repository.UserRepository;
import com.mocktrack.api.web.model.LoginModel;
import com.mocktrack.api.web.model.UserModel;
import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public String registerUser(@Valid UserModel userModel)
	{
		LOGGER.info("*******Inside registerUser Method*******");
		
		if (userRepository.existsByEmail(userModel.getEmail()))
		{
			throw new CustomException("User Already Exists !", StatusCode.USER_ALREADY_EXIST);
		}

		try
		{
			User user = modelMapper.map(userModel, User.class);
			user.setPassword(passwordEncoder.encode(userModel.getPassword()));
			user.setConfirmPassword(passwordEncoder.encode(userModel.getConfirmPassword()));
			userRepository.save(user);
		}
		catch (Exception ex)
		{
			throw new CustomException("Internal Server Error !", StatusCode.INTERNAL_SERVER_ERROR);
		}
		
		return MessageConstant.SUCCESS;
	}

	@Override
	public Map<String, Object> login(LoginModel loginModel)
	{
		Map<String, Object> data = new HashMap<>();
		
		return data;
	}

}
