package com.college.student.portal.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamMarksDTO {

    private Integer id;

    @NotNull(message = "End semester marks are required")
    @Min(value = 0, message = "End semester marks cannot be negative")
    @Max(value = 100, message = "End semester marks cannot exceed 100")
    private Integer endSemMarks;

    @NotBlank(message = "Student roll number is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String studentRoll;

    @NotNull(message = "Course ID is required")
    private Integer courseId;
    
    private int totalMarks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public int getEndSemMarks() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setEndSemMarks(int endSemMarks2) {
		// TODO Auto-generated method stub
		
	}
}
