package com.college.student.portal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FeeStructure {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String academicYear;
	private String semester;
	private Long tuitionFee;
	private Long hostelFee;
	private Long totalFee;
	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public Long getTuitionFee() {
		return tuitionFee;
	}
	public void setTuitionFee(Long tuitionFee) {
		this.tuitionFee = tuitionFee;
	}
	public Long getHostelFee() {
		return hostelFee;
	}
	public void setHostelFee(Long hostelFee) {
		this.hostelFee = hostelFee;
	}
	public Long getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
