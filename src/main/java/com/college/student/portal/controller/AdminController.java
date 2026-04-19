package com.college.student.portal.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.AdminDTO;
import com.college.student.portal.dto.ApiResponse;
import com.college.student.portal.dto.LoginRequest;
import com.college.student.portal.service.AdminService;
import com.college.student.portal.service.JwtResponse;

import jakarta.validation.Valid;

@RestController
public class AdminController {

	private final AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	@PostMapping("/api/auth/admin/register")
	public ResponseEntity<Map<String, Object>> registerAdmin(@Valid @RequestBody AdminDTO adminDto){
		return adminService.registerAdmin(adminDto);
	}
	
	@PostMapping("/api/auth/admin/login")
	public ResponseEntity<ApiResponse<JwtResponse>> loginStudent(@RequestBody LoginRequest loginRequest){
		return adminService.loginAdmin(loginRequest);
	}
}
