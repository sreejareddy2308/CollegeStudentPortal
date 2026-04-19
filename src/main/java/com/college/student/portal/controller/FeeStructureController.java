package com.college.student.portal.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.FeeStructureDTO;
import com.college.student.portal.service.FeeStructureService;

@RestController
public class FeeStructureController {

	private final FeeStructureService feeStructureService;

	public FeeStructureController(FeeStructureService feeStructureService) {
		super();
		this.feeStructureService = feeStructureService;
	}
	
	// POST Fee Structure
	@PostMapping("/api/admin/fee-structure")
	public ResponseEntity<Map<String, Object>> feeStructure(@RequestBody FeeStructureDTO feeStructureDto){
		return feeStructureService.feeStructure(feeStructureDto);
	}
}
