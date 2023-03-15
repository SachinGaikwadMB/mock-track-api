package com.mocktrack.api.web.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CategoryModel
{
	@NotBlank(message = "This field contain atleast one character")
	private String name;
	
	@NotBlank(message = "This field contain atleast one character")
	private String categoryCode;
	
	@NotBlank(message = "This field contain atleast one character")
	private String description;
}
