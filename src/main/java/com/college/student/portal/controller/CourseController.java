package com.college.student.portal.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.CourseDTO;
import com.college.student.portal.service.CourseService;

import jakarta.validation.Valid;

@RestController
public class CourseController {

	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	// Create Course
	@PostMapping("/api/admin/add/course")
	public ResponseEntity<Map<String, Object>> createCourse(@Valid @RequestBody CourseDTO courseDTO){
		return courseService.createCourse(courseDTO);
	}
}
