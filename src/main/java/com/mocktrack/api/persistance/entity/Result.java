package com.mocktrack.api.persistance.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "results")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer resId;
	
	@Column(name = "question_attempted")
	private Integer questionAttempted;
	
	@Column(name = "correct_answer")
	private Integer correctAnswer;
	
	@Column(name = "scored")
	private Double scored;
	
	@Column(name = "submission_time")
	private Date submissionTime;
	
	
		
}
