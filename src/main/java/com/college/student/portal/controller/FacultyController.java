package com.college.student.portal.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.ApiResponse;
import com.college.student.portal.dto.FacultyDTO;
import com.college.student.portal.dto.JwtLoginResponse;
import com.college.student.portal.dto.LoginRequest;
import com.college.student.portal.service.FacultyService;

import jakarta.validation.Valid;

@RestController
public class FacultyController {
	
	private final FacultyService facultyService;

	public FacultyController(FacultyService facultyService) {
		super();
		this.facultyService = facultyService;
	}
	
	@PostMapping("/api/auth/faculty/register")
	public ResponseEntity<Map<String, Object>> registerFaculty(@Valid @RequestBody FacultyDTO facultyDto){
		return facultyService.registerFaculty(facultyDto);
	}
	
	@PostMapping("/api/auth/faculty/login")
	public <T> ResponseEntity<ApiResponse<JwtLoginResponse>> loginStudent(@RequestBody LoginRequest loginRequest){
		return facultyService.loginFaculty(loginRequest);
	}
}
