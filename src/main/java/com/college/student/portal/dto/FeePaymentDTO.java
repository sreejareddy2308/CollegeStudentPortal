package com.college.student.portal.dto;

import com.college.student.portal.enums.PaymentMode;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeePaymentDTO {

	@NotNull(message = "Semester Fee ID is required")
    private Integer feeStructureId;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    private Long amount;

    @NotNull(message = "Payment mode is required")
    private PaymentMode paymentMode;

	public int getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getPaymentMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getFeeStructureId() {
		// TODO Auto-generated method stub
		return null;
	}
}
