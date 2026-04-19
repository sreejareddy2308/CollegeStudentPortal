package com.college.student.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeesDueResponseDTO {

	private String semester;
	private Long totalFee;
    private Long amountPaid;
    private Long pendingAmount;
	public FeesDueResponseDTO(String semester2, Long totalFee2, Long totalPaid, Long pendingAmount2) {
		// TODO Auto-generated constructor stub
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public Long getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Long amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Long getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}
	public Long getPendingAmount() {
		return pendingAmount;
	}
	public void setPendingAmount(Long pendingAmount) {
		this.pendingAmount = pendingAmount;
	}
}
