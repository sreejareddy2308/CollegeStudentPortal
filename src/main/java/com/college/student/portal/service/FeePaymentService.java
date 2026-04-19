package com.college.student.portal.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.FeeHistoryResponseDTO;
import com.college.student.portal.dto.FeePaymentDTO;
import com.college.student.portal.dto.FeesDueResponseDTO;
import com.college.student.portal.dto.SemesterFeeReportsResponseDTO;
import com.college.student.portal.entity.FeePayment;
import com.college.student.portal.entity.FeeStructure;
import com.college.student.portal.entity.Student;
import com.college.student.portal.enums.PaymentStatus;
import com.college.student.portal.repository.FeePaymentRepository;
import com.college.student.portal.repository.FeeStructureRepository;
import com.college.student.portal.repository.StudentRepository;

@Service
public class FeePaymentService {

	private final StudentRepository studentRepository;
	private final FeeStructureRepository feeStructureRepository;
	private final FeePaymentRepository feePaymentRepository;
	
	public FeePaymentService(StudentRepository studentRepository, FeeStructureRepository feeStructureRepository,
			FeePaymentRepository feePaymentRepository) {
		super();
		this.studentRepository = studentRepository;
		this.feeStructureRepository = feeStructureRepository;
		this.feePaymentRepository = feePaymentRepository;
	}

	// Pay Fees
	public ResponseEntity<Map<String, Object>> payFees(
	        String roll,
	        FeePaymentDTO requestDTO) {

	    Student student = studentRepository.findByRollNumber(roll)
	            .orElseThrow(() -> new RuntimeException("Student not found!"));

	    FeeStructure feeStructure = feeStructureRepository.findById(requestDTO.getFeeStructureId())
	            .orElseThrow(() -> new RuntimeException("Fee Structure not found!"));

	    List<FeePayment> payments = feePaymentRepository.findByStudentAndFeeStructure(student, feeStructure);
	    Long totalPaid = payments.stream().mapToLong(FeePayment::getAmountPaid).sum();
	    Long totalFee = feeStructure.getTotalFee();
	    Long remainingAmount = totalFee - totalPaid;

	    if (requestDTO.getAmount() <= 0) {
	        throw new RuntimeException("Payment amount must be greater than zero");
	    }

	    if (requestDTO.getAmount() > remainingAmount) {
	        throw new RuntimeException("Payment exceeds remaining fee amount");
	    }

	    String receiptNumber = "RCPT-" + UUID.randomUUID();

	    FeePayment feePayment = new FeePayment();
	    feePayment.setStudent(student);
	    feePayment.setFeeStructure(feeStructure);
	    feePayment.setAmountPaid(requestDTO.getAmount());
	    feePayment.setPaymentMode(requestDTO.getPaymentMode());
	    feePayment.setPaymentDate(LocalDate.now());
	    feePayment.setPaymentStatus(PaymentStatus.PAID);
	    feePayment.setReceiptNumber(receiptNumber);

	    feePaymentRepository.save(feePayment);

	    Map<String, Object> response = new HashMap<>();
	    response.put("message", "Fee payment successful");
	    response.put("receiptNumber", receiptNumber);
	    response.put("paidAmount", requestDTO.getAmount());
	    response.put("remainingAmount", remainingAmount - requestDTO.getAmount());

	    return ResponseEntity.ok(response);
	}
	
	// GET fees-due for student
	public List<FeesDueResponseDTO> getFeeDueForStudent(String studentRoll) {

	    List<FeeStructure> feeStructures = feeStructureRepository.findAll();

	    List<FeesDueResponseDTO> feesDueList = feeStructures.stream().map(fs -> {

	        List<FeePayment> payments = feePaymentRepository.findByStudent_RollNumberAndFeeStructure_Id(studentRoll, fs.getId());

	        Long totalPaid = payments.stream()
	                .mapToLong(FeePayment::getAmountPaid)
	                .sum();
	        Long pendingAmount = fs.getTotalFee() - totalPaid;

	        return new FeesDueResponseDTO(
	                fs.getSemester(),
	                fs.getTotalFee(),
	                totalPaid,
	                pendingAmount
	        );
	    }).collect(Collectors.toList());

	    return feesDueList;
	}
	
	// Fee Payment History
	public List<FeeHistoryResponseDTO> getFeeHistoryForStudent(String studentRoll) {

        List<FeePayment> payments = feePaymentRepository
                .findByStudent_RollNumberOrderByPaymentDateDesc(studentRoll);

        return payments.stream().map(fp -> new FeeHistoryResponseDTO(
                fp.getFeeStructure().getSemester() + "", 
                fp.getFeeStructure().getTotalFee(),
                fp.getAmountPaid(),
                fp.getPaymentMode(),
                fp.getPaymentStatus(),
                fp.getReceiptNumber(),
                fp.getPaymentDate()
        )).collect(Collectors.toList());
    }
	
	// Fee Reports for Admin
	
	public SemesterFeeReportsResponseDTO getFeeReports(String semester) {
		
		List<FeeStructure> feeStructures = feeStructureRepository.findBySemester(semester);
		
		double totalExpected = feeStructures
				.stream()
				.mapToDouble(FeeStructure::getTotalFee)
	            .sum();
		
		List<FeePayment> payments = feePaymentRepository.findByFeeStructure_Semester(semester);
		
		double totalCollected = payments.stream()
	            .filter(p -> p.getPaymentStatus() == PaymentStatus.PAID)
	            .mapToDouble(FeePayment::getAmountPaid)
	            .sum();

	    int totalStudents = (int) payments.stream()
	            .map(p -> p.getStudent().getRollNumber())
	            .distinct()
	            .count();

	    double totalPending = totalExpected - totalCollected;

	    return new SemesterFeeReportsResponseDTO(
	            semester,
	            totalStudents,
	            totalExpected,
	            totalCollected,
	            totalPending
	    );
	}
	
}
