package com.college.student.portal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {

    public Integer id;
    
    @NotBlank(message = "Subject code is required")
    @Size(min = 3, max = 10, message = "Subject code must be between 3 and 10 characters")
    private String code;

    @NotBlank(message = "Subject name is required")
    @Size(min = 3, max = 100, message = "Subject name must be between 3 and 100 characters")
    private String name;

    @NotNull(message = "Credits are required")
    @Positive(message = "Credits must be a positive number")
    private Integer credits;

    @NotBlank(message = "Semester is required")
    private String semester;

    @NotBlank(message = "Department is required")
    private String department;

	public String getCode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCredits() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getSemester() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCode2() {
		// TODO Auto-generated method stub
		return null;
	}
}
