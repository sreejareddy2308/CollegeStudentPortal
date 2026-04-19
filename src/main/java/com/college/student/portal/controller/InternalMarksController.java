package com.college.student.portal.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.InternalMarksDTO;
import com.college.student.portal.service.InternalMarksService;

import jakarta.validation.Valid;

@RestController
public class InternalMarksController {

	private final InternalMarksService internalMarksService;

	public InternalMarksController(InternalMarksService internalMarksService) {
		super();
		this.internalMarksService = internalMarksService;
	}
	
	// Enter Internal Marks
	@PostMapping("/api/faculty/{studentRollNo}/marks/internal/{courseId}")
	public ResponseEntity<Map<String, Object>> enterInternalMarks(@Valid @RequestBody InternalMarksDTO internalMarksDto,
			@PathVariable String studentRollNo,
			@PathVariable Integer courseId){
		return internalMarksService.enterInternalMarks(internalMarksDto, studentRollNo, courseId);
	}
	
}
