package com.mocktrack.api.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mocktrack.api.persistance.entity.Category;
import com.mocktrack.api.persistance.entity.Quiz;
import com.mocktrack.api.persistance.repository.CategoryRepository;
import com.mocktrack.api.persistance.repository.QuizRepository;

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
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private QuizRepository quizRepository;
	
	@GetMapping
	public List<Quiz> getAllQuizes() {
		return  quizRepository.findAll();
	}	
	
	//@GetMapping
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	
}
