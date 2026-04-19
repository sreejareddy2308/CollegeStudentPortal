package com.college.student.portal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.FeeHistoryResponseDTO;
import com.college.student.portal.dto.FeePaymentDTO;
import com.college.student.portal.dto.FeesDueResponseDTO;
import com.college.student.portal.dto.SemesterFeeReportsResponseDTO;
import com.college.student.portal.service.FeePaymentService;

import jakarta.validation.Valid;

@RestController
public class FeePaymentController {

	private final FeePaymentService feePaymentService;

	public FeePaymentController(FeePaymentService feePaymentService) {
		super();
		this.feePaymentService = feePaymentService;
	}
	
	// Pay Fees
	@PostMapping("/api/students/{roll}/pay-fees")
	public ResponseEntity<Map<String, Object>> payFees(
	        @PathVariable String roll,
	        @Valid @RequestBody FeePaymentDTO requestDTO) {
	    return feePaymentService.payFees(roll, requestDTO);
	}
	
	// Fees Due
	@GetMapping("/api/students/{studentRoll}/fees-due")
	public List<FeesDueResponseDTO> getFeeDue(@PathVariable String studentRoll){
		return feePaymentService.getFeeDueForStudent(studentRoll);
	}
	
	// Fee Payment History
	@GetMapping("/api/students/{studentRoll}/fee-history")
	public List<FeeHistoryResponseDTO> getFeeHistory(@PathVariable String studentRoll){
		return feePaymentService.getFeeHistoryForStudent(studentRoll);
	}
	
	// Fee Reports for Admin
	@GetMapping("/api/admin/fee-reports/semester/{semester}")
	public SemesterFeeReportsResponseDTO getFeeReports(@PathVariable String semester) {
		return feePaymentService.getFeeReports(semester);
	}
}
