package com.mocktrack.api.web.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginModel
{
	@NotBlank(message = "This field is required.")
	@Email(message = "Please enter correct email address.")
	private String email;
	
	@NotBlank(message = "This field is required.")
	private String password;
}
