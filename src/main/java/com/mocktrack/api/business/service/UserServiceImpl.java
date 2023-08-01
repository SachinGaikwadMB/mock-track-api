package com.mocktrack.api.business.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mocktrack.api.business.constant.ERole;
import com.mocktrack.api.business.constant.MessageConstant;
import com.mocktrack.api.business.constant.StatusCode;
import com.mocktrack.api.business.exception.CustomException;
import com.mocktrack.api.jwt.JwtUtils;
import com.mocktrack.api.persistance.entity.User;
import com.mocktrack.api.persistance.repository.RoleRepository;
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
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private JwtUtils jwtUtils;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	// This API is only for the user
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
			user.setRoles(Arrays.asList(roleRepository.findByRoleName(ERole.ROLE_USER)));
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

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginModel.getEmail(), loginModel.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		org.springframework.security.core.userdetails.User securiyUser = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();

		List<String> roles = securiyUser.getAuthorities().stream().map((item) -> item.getAuthority()).collect(Collectors.toList());

		String token = jwtUtils.generateJwtToken(loginModel.getEmail());

		data.put("token", token);
		data.put("message", "Login Successful!!");
		data.put("role", roles);
		data.put("username", securiyUser.getUsername());

		return data;
	}

	@Override
	public String registerAdmin(UserModel userModel)
	{
		LOGGER.info("************ Inside the Register Admin *****************************");
		if (userRepository.existsByEmail(userModel.getEmail()))
		{
			throw new CustomException("User Already Exists !", StatusCode.USER_ALREADY_EXIST);
		}
		try
		{
			User user = modelMapper.map(userModel, User.class);
			user.setPassword(passwordEncoder.encode(userModel.getPassword()));
			user.setConfirmPassword(passwordEncoder.encode(userModel.getConfirmPassword()));
			user.setRoles(Arrays.asList(roleRepository.findByRoleName(ERole.ROLE_ADMIN)));
			userRepository.save(user);
		}
		catch (Exception ex)
		{
			throw new CustomException("Internal Server Error !", StatusCode.INTERNAL_SERVER_ERROR);
		}

		return MessageConstant.SUCCESS;
	}

}
