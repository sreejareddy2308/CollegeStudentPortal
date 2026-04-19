package com.college.student.portal.entity;

import jakarta.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExamMarks {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private int endSemMarks;
	private int totalMarks;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_roll")
	private Student student;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id")
	private Course course;

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public int getEndSemMarks() {
		return endSemMarks;
	}

	public void setEndSemMarks(int endSemMarks) {
		this.endSemMarks = endSemMarks;
	}

	public void setStudent(Student student2) {
		// TODO Auto-generated method stub
		
	}

	public void setCourse(Course course2) {
		// TODO Auto-generated method stub
		
	}
}
