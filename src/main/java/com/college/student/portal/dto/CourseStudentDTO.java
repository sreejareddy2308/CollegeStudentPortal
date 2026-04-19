package com.college.student.portal.dto;

import java.time.LocalDate;

import com.college.student.portal.enums.EnrollmentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudentDTO {

	private String rollNumber;
    private String name;
    private String email;
    private LocalDate enrollDate;
    private EnrollmentStatus status;
	public CourseStudentDTO(String rollNumber2, String name2, String email2, LocalDate enrollDate2, Object status2) {
		// TODO Auto-generated constructor stub
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(LocalDate enrollDate) {
		this.enrollDate = enrollDate;
	}
	public EnrollmentStatus getStatus() {
		return status;
	}
	public void setStatus(EnrollmentStatus status) {
		this.status = status;
	}
}
