package com.college.student.portal.entity;

import java.time.LocalDate;

import com.college.student.portal.dto.CourseStudentDTO;
import com.college.student.portal.dto.EnrollmentDTO;
import com.college.student.portal.enums.EnrollmentStatus;

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
public class Enrollment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDate enrollDate;
	
	@Enumerated(EnumType.STRING)
	private EnrollmentStatus status;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_roll")
	private Student student;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id")
	private Course course;

	public LocalDate getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(LocalDate enrollDate) {
		this.enrollDate = enrollDate;
	}

	public void setStatus(EnrollmentStatus active) {
		// TODO Auto-generated method stub
		
	}

	public void setStudent(Student student2) {
		// TODO Auto-generated method stub
		
	}

	public void setCourse(Course course2) {
		// TODO Auto-generated method stub
		
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public CourseStudentDTO getStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public EnrollmentDTO getCourse() {
		// TODO Auto-generated method stub
		return null;
	}
}
