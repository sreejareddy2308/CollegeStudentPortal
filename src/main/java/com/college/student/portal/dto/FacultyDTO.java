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
public class FacultyDTO {

	@NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Pattern(
        regexp = "^[6-9]\\d{9}$",
        message = "Phone number must be a valid 10-digit Indian mobile number"
    )
    private String phone;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String passwordHash;

    @NotBlank(message = "Designation is required")
    private String designation;

    @NotBlank(message = "Department is required")
    private String department;

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable CharSequence getPasswordHash() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPhone() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDesignation() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDepartment() {
		// TODO Auto-generated method stub
		return null;
	}
}
