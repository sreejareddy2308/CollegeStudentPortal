package com.college.student.portal.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.FeeStructureDTO;
import com.college.student.portal.entity.FeeStructure;
import com.college.student.portal.repository.FeeStructureRepository;

@Service
public class FeeStructureService {

	private final FeeStructureRepository feeStructureRepository;

	public FeeStructureService(FeeStructureRepository feeStructureRepository) {
		super();
		this.feeStructureRepository = feeStructureRepository;
	}
	
	// POST Fee Structure
	public ResponseEntity<Map<String, Object>> feeStructure(FeeStructureDTO feeStructureDto){
		
		Optional<FeeStructure> existingFeeStructure = feeStructureRepository.findByAcademicYearAndSemester(feeStructureDto.getAcademicYear(), feeStructureDto.getSemester());
		
		if(existingFeeStructure.isPresent()){
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(Map.of("message","Fee Structure Already Available!"));
		}else {
			FeeStructure feeStructure = new FeeStructure();
			feeStructure.setAcademicYear(feeStructureDto.getAcademicYear());
			feeStructure.setSemester(feeStructureDto.getSemester());
			feeStructure.setTuitionFee(feeStructureDto.getTuitionFee());
			feeStructure.setHostelFee(feeStructureDto.getHostelFee());
			
			Long total = feeStructureDto.getTuitionFee() + feeStructureDto.getHostelFee();
			
			feeStructure.setTotalFee(total);
			
			feeStructureRepository.save(feeStructure);
			
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(Map.of("message","Fee Structure Created!"));
		}
	}
}
