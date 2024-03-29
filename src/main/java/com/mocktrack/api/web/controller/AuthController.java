package com.mocktrack.api.web.controller;

import static com.mocktrack.api.business.constant.GenericConstanst.AUTH;
import static com.mocktrack.api.business.constant.GenericConstanst.REGISTER;
import static com.mocktrack.api.business.constant.GenericConstanst.ADMIN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mocktrack.api.business.service.UserService;
import com.mocktrack.api.web.model.LoginModel;
import com.mocktrack.api.web.model.ResponseModel;
import com.mocktrack.api.web.model.UserModel;
import jakarta.validation.Valid;
import static com.mocktrack.api.business.constant.GenericConstanst.LOGIN;


@RestController
@RequestMapping(AUTH)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController extends BaseController
{
	@Autowired
	private UserService userService;

	@PostMapping(REGISTER)
	public ResponseEntity<ResponseModel> saveUser(@RequestBody @Valid UserModel userModel)
	{
		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setMessage("Success");
		responseModel.setData(userService.registerUser(userModel));
		responseModel.setStatusCode(HttpStatus.CREATED.value());

		return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
	}
	
	@PostMapping(ADMIN)
	public ResponseEntity<ResponseModel> saveAdmin(@RequestBody @Valid UserModel userModel)
	{

		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setMessage("Success");
		responseModel.setData(userService.registerAdmin(userModel));
		responseModel.setStatusCode(HttpStatus.CREATED.value());

		return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
	}

	@PostMapping(LOGIN)
	public ResponseEntity<ResponseModel> login(@RequestBody LoginModel loginModel)
	{
		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setMessage("Success");
		responseModel.setData(userService.login(loginModel));
		responseModel.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(responseModel, HttpStatus.OK);
	}
}
