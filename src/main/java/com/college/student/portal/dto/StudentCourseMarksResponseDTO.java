package com.college.student.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseMarksResponseDTO {

	private String rollNumber;
	private String studentName;
	
	private CourseDTO course;
	private InternalMarksDTO internalMarksDto;
	private ExamMarksDTO examMarksDTO;
	
	private String grade;

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public CourseDTO getCourse() {
		return course;
	}

	public void setCourse(CourseDTO course) {
		this.course = course;
	}

	public InternalMarksDTO getInternalMarksDto() {
		return internalMarksDto;
	}

	public void setInternalMarksDto(InternalMarksDTO internalMarksDto) {
		this.internalMarksDto = internalMarksDto;
	}

	public ExamMarksDTO getExamMarksDTO() {
		return examMarksDTO;
	}

	public void setExamMarksDTO(ExamMarksDTO examMarksDTO) {
		this.examMarksDTO = examMarksDTO;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
