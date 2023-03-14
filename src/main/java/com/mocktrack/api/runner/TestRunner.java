package com.mocktrack.api.runner;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.mocktrack.api.persistance.entity.Category;
import com.mocktrack.api.persistance.entity.Quiz;
import com.mocktrack.api.persistance.repository.CategoryRepository;
import com.mocktrack.api.persistance.repository.QuizRepository;


//@Component
public class TestRunner implements CommandLineRunner
{

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private QuizRepository quizRepository;
	
	@Override
	public void run(String... args) throws Exception
	{
		Quiz quiz = new Quiz(1, "Title test", "Desc test", true, false, "50", "25",categoryRepository.findById(1).get() , null);
		
		quizRepository.save(quiz);
	}

}
