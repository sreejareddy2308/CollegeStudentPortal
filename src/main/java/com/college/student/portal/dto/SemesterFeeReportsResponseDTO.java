package com.college.student.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SemesterFeeReportsResponseDTO {

	private String semester;
    private int totalStudents;
    private double totalFeeExpected;
    private double totalFeeCollected;
    private double totalFeePending;
	public SemesterFeeReportsResponseDTO(String semester2, int totalStudents2, double totalExpected,
			double totalCollected, double totalPending) {
		// TODO Auto-generated constructor stub
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public int getTotalStudents() {
		return totalStudents;
	}
	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}
	public double getTotalFeeExpected() {
		return totalFeeExpected;
	}
	public void setTotalFeeExpected(double totalFeeExpected) {
		this.totalFeeExpected = totalFeeExpected;
	}
	public double getTotalFeeCollected() {
		return totalFeeCollected;
	}
	public void setTotalFeeCollected(double totalFeeCollected) {
		this.totalFeeCollected = totalFeeCollected;
	}
	public double getTotalFeePending() {
		return totalFeePending;
	}
	public void setTotalFeePending(double totalFeePending) {
		this.totalFeePending = totalFeePending;
	}
}
