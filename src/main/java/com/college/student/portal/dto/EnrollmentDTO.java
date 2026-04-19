package com.college.student.portal.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDTO {

	private Integer id;

	@NotNull(message = "Course id is required")
    private Integer courseId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCourseId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getSemester() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCredits() {
		// TODO Auto-generated method stub
		return null;
	}
}
