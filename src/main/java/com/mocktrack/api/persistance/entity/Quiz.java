package com.mocktrack.api.persistance.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quizes")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer quizId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "quiz_code", unique = true)
	private String quizCode;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "is_paid")
	private Boolean isPaid;
	
	@Column(name = "max_marks")
	private String maxMarks;
	
	@Column(name = "number_0f_question")
	private String numberOfQuestion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(mappedBy = "quiz")
//	@JsonIgnore
	private List<Question> questions;	

}
