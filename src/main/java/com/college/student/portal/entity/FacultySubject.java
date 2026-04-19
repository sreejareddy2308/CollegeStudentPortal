package com.college.student.portal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
	    uniqueConstraints = @UniqueConstraint(
	        columnNames = {"faculty_id", "subject_id", "academic_year"}
	    )
	)
public class FacultySubject {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long academicYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", nullable = false)
    private FacultyProfessional facultyProfessional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

	public Long getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(Long academicYear) {
		this.academicYear = academicYear;
	}

	public void setFacultyProfessional(FacultyProfessional faculty) {
		// TODO Auto-generated method stub
		
	}

	public void setSubject(Subject subject2) {
		// TODO Auto-generated method stub
		
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
