package com.mocktrack.api.web.controller;

import static com.mocktrack.api.business.constant.GenericConstanst.QUESTION;
import static com.mocktrack.api.business.constant.GenericConstanst.QUESTIONS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mocktrack.api.business.service.QuestionService;
import com.mocktrack.api.web.model.QuestionModel;
import com.mocktrack.api.web.model.ResponseModel;

@RestController
@RequestMapping(QUESTIONS)
public class QuestionController extends BaseController
{
	@Autowired
	private QuestionService questionService;

	@PostMapping
	public ResponseEntity<ResponseModel> addQuestion(@RequestBody QuestionModel questionModel)
	{
		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setData(questionService.addQuestion(questionModel));
		responseModel.setMessage("Added");
		responseModel.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(responseModel, HttpStatus.OK);
	}
	
	
	//TODO :: This controller only accessible to the Admin not for user UPDATE SO
	@GetMapping
	@PreAuthorize("hasRole('ROLE_USER')")	
	public ResponseEntity<ResponseModel> getAllQuestions() {
		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setData(questionService.getAllQuestions());
		responseModel.setMessage("Questions fetched successfully!");
		responseModel.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(responseModel, HttpStatus.OK);
	}
	
	@GetMapping(QUESTION)
	public ResponseEntity<ResponseModel> getQuestion(@PathVariable("quesId") Integer quesId) {
		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setData(questionService.getQuestion(quesId));
		responseModel.setMessage("Question fetched successfully!");
		responseModel.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(responseModel, HttpStatus.OK);
	}
	
	
	@PutMapping(QUESTION)
	public ResponseEntity<ResponseModel> updateQuestion(@PathVariable("quesId") Integer quesId, @RequestBody QuestionModel questionModel) {
		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setData(questionService.updateQuestion(quesId, questionModel));
		responseModel.setMessage("Question updated successfully!");
		responseModel.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(responseModel, HttpStatus.OK);
	}
	
	
	@DeleteMapping(QUESTION)
	public ResponseEntity<ResponseModel> deleteQuestion(@PathVariable("quesId") Integer quesId) {
		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setData(questionService.deleteQuestion(quesId));
		responseModel.setMessage("Question deleted successfully!");
		responseModel.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(responseModel, HttpStatus.OK);
	}
}
