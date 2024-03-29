package com.mocktrack.api.runner;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.mocktrack.api.persistance.entity.Question;
import com.mocktrack.api.persistance.repository.CategoryRepository;
import com.mocktrack.api.persistance.repository.QuestionRepository;
import com.mocktrack.api.persistance.repository.QuizRepository;


public class TestRunner implements CommandLineRunner
{

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public void run(String... args) throws Exception
	{
		
		List<Question> list  = questionRepository.checkQuestionAlreadyAddedToQuiz(1, 4);
		System.out.println(list.get(0));
		
	}

}
