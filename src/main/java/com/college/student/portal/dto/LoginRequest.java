package com.college.student.portal.dto;

import org.jspecify.annotations.Nullable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

	@Email
	@NotBlank(message = "Email is required")
	private String email;
	
	@NotBlank(message = "Password is required")
	private String password;

	public @Nullable Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable Object getEmail12() {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable Object getEmail2() {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable Object getEmail1() {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable Object getEmail11() {
		// TODO Auto-generated method stub
		return null;
	}
}
