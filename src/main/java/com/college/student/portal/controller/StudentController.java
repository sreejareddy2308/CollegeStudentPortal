package com.college.student.portal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.ApiResponse;
import com.college.student.portal.dto.JwtLoginResponse;
import com.college.student.portal.dto.LoginRequest;
import com.college.student.portal.dto.StudentDTO;
import com.college.student.portal.dto.StudentResponseDTO;
import com.college.student.portal.dto.StudentUpdateDTO;
import com.college.student.portal.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {

	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// Register Student
	@PostMapping("/api/auth/student/register")
	public ResponseEntity<Map<String, Object>> registerStudent(@Valid @RequestBody StudentDTO studentDto){
		return studentService.registerStudent(studentDto);
	}
	
	// Login Student
	@PostMapping("/api/auth/student/login")
	public ResponseEntity<ApiResponse<JwtLoginResponse>> loginStudent(@RequestBody LoginRequest loginRequest){
		return studentService.loginStudent(loginRequest);
	}
	
	// Show all Students
	@GetMapping("/api/show/students")
	public List<StudentResponseDTO> showStudents(){
		return studentService.showStudents();
	}
	
	// Show Individual Student
	@GetMapping("/api/show/student/{id}")
	public StudentResponseDTO showStudent(@PathVariable int id){
		return studentService.showStudent(id);
	}
	
	// Update Student
	@PatchMapping("/api/update/student/{id}")
	public ResponseEntity<Map<String, Object>> updateStudent(@Valid @RequestBody StudentUpdateDTO studentUpdateDto, @PathVariable int id){
		return studentService.updateStudent(studentUpdateDto, id);
	}
	
	@GetMapping("/api/admin/students")
	public List<StudentResponseDTO> showStudentsByBranchAndSemester(@RequestParam String branch,
			@RequestParam String semester
			){
		return studentService.getStudentByBranchAndSemester(branch, semester);
	}
	
	
}
