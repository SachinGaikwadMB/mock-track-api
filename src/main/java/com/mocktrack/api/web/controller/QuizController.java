package com.mocktrack.api.web.controller;

import static com.mocktrack.api.business.constant.GenericConstanst.QUIZES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mocktrack.api.business.service.QuizService;
import com.mocktrack.api.web.model.ResponseModel;

@RestController
@RequestMapping(QUIZES)
@PreAuthorize("hasRole('ROLE_USER')")
public class QuizController extends BaseController
{
	@Autowired
	private QuizService quizService;
	
	@GetMapping
	public ResponseEntity<ResponseModel> getAllQuizes()
	{
		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setMessage("Success");
		responseModel.setStatusCode(HttpStatus.OK.value());
		responseModel.setData(quizService.getAllQuizes());
		return new ResponseEntity<>(responseModel, HttpStatus.OK);
	}
}
