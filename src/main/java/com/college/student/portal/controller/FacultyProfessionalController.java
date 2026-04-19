package com.college.student.portal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.FacultyProfessionalDTO;
import com.college.student.portal.dto.FacultyProfessionalResponseDTO;
import com.college.student.portal.service.FacultyProfessionalService;

import jakarta.validation.Valid;

@RestController
public class FacultyProfessionalController {

	private final FacultyProfessionalService facultyProfessionalService;

	public FacultyProfessionalController(FacultyProfessionalService facultyProfessionalService) {
		super();
		this.facultyProfessionalService = facultyProfessionalService;
	}
	
	// Create Professional Faculty
	@PostMapping("/api/admin/create/professional/faculty")
	public ResponseEntity<Map<String, Object>> createPrpfessionalFaculty(@Valid @RequestBody FacultyProfessionalDTO facultyProfessionalDTO){
		return facultyProfessionalService.createFacultyProfessional(facultyProfessionalDTO);
	}
	
	// Get Professional Faculty by Employee Id
	@GetMapping("/api/admin/faculty/{employeeId}")
	public ResponseEntity<FacultyProfessionalResponseDTO> getFacultyProfessional(
	        @PathVariable String employeeId) {

	    return ResponseEntity.ok(
	            facultyProfessionalService.getFacultyProfessional(employeeId)
	    );
	}
	
	// Get Professional Faculty by Department
	@GetMapping("/api/faculty/{department}")
	public List<FacultyProfessionalResponseDTO> getFacultiesByDepartment(@PathVariable String department){
		return facultyProfessionalService.getFacultyByDepartment(department);
	}
}
