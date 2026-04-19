package com.college.student.portal.dto;

import java.time.LocalDateTime;

import org.jspecify.annotations.Nullable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

	private Integer studentId;
	
    @NotBlank(message = "Roll number is required")
    @Size(min = 3, max = 20, message = "Roll number must be between 3 and 20 characters")
    private String rollNumber;

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

    @Min(value = 2000, message = "Enrollment year must be valid")
    @Max(value = 2100, message = "Enrollment year must be valid")
    private int enrollYear;

    @NotBlank(message = "Semester is required")
    private String semester;

    @NotBlank(message = "Branch is required")
    private String branch;

    @Size(max = 500, message = "Address cannot exceed 500 characters")
    private String address;

    private LocalDateTime createdAt;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getRollNumber() {
		// TODO Auto-generated method stub
		return null;
	}

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

	public int getEnrollYear() {
		// TODO Auto-generated method stub
		return 0;
	}

	public @Nullable CharSequence getPasswordHash() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSemester() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBranch() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}
}
