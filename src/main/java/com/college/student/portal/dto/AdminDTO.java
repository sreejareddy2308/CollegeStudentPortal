package com.college.student.portal.dto;

import org.jspecify.annotations.Nullable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {

	@NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	private String name;
	
	@NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
	private String email;
	
	@NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
	private String passwordHash;
	
	@Pattern(
	        regexp = "^[6-9]\\d{9}$",
	        message = "Phone number must be a valid 10-digit Indian mobile number"
	    )
	private String phone;

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPhone() {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable CharSequence getPasswordHash() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName1() {
		// TODO Auto-generated method stub
		return null;
	}
}
