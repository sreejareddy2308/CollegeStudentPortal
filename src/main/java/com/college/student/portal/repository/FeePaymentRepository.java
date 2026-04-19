package com.college.student.portal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.student.portal.entity.FeePayment;
import com.college.student.portal.entity.FeeStructure;
import com.college.student.portal.entity.Student;

@Repository
public interface FeePaymentRepository extends JpaRepository<FeePayment, Integer>{

	// not needed now
	Optional<FeePayment> findByReceiptNumber(String receiptNumber);
	
	List<FeePayment> findByStudentAndFeeStructure(Student student, FeeStructure feeStructure);
	
	List<FeePayment> findByStudent_RollNumberAndFeeStructure_Id(String studentRoll, Integer feeStructureId);

	List<FeePayment> findByStudent_RollNumberOrderByPaymentDateDesc(String rollNumber);
	
	List<FeePayment> findByFeeStructure_Semester(String semester);
}

