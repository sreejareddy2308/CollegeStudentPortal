package com.college.student.portal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.AttendanceDTO;
import com.college.student.portal.dto.StudentMonthlyAttendanceDTO;
import com.college.student.portal.service.AttendanceService;

import jakarta.validation.Valid;

@RestController
public class AttendanceController {

	private final AttendanceService attendanceService;

	public AttendanceController(AttendanceService attendanceService) {
		super();
		this.attendanceService = attendanceService;
	}
	
	// Mark Attendance
	@PostMapping("/api/faculty/{facultyId}/attendance/{courseId}")
	public ResponseEntity<Map<String, Object>> markAttendance(@Valid @RequestBody AttendanceDTO attendanceDto,
			@PathVariable Integer facultyId,
			@PathVariable Integer courseId){
		return attendanceService.markAttendance(attendanceDto, facultyId, courseId);
	}
	
	// View Attendance
	@GetMapping("/api/courses/{code}/attendance")
	public List<StudentMonthlyAttendanceDTO> viewAttendance(
	        @PathVariable String code,
	        @RequestParam String date) {
	    return attendanceService.getMonthlyAttendance(code, date);
	}


}
