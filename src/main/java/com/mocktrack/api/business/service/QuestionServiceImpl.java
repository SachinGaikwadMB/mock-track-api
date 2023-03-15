package com.mocktrack.api.business.service;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mocktrack.api.business.constant.StatusCode;
import com.mocktrack.api.business.exception.CustomException;
import com.mocktrack.api.persistance.entity.Question;
import com.mocktrack.api.persistance.repository.QuestionRepository;
import com.mocktrack.api.persistance.repository.QuizRepository;
import com.mocktrack.api.web.model.QuestionModel;

@Service
public class QuestionServiceImpl implements QuestionService
{
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private QuizRepository quizRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public String addQuestion(QuestionModel questionModel)
	{
		List<Question> alreadyAddedQuestionsToQuiz = questionRepository.checkQuestionAlreadyAddedToQuiz(questionModel.getQuesId(), questionModel.getQuizId());

		if (!alreadyAddedQuestionsToQuiz.isEmpty())
		{
			throw new CustomException("This question is already added to the quiz!", StatusCode.QUESTION_ALREADY_EXIST);
		}

		Question question = mapper.map(questionModel, Question.class);

		try
		{
			questionRepository.save(question);
		}
		catch (Exception e)
		{
			throw new CustomException(e.getMessage(), StatusCode.INTERNAL_SERVER_ERROR);
		}

		return "Question Added to Quiz";
	}

	@Override
	public List<Question> getAllQuestions()
	{
		List<Question> questions = null;

		try
		{
			questions = questionRepository.findAll();
		}
		catch (Exception e)
		{
			throw new CustomException(e.getMessage(), StatusCode.INTERNAL_SERVER_ERROR);
		}

		return questions;
	}

	@Override
	public Question getQuestion(Integer quesID)
	{
		Optional<Question> questionOpt = questionRepository.findByQuesId(quesID);

		if (questionOpt.isEmpty())
		{
			throw new CustomException("Question not found!", StatusCode.QUESTION_NOT_FOUND);
		}

		return questionOpt.get();
	}

	@Override
	public String updateQuestion(Integer quesId, QuestionModel questionModel)
	{
		Question question = getQuestion(quesId);

		question.setContent(questionModel.getContent());
		question.setOption1(questionModel.getOption1());
		question.setOption2(questionModel.getOption2());
		question.setOption3(questionModel.getOption3());
		question.setOption4(questionModel.getOption4());
		question.setCorrectAnswer(questionModel.getCorrectAnswer());
		question.setImageUrl(questionModel.getImageUrl());
		question.setQuesId(questionModel.getQuesId());
		question.setQuiz(quizRepository.findById(questionModel.getQuizId()).get());

		try
		{
			questionRepository.save(question);
		}
		catch (Exception e)
		{
			throw new CustomException(e.getMessage(), StatusCode.INTERNAL_SERVER_ERROR);
		}
		return "Question updated successfully!";
	}

	@Override
	public String deleteQuestion(Integer quesId)
	{

		if (!questionRepository.existsByQuesId(quesId))
		{
			throw new CustomException("Question Not found with ID :: " + quesId, StatusCode.QUESTION_NOT_FOUND);
		}

		try
		{
			questionRepository.deleteById(quesId);
		}
		catch (Exception e)
		{
			throw new CustomException(e.getMessage(), StatusCode.INTERNAL_SERVER_ERROR);
		}

		return "Question of ID :: " + quesId + " is deleted successfully!";
	}

}
