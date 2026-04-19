package com.college.student.portal.dto;

import java.time.LocalDate;

import com.college.student.portal.enums.AttendanceStatus;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDTO {

	private Integer id;
	
	@NotNull(message = "Attendance date is required")
    @PastOrPresent(message = "Attendance date cannot be in the future")
    private LocalDate date;

    @NotNull(message = "Attendance status is required")
    private AttendanceStatus status;
    
    @NotNull(message = "Student ID is required")
    private Integer studentId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		// TODO Auto-generated method stub
		return null;
	}

	public LocalDate getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}
