package com.college.student.portal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.StudentCourseMarksResponseDTO;
import com.college.student.portal.service.StudentCourseMarksService;

@RestController
public class StudentCourseMarksController {

	private final StudentCourseMarksService studentCourseMarksService;

	public StudentCourseMarksController(StudentCourseMarksService studentCourseMarksService) {
		super();
		this.studentCourseMarksService = studentCourseMarksService;
	}
	
	// Fetch Student Mark sheet
	@GetMapping("/api/students/{studentRoll}/marks/course/{courseCode}")
	public StudentCourseMarksResponseDTO getMarkSheetofStudentWithCourse(@PathVariable String studentRoll,
			@PathVariable String courseCode) {
		return studentCourseMarksService.getMarkSheetofStudentWithCourse(studentRoll, courseCode);
	}
	
	// Fetch Students Result by Semester (ADMIN)
	@GetMapping("/api/admin/grades/semester/{semester}")
	public List<StudentCourseMarksResponseDTO> getStudentMarksheet(@PathVariable String semester){
		return studentCourseMarksService.getStudentsMarksheet(semester);
	}
}
