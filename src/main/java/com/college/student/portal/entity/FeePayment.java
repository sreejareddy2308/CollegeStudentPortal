package com.college.student.portal.entity;

import java.time.LocalDate;

import com.college.student.portal.dto.FeeHistoryResponseDTO;
import com.college.student.portal.enums.PaymentMode;
import com.college.student.portal.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FeePayment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Long amountPaid;
	private LocalDate paymentDate;
	
	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;
	
	@Column(nullable = false, unique = true)
	private String receiptNumber;

	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_roll")
	private Student student;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fee_structure_id")
	private FeeStructure feeStructure;

	public Long getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Long amountPaid) {
		this.amountPaid = amountPaid;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public void setStudent(Student student2) {
		// TODO Auto-generated method stub
		
	}

	public void setStudent1(Student student2) {
		// TODO Auto-generated method stub
		
	}

	public void setPaymentStatus(PaymentStatus paid) {
		// TODO Auto-generated method stub
		
	}

	public void setPaymentMode(Object paymentMode2) {
		// TODO Auto-generated method stub
		
	}

	public void setAmountPaid(int amount) {
		// TODO Auto-generated method stub
		
	}

	public void setFeeStructure(FeeStructure feeStructure2) {
		// TODO Auto-generated method stub
		
	}

	public void setStudent2(Student student2) {
		// TODO Auto-generated method stub
		
	}

	public void setStudent3(Student student2) {
		// TODO Auto-generated method stub
		
	}

	public void setReceiptNumber(String receiptNumber2) {
		// TODO Auto-generated method stub
		
	}

	public FeeHistoryResponseDTO getFeeStructure() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPaymentMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPaymentStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getReceiptNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	public Student getStudent() {
		// TODO Auto-generated method stub
		return null;
	}
}
