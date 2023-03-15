package com.mocktrack.api.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class QuestionModel
{
	private Integer quesId;
	
	private String content;
	
	private String imageUrl;
	
	private String option1;
	
	private String option2;
	
	private String option3;
	
	private String option4;
	
	private String correctAnswer;
	
	private Integer quizId;
}
