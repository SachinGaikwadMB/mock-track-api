package com.mocktrack.api.web.model;

import com.mocktrack.api.persistance.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class QuizModel
{	
	private Integer quizId;
	
	private String titie;
	
	private String description;
	
	private Boolean isActive;
	
	private Boolean isPaid;
	
	private String maxMarks;
	
	private String numberOfQuestion;
	
	private String categoryCode;
	
	private String quizCode;
	
}
