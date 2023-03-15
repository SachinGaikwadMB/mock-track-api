package com.mocktrack.api.business.service;

import java.util.List;
import com.mocktrack.api.persistance.entity.Question;
import com.mocktrack.api.web.model.QuestionModel;

public interface QuestionService
{
	String addQuestion(QuestionModel questionModel);
	
	List<Question> getAllQuestions();
	
	Question getQuestion(Integer quesID);
	
	String updateQuestion(Integer quesId, QuestionModel questionModel);
	
	String deleteQuestion(Integer quesId);

}
