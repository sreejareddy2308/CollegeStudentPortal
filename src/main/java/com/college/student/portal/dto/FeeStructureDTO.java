package com.college.student.portal.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeStructureDTO {

	private Integer id;

    @NotBlank(message = "Academic year is required")
    @Pattern(
        regexp = "\\d{4}-\\d{4}",
        message = "Academic year must be in format YYYY-YYYY"
    )
    private String academicYear;

    @NotBlank(message = "Semester is required")
    @Pattern(
        regexp = "^[1-8]$",
        message = "Semester must be between 1 and 8"
    )
    private String semester;

    @NotNull(message = "Tuition fee is required")
    @Min(value = 0, message = "Tuition fee cannot be negative")
    private Long tuitionFee;

    @NotNull(message = "Hostel fee is required")
    @Min(value = 0, message = "Hostel fee cannot be negative")
    private Long hostelFee;

    private Long totalFee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}

	public String getAcademicYear() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getTuitionFee() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSemester() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getHostelFee() {
		// TODO Auto-generated method stub
		return null;
	}
}
