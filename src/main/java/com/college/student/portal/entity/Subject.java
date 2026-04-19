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
public class Subject {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	
	public String code;
	public String name;
	public int credits;
	public String semester;
	public String department;
	public Object getCode() {
		return null;
	}
	public Object getName() {
		return null;
	}
	public Object getCredits() {
		return null;
	}
	public Object getSemester() {
		return null;
	}
	public Object getDepartment() {
		return null;
	}
	public void setCode(String code2) {
		// TODO Auto-generated method stub
		
	}
	public void setName(Object name2) {
		// TODO Auto-generated method stub
		
	}
	public void setCredits(Object credits2) {
		// TODO Auto-generated method stub
		
	}
	public void setSemester(Object semester2) {
		// TODO Auto-generated method stub
		
	}
	public void setDepartment(Object department2) {
		// TODO Auto-generated method stub
		
	}
}
