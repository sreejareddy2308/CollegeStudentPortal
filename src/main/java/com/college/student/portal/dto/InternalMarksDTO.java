package com.college.student.portal.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternalMarksDTO {

    private Integer id;

    @Min(value = 0, message = "Quiz 1 marks cannot be negative")
    @Max(value = 10, message = "Quiz 1 marks cannot exceed 10")
    private Integer quiz1;

    @Min(value = 0, message = "Quiz 2 marks cannot be negative")
    @Max(value = 10, message = "Quiz 2 marks cannot exceed 10")
    private Integer quiz2;

    @Min(value = 0, message = "Assignment 1 marks cannot be negative")
    @Max(value = 15, message = "Assignment 1 marks cannot exceed 15")
    private Integer assignment1;

    @Min(value = 0, message = "Assignment 2 marks cannot be negative")
    @Max(value = 15, message = "Assignment 2 marks cannot exceed 15")
    private Integer assignment2;

    @Min(value = 0, message = "Mid-sem marks cannot be negative")
    @Max(value = 50, message = "Mid-sem marks cannot exceed 50")
    private Integer midSem;

    @NotBlank(message = "Student roll number is required")
    private String studentRoll;

    @NotNull(message = "Course ID is required")
    private Integer courseId;
    
    private int totalInternal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTotalInternal() {
		return totalInternal;
	}

	public void setTotalInternal(int totalInternal) {
		this.totalInternal = totalInternal;
	}

	public void setQuiz1(int quiz12) {
		// TODO Auto-generated method stub
		
	}

	public void setQuiz2(int quiz22) {
		// TODO Auto-generated method stub
		
	}

	public void setAssignment1(int assignment12) {
		// TODO Auto-generated method stub
		
	}

	public void setAssignment2(int assignment22) {
		// TODO Auto-generated method stub
		
	}

	public void setMidSem(int midSem2) {
		// TODO Auto-generated method stub
		
	}

	public int getQuiz1() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getQuiz2() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getAssignment1() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getAssignment2() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getMidSem() {
		// TODO Auto-generated method stub
		return 0;
	}
}
