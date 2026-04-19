package com.college.student.portal.dto;

import java.time.LocalDate;

import com.college.student.portal.enums.PaymentMode;
import com.college.student.portal.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeHistoryResponseDTO {

	private String semester;
    private Long totalFee;         
    private Long amountPaid;       
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private String receiptNumber;
    private LocalDate paymentDate;
	public FeeHistoryResponseDTO(String string, Long totalFee2, Long amountPaid2, Object paymentMode2,
			Object paymentStatus2, Object receiptNumber2, LocalDate paymentDate2) {
		// TODO Auto-generated constructor stub
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public Long getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}
	public Long getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Long amountPaid) {
		this.amountPaid = amountPaid;
	}
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
}
