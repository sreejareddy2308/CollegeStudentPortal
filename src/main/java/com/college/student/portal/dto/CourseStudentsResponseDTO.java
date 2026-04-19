package com.college.student.portal.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudentsResponseDTO {

	private String courseCode;
    private String courseName;
    private int totalStudents;
    private List<CourseStudentDTO> students;
	public CourseStudentsResponseDTO(String code, String name, int size, List<CourseStudentDTO> students2) {
		// TODO Auto-generated constructor stub
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getTotalStudents() {
		return totalStudents;
	}
	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}
	public List<CourseStudentDTO> getStudents() {
		return students;
	}
	public void setStudents(List<CourseStudentDTO> students) {
		this.students = students;
	}
}
