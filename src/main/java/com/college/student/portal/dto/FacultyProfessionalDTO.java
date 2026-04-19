package com.college.student.portal.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultyProfessionalDTO {

    // Use this only for response, not required for create
    private Integer id;

    @NotBlank(message = "Employee ID is required")
    private String employeeId;

    @NotBlank(message = "Designation is required")
    private String designation;

    @NotBlank(message = "Department is required")
    private String department;

    @NotNull(message = "Joining date is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate joiningDate;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be positive")
    private BigDecimal salary;

    @NotNull(message = "Faculty personal id is required")
    private Integer facultyPersonalId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeId() {
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

	public LocalDate getJoiningDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public BigDecimal getSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getFacultyPersonalId() {
		// TODO Auto-generated method stub
		return null;
	}
}
