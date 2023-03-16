package com.mocktrack.api.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mocktrack.api.business.service.QuizService;
import com.mocktrack.api.persistance.entity.Quiz;
import com.mocktrack.api.persistance.repository.QuizRepository;
import com.mocktrack.api.web.model.QuizModel;

@RestController
@RequestMapping("/api/v1/test")
public class TestController
{
//	@Autowired
//	private RoleRepository roleRepository;
//	
//	@Autowired
//	private UserService userService;
//	
//	@GetMapping
//	public void  test() {
//		System.out.println(roleRepository.findByRoleName(ERole.ROLE_ADMIN));
//	}
//	
//	@PostMapping
//	public void test(@RequestBody LoginModel loginModel) {
//		System.out.println(userService.login(loginModel));
//	}
	
	
//	@Autowired
//	private CategoryRepository categoryRepository;
//	
//	@Autowired
//	private QuizRepository quizRepository;
//	
//	@Autowired
//	private QuestionRepository questionRepository;
	
	//@GetMapping
//	public List<Quiz> getAllQuizes() {
//		return  quizRepository.findAll();
//	}	
//	
	//@GetMapping
//	public List<Category> getAllCategories(){
//		return categoryRepository.findAll();
//	}
	
//	@GetMapping
//	public List<Question> test() {
//		return questionRepository.checkQuestionAlreadyAddedToQuiz(1, 4); 
//	}
//	
	
//	@Autowired
//	private QuestionService questionService;
//	
//	@PostMapping
//	public String test(@RequestBody QuestionModel questionModel) {
//		return questionService.addQuestion(questionModel);
//	}
//	
	
	@Autowired
	QuizService quizService;
	
	@Autowired
	QuizRepository quizRepository;
	
	@PostMapping
	public String test(@RequestBody QuizModel quizModel) {
		return quizService.addQuiz(quizModel);
	}
	
	@GetMapping
	public List<Quiz> getAll() {
		return quizRepository.findAll();
	
	}
}
