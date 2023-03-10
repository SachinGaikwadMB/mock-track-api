package com.mocktrack.api.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Questions")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer quesId;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "option1")
	private String option1;
	
	@Column(name = "option2")
	private String option2;
	
	@Column(name = "option3")
	private String option3;

	@Column(name = "option4")
	private String option4;
	
	@Column(name = "correct_answer")
	private String correctAnswer;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;
}
