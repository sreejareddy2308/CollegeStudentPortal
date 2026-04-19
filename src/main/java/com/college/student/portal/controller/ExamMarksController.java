package com.college.student.portal.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.ExamMarksDTO;
import com.college.student.portal.service.ExamMarksService;

import jakarta.validation.Valid;

@RestController
public class ExamMarksController {

	private final ExamMarksService examMarksService;
	
	public ExamMarksController(ExamMarksService examMarksService) {
		super();
		this.examMarksService = examMarksService;
	}

	// Enter ExamMarks
	@PostMapping("/api/faculty/{studentRoll}/marks/exam/{courseId}")
	public ResponseEntity<Map<String, Object>> enterExamMarks(@Valid @RequestBody ExamMarksDTO examMarksDto,
			@PathVariable String studentRoll, @PathVariable Integer courseId){
		return examMarksService.enterExamMarks(examMarksDto, studentRoll, courseId);
	}
}
