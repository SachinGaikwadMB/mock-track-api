package com.mocktrack.api.persistance.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer catId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "category")
	@JsonIgnore
	private List<Quiz> quizes;
	
}
