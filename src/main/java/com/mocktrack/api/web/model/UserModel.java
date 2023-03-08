package com.mocktrack.api.web.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserModel
{
	@NotBlank(message = "This field is madantory!")
	private String fullName;
	
	@NotBlank(message = "This field is madantory!")
	@Email(message = "Please enter the correct email!")
	private String email;
	
	@NotBlank(message = "This field is madantory!")
	private String mobile;
	
	@NotBlank(message = "This field is madantory!")
	private String password;
	
	@NotBlank(message = "This field is madantory!")
	private String confirmPassword;
	
}
