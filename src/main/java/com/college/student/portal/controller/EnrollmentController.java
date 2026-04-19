package com.college.student.portal.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.CourseStudentsResponseDTO;
import com.college.student.portal.dto.EnrollmentDTO;
import com.college.student.portal.service.EnrollmentService;

import jakarta.validation.Valid;

@RestController
public class EnrollmentController {

	private final EnrollmentService enrollmentService;

	public EnrollmentController(EnrollmentService enrollmentService) {
		super();
		this.enrollmentService = enrollmentService;
	}
	
	// Enroll Student to Course
	@PostMapping("/api/students/{roll}/enroll")
	public ResponseEntity<Map<String, Object>> enrollStudent(
	        @PathVariable String roll,
	        @Valid @RequestBody EnrollmentDTO enrollmentDto) {

	    return enrollmentService.enrollStudent(roll, enrollmentDto);
	}
	
	// Fetch Student Courses
	@GetMapping("/api/students/{roll}/courses")
	public Map<String, Object> getStudentCourses(@PathVariable String roll){
		return enrollmentService.getStudentCourses(roll);
	}
	
	@GetMapping("/api/courses/{code}/students")
	public CourseStudentsResponseDTO getCourseStudents(
	        @PathVariable String code) {
		return enrollmentService.getStudentsByCourseCode(code);

	}
}
