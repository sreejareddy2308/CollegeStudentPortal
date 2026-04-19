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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InternalMarks {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private int quiz1;
	private int quiz2;
	private int assignment1;
	private int assignment2;
	private int midSem;
	private int totalInternal;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_roll")
	private Student student;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id")
	private Course course;

	public int getQuiz1() {
		return quiz1;
	}

	public void setQuiz1(int quiz1) {
		this.quiz1 = quiz1;
	}

	public int getQuiz2() {
		return quiz2;
	}

	public void setQuiz2(int quiz2) {
		this.quiz2 = quiz2;
	}

	public int getAssignment1() {
		return assignment1;
	}

	public void setAssignment1(int assignment1) {
		this.assignment1 = assignment1;
	}

	public int getAssignment2() {
		return assignment2;
	}

	public void setAssignment2(int assignment2) {
		this.assignment2 = assignment2;
	}

	public int getMidSem() {
		return midSem;
	}

	public void setMidSem(int midSem) {
		this.midSem = midSem;
	}

	public int getTotalInternal() {
		return totalInternal;
	}

	public void setTotalInternal(int totalInternal) {
		this.totalInternal = totalInternal;
	}

	public void setCourse(Course course2) {
		// TODO Auto-generated method stub
		
	}

	public void setStudent(Student student2) {
		// TODO Auto-generated method stub
		
	}
}
