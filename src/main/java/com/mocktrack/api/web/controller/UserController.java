package com.mocktrack.api.web.controller;

import static com.mocktrack.api.business.constant.GenericConstanst.USERS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mocktrack.api.business.service.UserService;
import com.mocktrack.api.web.model.ResponseModel;
import com.mocktrack.api.web.model.UserModel;
import jakarta.validation.Valid;


@RestController
@RequestMapping(USERS)
public class UserController extends BaseController
{
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<ResponseModel> saveUser(@RequestBody @Valid UserModel userModel) {
		
		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setMessage("Success");
		responseModel.setData(userService.registerUser(userModel));
		responseModel.setStatusCode(HttpStatus.CREATED.value());
		
		return new ResponseEntity<>(responseModel, HttpStatus.OK);
	}
}
