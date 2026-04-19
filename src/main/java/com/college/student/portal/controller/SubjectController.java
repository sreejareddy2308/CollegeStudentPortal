package com.college.student.portal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.SubjectDTO;
import com.college.student.portal.dto.SubjectsResponseDTO;
import com.college.student.portal.service.SubjectService;

import jakarta.validation.Valid;

@RestController
public class SubjectController {

	private final SubjectService subjectService;

	public SubjectController(SubjectService subjectService) {
		super();
		this.subjectService = subjectService;
	}
	
	// Add Subject
	@PostMapping("/api/subjects/add")
	public ResponseEntity<Map<String, Object>> addSubject(@Valid @RequestBody SubjectDTO subjctDto){
		return subjectService.addSubject(subjctDto);
	}
	
	// Get Subjects by Department and Semester
	@GetMapping("/api/subjects")
	public List<SubjectsResponseDTO> getSubjectsByDepartmentAndSemester(@RequestParam String department, @RequestParam String semester){
		return subjectService.getSubjectsByDepartmentAndSemester(department, semester);
	}
}
