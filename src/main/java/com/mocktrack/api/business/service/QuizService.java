package com.mocktrack.api.business.service;

import java.util.List;
import com.mocktrack.api.persistance.entity.Quiz;
import com.mocktrack.api.web.model.QuizModel;

public interface QuizService
{
	String addQuiz(QuizModel quizModel);
	
	List<Quiz> getAllQuizes();
}
