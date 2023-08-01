package com.mocktrack.api.business.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mocktrack.api.business.constant.StatusCode;
import com.mocktrack.api.business.exception.CustomException;
import com.mocktrack.api.persistance.entity.Question;
import com.mocktrack.api.persistance.entity.Quiz;
import com.mocktrack.api.persistance.repository.CategoryRepository;
import com.mocktrack.api.persistance.repository.QuestionRepository;
import com.mocktrack.api.persistance.repository.QuizRepository;
import com.mocktrack.api.web.model.QuizModel;

@Service
public class QuizServiceImpl implements QuizService
{
	@Autowired
	private QuizRepository quizRepository;


	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public String addQuiz(QuizModel quizModel)
	{
		if (quizRepository.existsByQuizCode(quizModel.getQuizCode()))
		{
			throw new CustomException("Quiz Alreay Exist! You can update only.", StatusCode.QUIZ_ALREADY_EXIST);
		}
		Quiz quiz = new Quiz();

		quiz.setTitle(quizModel.getTitie());
		quiz.setDescription(quizModel.getDescription());
		quiz.setMaxMarks(quizModel.getMaxMarks());
		quiz.setNumberOfQuestion(quizModel.getNumberOfQuestion());
		quiz.setIsActive(quizModel.getIsActive());
		quiz.setIsPaid(quizModel.getIsPaid());
		quiz.setCategory(categoryRepository.findByCategoryCode(quizModel.getCategoryCode()));
		quiz.setQuizCode(quizModel.getQuizCode());
		List<Question> questions = questionRepository.getAllQuestionByQuizId(5);
		quiz.setQuestions(questions);

		quizRepository.save(quiz);
		return "success";
	}

	@Override
	public List<Quiz> getAllQuizes()
	{
		List<Quiz> quizList = null;

		try
		{
			quizList = quizRepository.findAll();
		}
		catch (Exception e)
		{
			throw new CustomException("Internal Server Error !", StatusCode.INTERNAL_SERVER_ERROR);
		}

		return quizList;
	}

}
